package teamWeb.research.entity;

import java.util.List;

public class ProjectInfo {
    private Integer id;
    private String info;
    private Integer projectIndex;
    private String picture;
    private List<String> pic;


    public List<String> getPic() {
        return pic;
    }

    public void setPic(List<String> pic) {
        this.pic = pic;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getProjectIndex() {
        return projectIndex;
    }

    public void setProjectIndex(Integer projectIndex) {
        this.projectIndex = projectIndex;
    }
}
