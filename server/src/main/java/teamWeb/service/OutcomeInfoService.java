package teamWeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.entity.OutcomeInfo;

import java.util.List;

public interface OutcomeInfoService extends IService<OutcomeInfo> {
    List<OutcomeInfo> paperDetail(int start, int end);

    List<OutcomeInfo> patentDetail(int start, int end);

    List<OutcomeInfo> monographDetail(int start, int end);

    List<OutcomeInfo> getOutcome(int id);

    void insertInfo(OutcomeInfo outcomeInfo);

    void updateInfo(OutcomeInfo outcomeInfo);

    void deleteInfo(OutcomeInfo outcomeInfo);
}
