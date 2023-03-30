package teamWeb.teamDynamics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.pojo.AllNewsBO;
import teamWeb.teamDynamics.pojo.NoticeBO;
import teamWeb.teamDynamics.pojo.ReportBO;

import java.util.List;


public interface ReportInfoService extends IService<ReportDO> {


    List<NoticeBO> teamDynamicsDetail(int start, int end);

    List<NoticeBO> noticeDetail(int start, int end);

    List<NoticeBO> mediaDetail(int start, int end);

    List<ReportDO> consultDetail(int start, int end);

    List<ReportDO> meetDetail(int start, int end);

    List<ReportDO> newsDetail(int start, int end);

    List<AllNewsBO> allNews(int start, int end);

    void insertInfo(ReportDO reportDO);

    void updateInfo(ReportDO reportDO);

    void deleteInfo(ReportDO reportDO);

    ReportBO getNews(Integer id);

    Integer sumReport(String type);

    void updateViewCount(Integer id);

    List<NoticeBO> enTeamDynamicsDetail(Integer start, Integer end);

    List<NoticeBO> enNoticeDetail(Integer start, Integer end);

    Integer sumEnReport(String type);

    List<NoticeBO> enMediaDetail(Integer start, Integer end);

    ReportBO enGetNews(Integer id);

    void updateEnViewCount(Integer id);
}
