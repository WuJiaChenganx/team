package teamWeb.teamDynamics.pojo;

import java.util.List;

public class ReportDetailBO {
    Integer id;
    String pictureUrl;
    Integer section;
    List<String> picUrl;
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public List<String> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<String> picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
