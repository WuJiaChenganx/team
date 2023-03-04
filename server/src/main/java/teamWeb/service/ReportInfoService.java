package teamWeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import teamWeb.entity.ReportInfo;

import java.util.List;


public interface ReportInfoService extends IService<ReportInfo> {


    List<ReportInfo> teamDynamicsDetail(int start, int end);

    List<ReportInfo> noticeDetail(int start, int end);

    List<ReportInfo> mediaDetail(int start, int end);

    List<ReportInfo> consultDetail(int start, int end);

    List<ReportInfo> meetDetail(int start, int end);

    List<ReportInfo> newsDetail(int start, int end);

    List<ReportInfo> allNews(int start, int end);

    void insertInfo(ReportInfo reportInfo);

    void updateInfo(ReportInfo reportInfo);

    void deleteInfo(ReportInfo reportInfo);

    List<ReportInfo> getNews(int id);
}
