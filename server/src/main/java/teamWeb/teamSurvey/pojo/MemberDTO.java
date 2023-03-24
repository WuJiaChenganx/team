package teamWeb.teamSurvey.pojo;

import teamWeb.teamSurvey.entity.EducationDO;
import teamWeb.teamSurvey.entity.PaperDO;

import java.util.List;

public class MemberDTO {
    private Integer id;
    private String name;
    private String picUrl;

    private Integer comeInDate;
    private String memberType;
    private String title;
    private String pageUrl;

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
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
