package teamWeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.entity.ReportInfo;

import java.util.List;

public interface ReportInfoMapper extends BaseMapper<ReportInfo> {
    List<ReportInfo> teamDynamic(int start, int end);

    List<ReportInfo> notice(int start, int end);

    List<ReportInfo> media(int start, int end);

    List<ReportInfo> consult(int start, int end);

    List<ReportInfo> getMeet(int start, int end);

    List<ReportInfo> getNews(int start, int end);
}
