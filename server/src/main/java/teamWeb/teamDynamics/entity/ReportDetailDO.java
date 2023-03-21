package teamWeb.teamDynamics.entity;

import java.util.List;

public class ReportDetailDO {
    Integer id;
    String pictureUrl;
    Integer section;
    String text;

    String bold;

    public String getBold() {
        return bold;
    }

    public void setBold(String bold) {
        this.bold = bold;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String picUrl) {
        this.pictureUrl = picUrl;
    }

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }
}
