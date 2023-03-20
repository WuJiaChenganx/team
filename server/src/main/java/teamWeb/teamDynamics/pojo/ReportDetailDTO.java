package teamWeb.teamDynamics.pojo;

import java.util.List;

public class ReportDetailDTO {
    Integer id;
    Integer section;
    List<String> picUrl;
    String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
