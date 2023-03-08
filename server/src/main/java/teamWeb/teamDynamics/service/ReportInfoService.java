package teamWeb.teamDynamics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.pojo.AllNewsBO;

import java.util.List;


public interface ReportInfoService extends IService<ReportDO> {


    List<ReportDO> teamDynamicsDetail(int start, int end);

    List<ReportDO> noticeDetail(int start, int end);

    List<ReportDO> mediaDetail(int start, int end);

    List<ReportDO> consultDetail(int start, int end);

    List<ReportDO> meetDetail(int start, int end);

    List<ReportDO> newsDetail(int start, int end);

    List<AllNewsBO> allNews(int start, int end);

    void insertInfo(ReportDO reportDO);

    void updateInfo(ReportDO reportDO);

    void deleteInfo(ReportDO reportDO);

    List<ReportDO> getNews(int id);
}
