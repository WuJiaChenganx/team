package teamWeb.teamSurvey.pojo;

import teamWeb.teamSurvey.entity.EducationDO;
import teamWeb.teamSurvey.entity.PaperDO;

import java.util.List;

public class MemberDTO {
    private Integer id;
    private String name;
    private String picUrl;

    private Integer comeInDate;
    private String mClass;

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getComeInDate() {
        return comeInDate;
    }

    public void setComeInDate(Integer comeInDate) {
        this.comeInDate = comeInDate;
    }
}
