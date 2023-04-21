package teamWeb.research.entity;

public class ProjectDO {
    private Integer id;
    private String projectName;
    private String responser;
    private String projectType;
    private String time;
    private String projectInfo;
    private String projectDire;

    public String getProjectDire() {
        return projectDire;
    }

    public void setProjectDire(String projectDire) {
        this.projectDire = projectDire;
    }

    public String getResponser() {
        return responser;
    }

    public void setResponser(String responser) {
        this.responser = responser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }
}
