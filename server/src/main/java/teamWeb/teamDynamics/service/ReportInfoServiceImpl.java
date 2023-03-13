package teamWeb.teamDynamics.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.teamDynamics.entity.ReportDO;
import teamWeb.teamDynamics.mapper.ReportMapper;
import teamWeb.teamDynamics.pojo.AllNewsBO;
import teamWeb.teamDynamics.pojo.NoticeBO;
import teamWeb.teamDynamics.pojo.ReportBO;
import teamWeb.teamSurvey.pojo.MemberBO;
import teamWeb.utils.BeanUtil;

import java.util.List;



@Service
public class ReportInfoServiceImpl extends ServiceImpl<ReportMapper, ReportDO> implements ReportInfoService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<NoticeBO> teamDynamicsDetail(int start, int end) {
        List<NoticeBO> noticeBOList = BeanUtil.convert(reportMapper.teamDynamic(start,end),NoticeBO.class);
        for (NoticeBO noticeBO:
                noticeBOList) {
            noticeBO.setDay(noticeBO.getDate().split("-")[2]);
            noticeBO.setDate(noticeBO.getDate().substring(0, 7));
            noticeBO.setDetail(noticeBO.getText());
            noticeBO.setText("");
        }
        return noticeBOList;
    }

    @Override
    public List<NoticeBO> noticeDetail(int start, int end) {
        List<NoticeBO> noticeBOList = BeanUtil.convert(reportMapper.notice(start,end),NoticeBO.class);
        for (NoticeBO noticeBO:
                noticeBOList) {
            noticeBO.setDay(noticeBO.getDate().split("-")[2]);
            noticeBO.setDate(noticeBO.getDate().substring(0, 7));
            noticeBO.setDetail(noticeBO.getText());
            noticeBO.setText("");
        }
        return noticeBOList;
    }

    @Override
    public List<NoticeBO> mediaDetail(int start, int end) {
        List<NoticeBO> noticeBOList = BeanUtil.convert(reportMapper.media(start,end),NoticeBO.class);
        for (NoticeBO noticeBO:
                noticeBOList) {
            noticeBO.setDay(noticeBO.getDate().split("-")[2]);
            noticeBO.setDate(noticeBO.getDate().substring(0, 7));
            noticeBO.setDetail(noticeBO.getText());
            noticeBO.setText("");
        }
        return noticeBOList;
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
    public List<ReportBO> getNews(Integer id) {
        List<ReportDO> reportDOList = reportMapper.reportDetail(id);
        List<ReportBO> reportBOList = BeanUtil.convert(reportDOList,ReportBO.class);
        for (ReportBO reportBO:
                reportBOList) {
            Integer reportId = reportBO.getId();
            reportBO.setFileUrls(reportMapper.allFileUrl(reportId));
            reportBO.setPicUrl(reportBO.getPictureUrl());
            reportBO.setDetail(reportBO.getText());
            reportBO.setDay(reportBO.getDate().split("-")[2]);
            reportBO.setDate(reportBO.getDate().substring(0, 7));
        }
        return reportBOList;
    }

    @Override
    public Integer sumReport(String type) {

        return reportMapper.sumReport(type);
    }
}
