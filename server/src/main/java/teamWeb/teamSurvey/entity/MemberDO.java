package teamWeb.teamSurvey.entity;

public class MemberDO {
    private Integer id;
    private String name;
    private String pictureUrl;
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
    //类别
    private String mClass;

    private Integer comeInDate;

    public Integer getComeInDate() {
        return comeInDate;
    }

    public void setComeInDate(Integer comeInDate) {
        this.comeInDate = comeInDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
