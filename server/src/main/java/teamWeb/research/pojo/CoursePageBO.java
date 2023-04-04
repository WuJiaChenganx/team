package teamWeb.research.pojo;

import teamWeb.research.entity.CourseDO;

import java.util.List;

public class CoursePageBO {
    private Integer id;
    private String title;
    private String profile;
    private List<CourseDO> courseList;

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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<CourseDO> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseDO> courseList) {
        this.courseList = courseList;
    }
}
