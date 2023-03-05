package teamWeb.entity;

public class TextboxInfo {
    private String id;
    private String title;
    private String text;
    private String pictureUrl;
    private String fileUrl;

    private String tClass;

    private String sDate;
    private String eDate;

    public String gettClass() {
        return tClass;
    }

    public void settClass(String tClass) {
        this.tClass = tClass;
    }

    @Override
    public String toString() {
        return "TextboxInfo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", sDate='" + sDate + '\'' +
                ", eDate='" + eDate + '\'' +
                '}';
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public TextboxInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
