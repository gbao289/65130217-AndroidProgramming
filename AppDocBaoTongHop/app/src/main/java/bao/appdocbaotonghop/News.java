package bao.appdocbaotonghop;

public class News {
    String title;
    String link;
    String description;

    public News(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getLink() { return link; }
    public String getDescription() { return description; }
}
