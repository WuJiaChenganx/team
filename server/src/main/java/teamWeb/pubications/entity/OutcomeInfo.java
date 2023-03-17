package teamWeb.pubications.entity;

import java.io.Serializable;
import java.sql.Date;

public class OutcomeInfo implements Serializable {

    //论文id
    private Integer id;
    //论文名
    private String title;

    //作者
    private String author;
    //发表时间
    private String date;
    //期刊
    private String perio;
    //出版社
    private String pub;
    //图片地址
    private String pictureUrl;
    //论文链接
    private String url;
    private String detail;
    private String keyword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPerio() {
        return perio;
    }

    public void setPerio(String perio) {
        this.perio = perio;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
