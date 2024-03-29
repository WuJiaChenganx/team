package teamWeb.teamDynamics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.teamDynamics.entity.NoticeFile;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.pojo.ReportBO;
import teamWeb.teamDynamics.pojo.ReportDetailBO;

import java.util.List;

public interface ReportMapper extends BaseMapper<ReportDO> {
    List<ReportDO> teamDynamic(int start, int end,String nowDate);

    List<ReportDO> notice(int start, int end);

    List<ReportDO> media(int start, int end);

    List<ReportDO> consult(int start, int end);

    List<ReportDO> getMeet(int start, int end);

    List<ReportDO> getNewsDetail(int start, int end);

    List<ReportDO> allNews(int start, int end);

    void insertInfo(ReportDO reportDO);

    void updateInfo(ReportDO reportDO);

    void delete(int id);

    List<ReportDO> getNews(int id);
    ReportDO reportDetail(Integer id);

    List<NoticeFile> allFileUrl(Integer reportId);

    Integer sumReport(String type,String nowDate);

    List<ReportDetailBO> reportTextDetail(Integer reportId);

    void updateViewCount(Integer id);

    List<ReportDO> enTeamDynamic(int start, int end);

    List<ReportDO> enNotice(int start, int end);

    List<ReportDO> enMedia(int start, int end);

    ReportDO enReportDetail(Integer id);


    List<NoticeFile> allEnFileUrl(Integer reportId);

    List<ReportDetailBO> reportEnTextDetail(Integer reportId);

    void updateEnViewCount(Integer id);

    List<ReportDO> teamDynamiced(int start, int end, String nowDate);
}
