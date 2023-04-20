package teamWeb.research.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.research.entity.CourseDO;
import teamWeb.research.entity.ProjectDO;
import teamWeb.research.entity.ProjectInfo;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.pojo.CoursePageBO;

import java.util.List;

public interface TextboxInfoMapper extends BaseMapper<TextboxInfo> {
    List<ProjectDO> getProject(int start, int end);

    List<TextboxInfo> getProjected(int start, int end);

    List<TextboxInfo> getDire();

    List<TextboxInfo> getPlatform(int start, int end);

    List<CoursePageBO> teachDetail();

    List<CourseDO> allCourse(Integer id);

    List<TextboxInfo> getBrief();

    List<TextboxInfo> getEmulation(int start, int end);

    List<TextboxInfo> getData(int start, int end);

    List<RelationInfo> getRelation();

    List<TextboxInfo> getText(int id);

    void insertInfo(TextboxInfo textboxInfo);

    void updateInfo(TextboxInfo textboxInfo);

    void deleteInfo(Integer id);

    Integer sumPaper();

    Integer sumTextbox(String type);

    Integer sumProject();

    List<ProjectDO> getEnProject(int start, int end);

    Integer sumEnProject();

    List<TextboxInfo> getEnDire(int start, int end);

    Integer sumEnTextbox(String type);

    List<TextboxInfo> getEnData(int start, int end);

    List<TextboxInfo> getEnEmulation(int start, int end);

    ProjectDO projectTitle(Integer projectId);

    List<ProjectInfo> projectInfo(Integer projectId);

    String sumDire();

}
