package teamWeb.teamDynamics.pojo;

import teamWeb.teamDynamics.entity.NoticeFile;
import teamWeb.teamDynamics.entity.ReportDetailDO;

import java.util.List;
import java.util.Map;

public class ReportBO {
    private Integer id;
    private String date;
    private String title;
    private String url;
    private String pictureUrl;
    private String text;
    private String rClass;
    private List<ReportDetailDTO> detail;
    private List<String> picUrl;
    private String day;
    private List<NoticeFile> fileUrls;
    private String paperName;
    private Integer pageView;

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getrClass() {
        return rClass;
    }

    public void setrClass(String rClass) {
        this.rClass = rClass;
    }


    public List<ReportDetailDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<ReportDetailDTO> detail) {
        this.detail = detail;
    }

    public List<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<String> picUrl) {
        this.picUrl = picUrl;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<NoticeFile> getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(List<NoticeFile> fileUrls) {
        this.fileUrls = fileUrls;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
