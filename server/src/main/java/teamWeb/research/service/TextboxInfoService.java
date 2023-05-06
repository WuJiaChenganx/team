package teamWeb.research.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.pojo.*;
import teamWeb.resource.pojo.ResourceBO;

import java.util.List;

public interface TextboxInfoService extends IService<TextboxInfo> {

    List<TextboxInfo> briefDetail();

    List<ProjectBO> projectDetail(int start, int end,String direType);

    List<DirectionsDTO> direDetail();

    List<PlatformDTO> platformDetail(int start, int end);

    List<CoursePageBO> teachDetail(int start,int end,String type);

    List<ResourceBO> emulationDetail(int start, int end);

    List<ResourceBO> dataDetail(int start, int end);

    List<RelationInfo> relationDetail();

    List<TextboxInfo> getText(int id);

    void insertInfo(TextboxInfo textboxInfo);

    void updateInfo(TextboxInfo textboxInfo);

    void deleteInfo(TextboxInfo textboxInfo);

    Integer sumProject(String direType);

    Integer sumTextbox(String type);

    List<ProjectBO> enProjectDetail(int start, int end);

    Integer sumEnProject();

    List<DirectionsDTO> enDireDetail(int start, int end);

    Integer sumEnTextbox(String type);

    List<ResourceBO> enDataDetail(int start, int end);

    List<ResourceBO> enEmulationDetail(int start, int end);

    ProjectBO projectInfo(Integer projectId);

    String sumDire();

    Integer sumCourse(String type);

    String teachBrief();
}