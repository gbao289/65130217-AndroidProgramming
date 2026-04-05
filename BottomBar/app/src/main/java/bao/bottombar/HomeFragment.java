package bao.bottombar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    ArrayList<News> list = new ArrayList<>();
    NewsAdapter adapter;
    private String rssUrl = "https://vnexpress.net/rss/giao-duc.rss";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new NewsAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        loadRSS();

        return view;
    }
    private void loadRSS() {
        new Thread(() -> {
            parseRSS();
            requireActivity().runOnUiThread(() -> adapter.notifyDataSetChanged());
        }).start();
    }
    private void parseRSS() {
        try {
            URL url = new URL(rssUrl);
            InputStream input = url.openConnection().getInputStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(input, null);

            boolean isInsideItem = false;
            String title = "", link = "", date = "", image = "";

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();

                if (eventType == XmlPullParser.START_TAG) {

                    if ("item".equals(tagName)) {
                        isInsideItem = true;
                    }

                    if (isInsideItem) {
                        if ("title".equals(tagName)) {
                            title = parser.nextText();
                        } else if ("link".equals(tagName)) {
                            link = parser.nextText();
                        } else if ("pubDate".equals(tagName)) {
                            date = parser.nextText();
                        } else if ("description".equals(tagName)) {
                            String desc = parser.nextText();

                            if (desc.contains("src=\"")) {
                                int start = desc.indexOf("src=\"") + 5;
                                int end = desc.indexOf("\"", start);
                                image = desc.substring(start, end);
                            }
                        }
                    }
                }

                if (eventType == XmlPullParser.END_TAG && "item".equals(tagName)) {
                    isInsideItem = false;
                    list.add(new News(title, link, image, date));
                }

                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setRssUrl(String url) {
        this.rssUrl = url;
        list.clear();          // xóa dữ liệu cũ
        loadRSS();             // load lại RSS mới
    }
}