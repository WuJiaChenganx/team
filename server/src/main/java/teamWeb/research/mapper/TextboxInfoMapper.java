package teamWeb.research.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.research.entity.TextboxInfo;

import java.util.List;

public interface TextboxInfoMapper extends BaseMapper<TextboxInfo> {
    List<TextboxInfo> getProject(int start, int end);

    List<TextboxInfo> getProjected(int start, int end);

    List<TextboxInfo> getDire(int start, int end);

    List<TextboxInfo> getPlatform(int start, int end);

    List<TextboxInfo> getTeach(int start, int end);

    List<TextboxInfo> getBrief();

    List<TextboxInfo> getEmulation(int start, int end);

    List<TextboxInfo> getData(int start, int end);

    List<RelationInfo> getRelation();

    List<TextboxInfo> getText(int id);

    void insertInfo(TextboxInfo textboxInfo);

    void updateInfo(TextboxInfo textboxInfo);

    void deleteInfo(String id);
}
