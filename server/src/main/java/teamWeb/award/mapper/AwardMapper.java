package teamWeb.award.mapper;

import teamWeb.award.pojo.AwardBO;
import teamWeb.teach.pojo.TeachAwardBO;

import java.util.List;

public interface AwardMapper {
    List<AwardBO> award(int start, int end, String type,String award,String title,String date);

    Integer sumAward(String type);

    List<TeachAwardBO> studentAward();
}
