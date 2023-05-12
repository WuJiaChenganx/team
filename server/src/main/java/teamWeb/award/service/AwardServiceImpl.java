package teamWeb.award.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.award.mapper.AwardMapper;
import teamWeb.award.pojo.AwardBO;
import teamWeb.teach.pojo.TeachAwardBO;

import java.util.List;
@Service
public class AwardServiceImpl implements AwardService{
    @Autowired
    private AwardMapper awardMapper;

    @Override
    public List<AwardBO> award(int start, int end, String type, String award, String title, String date) {
        return awardMapper.award(start,end-start,type,award,title,date);
    }

    @Override
    public Integer sumAward(String type) {
        return awardMapper.sumAward(type);
    }

    @Override
    public List<TeachAwardBO> studentAward() {
        return awardMapper.studentAward();
    }
}
