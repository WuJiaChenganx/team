package teamWeb.research.pojo;

public class PlatformBO {
    private Integer id;
    private String text;
    private String title;
    private String InfoTitle;
    private String InfoDetail;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoTitle() {
        return InfoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        InfoTitle = infoTitle;
    }

    public String getInfoDetail() {
        return InfoDetail;
    }

    public void setInfoDetail(String infoDetail) {
        InfoDetail = infoDetail;
    }
}
