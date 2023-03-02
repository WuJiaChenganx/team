package teamWeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.entity.RelationInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.entity.TextboxInfo;

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
}
