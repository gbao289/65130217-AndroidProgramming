package bao.appdocbaotonghop;

import android.os.AsyncTask;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class RSSParser extends AsyncTask<String, Void, ArrayList<News>> {

    public interface OnDataParsed {
        void onParsed(ArrayList<News> list);
    }

    OnDataParsed listener;

    public RSSParser(OnDataParsed listener) {
        this.listener = listener;
    }

    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        ArrayList<News> list = new ArrayList<>();

        try {
            URL url = new URL(strings[0]);
            InputStream input = url.openConnection().getInputStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(input, "UTF-8");

            boolean insideItem = false;
            String title = "", link = "", description = "";

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = parser.getName();

                if (eventType == XmlPullParser.START_TAG) {
                    if (name.equalsIgnoreCase("item")) {
                        insideItem = true;
                    } else if (insideItem) {
                        if (name.equalsIgnoreCase("title")) {
                            title = parser.nextText();
                        } else if (name.equalsIgnoreCase("link")) {
                            link = parser.nextText();
                        } else if (name.equalsIgnoreCase("description")) {
                            description = parser.nextText();
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG && name.equalsIgnoreCase("item")) {
                    list.add(new News(title, link, description));
                    insideItem = false;
                }

                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<News> news) {
        listener.onParsed(news);
    }
}
