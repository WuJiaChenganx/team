package teamWeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.entity.OutcomeInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.mapper.OutcomeInfoMapper;
import teamWeb.service.OutcomeInfoService;

import java.util.List;

@Service
public class OutcomeInfoServiceImpl extends ServiceImpl<OutcomeInfoMapper, OutcomeInfo> implements OutcomeInfoService {

    @Autowired
    OutcomeInfoMapper outcomeInfoMapper;

    @Override
    public List<OutcomeInfo> paperDetail(int start, int end) {
        return outcomeInfoMapper.getPaperDetail(start,end);
    }

    @Override
    public List<OutcomeInfo> patentDetail(int start, int end) {
        return outcomeInfoMapper.getPatentDetail(start,end);
    }

    @Override
    public List<OutcomeInfo> monographDetail(int start, int end) {
        return outcomeInfoMapper.getMonographDetail(start,end);
    }

    @Override
    public List<OutcomeInfo> getOutcome(int id) {
        return outcomeInfoMapper.getOutcome(id);
    }

    @Override
    public void insertInfo(OutcomeInfo outcomeInfo) {
        outcomeInfoMapper.insertInfo(outcomeInfo);
    }

    @Override
    public void updateInfo(OutcomeInfo outcomeInfo) {
        outcomeInfoMapper.updateInfo(outcomeInfo);
    }

    @Override
    public void deleteInfo(OutcomeInfo outcomeInfo) {
        outcomeInfoMapper.deleteInfo(outcomeInfo.getId());
    }
}
