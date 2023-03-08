package teamWeb.teamDynamics.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.mapper.ReportMapper;
import teamWeb.teamDynamics.pojo.AllNewsBO;
import teamWeb.utils.BeanUtil;

import java.util.List;



@Service
public class ReportInfoServiceImpl extends ServiceImpl<ReportMapper, ReportDO> implements ReportInfoService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<ReportDO> teamDynamicsDetail(int start, int end) {
        return reportMapper.teamDynamic(start,end);
    }

    @Override
    public List<ReportDO> noticeDetail(int start, int end) {
        return reportMapper.notice(start,end);
    }

    @Override
    public List<ReportDO> mediaDetail(int start, int end) {
        return reportMapper.media(start,end);
    }

    @Override
    public List<ReportDO> consultDetail(int start, int end) {
        return reportMapper.consult(start,end);
    }

    @Override
    public List<ReportDO> meetDetail(int start, int end) {
        return reportMapper.getMeet(start,end);
    }

    @Override
    public List<ReportDO> newsDetail(int start, int end) {
        return reportMapper.getNewsDetail(start,end);
    }

    @Override
    public List<AllNewsBO> allNews(int start, int end) {
        List<ReportDO> reportDOList = reportMapper.allNews(start, end);

        return BeanUtil.convert(reportDOList, AllNewsBO.class);
    }

    @Override
    public void insertInfo(ReportDO reportDO) {
        reportMapper.insertInfo(reportDO);
    }

    @Override
    public void updateInfo(ReportDO reportDO) {
        reportMapper.updateInfo(reportDO);
    }

    @Override
    public void deleteInfo(ReportDO reportDO) {
        reportMapper.delete(reportDO.getId());
    }

    @Override
    public List<ReportDO> getNews(int id) {
        return reportMapper.getNews(id);
    }
}
