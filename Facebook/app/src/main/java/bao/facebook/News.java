package bao.facebook;

public class News {
    String title, link, image, date;

    public News(String title, String link, String image, String date) {
        this.title = title;
        this.link = link;
        this.image = image;
        this.date = date;
    }

    public String getTitle() { return title; }
    public String getLink() { return link; }
    public String getImage() { return image; }
    public String getDate() { return date; }
}
