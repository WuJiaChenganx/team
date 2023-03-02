package teamWeb.entity;

public class MemberInfo {
    private String id;
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
    private String mail;
    //主页地址
    private String pageUrl;
    // 个人荣誉
    private String prize;
    //学历头衔
    private String edu;
    //研究方向
    private String research;
    //类别
    private int mClass;

    @Override
    public String toString() {
        return "MemberInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", job='" + job + '\'' +
                ", resume='" + resume + '\'' +
                ", society='" + society + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", pageUrl='" + pageUrl + '\'' +
                ", prize='" + prize + '\'' +
                ", edu='" + edu + '\'' +
                ", research='" + research + '\'' +
                ", mClass='" + mClass + '\'' +
                '}';
    }

    public int getmClass() {
        return mClass;
    }

    public void setmClass(int mClass) {
        this.mClass = mClass;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public MemberInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
}
