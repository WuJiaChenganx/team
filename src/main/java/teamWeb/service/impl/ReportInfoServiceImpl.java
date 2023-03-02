package teamWeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.entity.ReportInfo;
import teamWeb.mapper.ReportInfoMapper;
import teamWeb.service.ReportInfoService;

import java.util.List;



@Service
public class ReportInfoServiceImpl extends ServiceImpl<ReportInfoMapper, ReportInfo> implements ReportInfoService {
    @Autowired
    ReportInfoMapper reportInfoMapper;

    @Override
    public List<ReportInfo> teamDynamicsDetail(int start, int end) {
        return reportInfoMapper.teamDynamic(start,end);
    }

    @Override
    public List<ReportInfo> noticeDetail(int start, int end) {
        return reportInfoMapper.notice(start,end);
    }

    @Override
    public List<ReportInfo> mediaDetail(int start, int end) {
        return reportInfoMapper.media(start,end);
    }

    @Override
    public List<ReportInfo> consultDetail(int start, int end) {
        return reportInfoMapper.consult(start,end);
    }

    @Override
    public List<ReportInfo> meetDetail(int start, int end) {
        return reportInfoMapper.getMeet(start,end);
    }

    @Override
    public List<ReportInfo> newsDetail(int start, int end) {
        return reportInfoMapper.getNews(start,end);
    }
}
