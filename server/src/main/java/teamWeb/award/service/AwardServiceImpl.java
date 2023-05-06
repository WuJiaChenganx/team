package teamWeb.award.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.award.mapper.AwardMapper;
import teamWeb.award.pojo.AwardBO;
import teamWeb.teach.pojo.TeachAward;

import java.util.List;
@Service
public class AwardServiceImpl implements AwardService{
    @Autowired
    private AwardMapper awardMapper;
    @Override
    public List<AwardBO> award(int start, int end, String type) {
        return awardMapper.award(start,end-start,type);
    }

    @Override
    public Integer sumAward(String type) {
        return awardMapper.sumAward(type);
    }

    @Override
    public List<TeachAward> studentAward() {
        return awardMapper.studentAward();
    }
}
