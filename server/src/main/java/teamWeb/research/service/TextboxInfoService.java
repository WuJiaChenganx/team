package teamWeb.research.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.research.pojo.*;
import teamWeb.resource.pojo.ResourceBO;

import java.util.List;

public interface TextboxInfoService extends IService<TextboxInfo> {

    List<TextboxInfo> briefDetail();

    List<ProjectBO> projectDetail(int start, int end);

    List<DirectionsDTO> direDetail(int start, int end);

    List<PlatformDTO> platformDetail(int start, int end);

    List<CoursePageBO> teachDetail();

    List<ResourceBO> emulationDetail(int start, int end);

    List<ResourceBO> dataDetail(int start, int end);

    List<RelationInfo> getRelation();

    List<TextboxInfo> getText(int id);

    void insertInfo(TextboxInfo textboxInfo);

    void updateInfo(TextboxInfo textboxInfo);

    void deleteInfo(TextboxInfo textboxInfo);
}