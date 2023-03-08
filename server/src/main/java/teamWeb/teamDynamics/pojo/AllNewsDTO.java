package teamWeb.teamDynamics.pojo;

public class AllNewsDTO {
    private String date;
    private String title;
    private String url;
    private String pictureUrl;
    private String text;
    private Integer rClass;

    private String addThing;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getrClass() {
        return rClass;
    }

    public void setrClass(Integer rClass) {
        this.rClass = rClass;
    }

    public String getAddThing() {
        return addThing;
    }

    public void setAddThing(String addThing) {
        this.addThing = addThing;
    }
}
