package teamWeb.pubications.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.pubications.entity.OutcomeInfo;

import java.util.List;

public interface OutcomeInfoMapper extends BaseMapper<OutcomeInfo> {

    List<OutcomeInfo> getPaperDetail(int start, int end);

    List<OutcomeInfo> getPatentDetail(int start, int end);

    List<OutcomeInfo> getMonographDetail(int start, int end);

    List<OutcomeInfo> getOutcome(int id);

    void insertInfo(OutcomeInfo outcomeInfo);

    void updateInfo(OutcomeInfo outcomeInfo);

    void deleteInfo(int id);
}
