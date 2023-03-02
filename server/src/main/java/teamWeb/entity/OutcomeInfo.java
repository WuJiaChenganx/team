package teamWeb.entity;

import java.io.Serializable;
import java.sql.Date;

public class OutcomeInfo implements Serializable {

    //论文id
    private String pId;
    //论文名
    private String title;
    //作者
    private String author;
    //发表时间
    private Date date;
    //期刊
    private String perio;
    //申请人
    private String proposer;
    //发明人
    private String inventor;
    //授权人
    private String authorization;
    //出版社
    private String pub;
    //图片地址
    private String pictureUrl;
    //论文链接
    private String url;

    public OutcomeInfo() {
    }

    @Override
    public String toString() {
        return "OutcomeInfo{" +
                "pId='" + pId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", perio='" + perio + '\'' +
                ", proposer='" + proposer + '\'' +
                ", inventor='" + inventor + '\'' +
                ", authorization='" + authorization + '\'' +
                ", pub='" + pub + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPerio() {
        return perio;
    }

    public void setPerio(String perio) {
        this.perio = perio;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
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
}
