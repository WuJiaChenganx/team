package teamWeb.pubications.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.pubications.entity.OutcomeInfo;
import teamWeb.pubications.mapper.OutcomeInfoMapper;
import teamWeb.pubications.pojo.AllMonographBO;
import teamWeb.pubications.pojo.AllPaperBO;
import teamWeb.teamSurvey.pojo.MemberBO;
import teamWeb.utils.Address;
import teamWeb.utils.BeanUtil;

import java.util.List;

@Service
public class OutcomeInfoServiceImpl extends ServiceImpl<OutcomeInfoMapper, OutcomeInfo> implements OutcomeInfoService {

    @Autowired
    OutcomeInfoMapper outcomeInfoMapper;

    @Override
    public List<AllPaperBO> paperDetail(int start, int end) {
        return BeanUtil.convert(outcomeInfoMapper.paperDetail(start,end-start),AllPaperBO.class);
    }

    @Override
    public List<AllPaperBO> patentDetail(int start, int end) {
        List<AllPaperBO> allPaperBOList = BeanUtil.convert(outcomeInfoMapper.patentDetail(start,end-start),AllPaperBO.class);
        Integer numberIndex = 1;
        for (AllPaperBO allPaperBO:
                allPaperBOList) {
            allPaperBO.setNumber(start+numberIndex);
            numberIndex = numberIndex+1;
        }
        return allPaperBOList;
    }

    @Override
    public List<AllMonographBO> monographDetail(int start, int end) {
        List<AllMonographBO> allMonographBOList = BeanUtil.convert(outcomeInfoMapper.monographDetail(start,end-start),AllMonographBO.class);

        Integer numberIndex = 1;

        for (AllMonographBO allMonographBO:
                allMonographBOList) {
            if(!allMonographBO.getPictureUrl().equals("")) {
                allMonographBO.setPictureUrl(Address.rootAddress() + allMonographBO.getPictureUrl());
            }
            allMonographBO.setNumber(start+numberIndex);
            numberIndex = numberIndex+1;
        }
        return allMonographBOList;
    }

    @Override
    public Integer sumOutcome(String type) {
        return outcomeInfoMapper.sumOutcome(type);
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
