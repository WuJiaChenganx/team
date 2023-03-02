package teamWeb.entity;

import java.sql.Date;

public class ReportInfo {
    private int id;
    private String date;
    private String title;
    private String url;
    private String pictureUrl;
    private String text;

    public ReportInfo() {
    }

    @Override
    public String toString() {
        return "ReportInfo{" +
                "id=" + id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
