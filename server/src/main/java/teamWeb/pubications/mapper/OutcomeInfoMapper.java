package teamWeb.pubications.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.pubications.entity.OutcomeInfo;

import java.util.List;

public interface OutcomeInfoMapper extends BaseMapper<OutcomeInfo> {

    List<OutcomeInfo> paperDetail(int start, int end);

    List<OutcomeInfo> patentDetail(int start, int end);

    List<OutcomeInfo> monographDetail(int start, int end);

    Integer sumOutcome(String type);
    void insertInfo(OutcomeInfo outcomeInfo);

    void updateInfo(OutcomeInfo outcomeInfo);

    void deleteInfo(int id);

    List<OutcomeInfo> enPaperDetail(int start, int end);

    List<OutcomeInfo> enPatentDetail(int start, int end);
    List<OutcomeInfo> enMonographDetail(int start, int end);

    Integer sumEnOutcome(String type);
}
