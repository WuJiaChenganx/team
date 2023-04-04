package teamWeb.teamSurvey.pojo;

import teamWeb.teamSurvey.entity.EducationDO;
import teamWeb.teamSurvey.entity.PaperDO;

import java.util.List;

public class MemberBO {
    private Integer id;
    private String name;
    private String pictureUrl;
    private String picUrl;
    // 单位职务
    private String job;
    // 简介
    private String resume;
    //社会服务
    private String society;
    //办公地址
    private String address;
    private String email;
    //主页地址
    private String pageUrl;
    // 个人荣誉
    private String prize;
    //学历头衔
    private String edu;
    //研究方向
    private String research;
    private String title;
    //类别
    private String mClass;
    private String memberType;

    private String direction;
    private List<String> info;

    private List<EducationDO> educationList;

    private List<PaperDO> paperList;

    private Integer comeInDate;

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public Integer getComeInDate() {
        return comeInDate;
    }

    public void setComeInDate(Integer comeInDate) {
        this.comeInDate = comeInDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getmClass() {
        return mClass;
    }

    public void setmClass(String mClass) {
        this.mClass = mClass;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<EducationDO> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<EducationDO> educationList) {
        this.educationList = educationList;
    }

    public List<PaperDO> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<PaperDO> paperList) {
        this.paperList = paperList;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
