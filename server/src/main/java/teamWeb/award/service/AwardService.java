package teamWeb.award.service;

import org.springframework.stereotype.Service;
import teamWeb.award.pojo.AwardBO;

import java.util.List;

public interface AwardService {
    List<AwardBO> award(int start, int end, String type);

    Integer sumAward(String type);
}
