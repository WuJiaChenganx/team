package teamWeb.pubications.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.pubications.entity.OutcomeInfo;
import teamWeb.pubications.pojo.AllMonographBO;
import teamWeb.pubications.pojo.AllPaperBO;

import java.util.List;

public interface OutcomeInfoService extends IService<OutcomeInfo> {
    List<AllPaperBO> paperDetail(int start, int end);

    List<AllPaperBO> patentDetail(int start, int end);

    List<AllMonographBO> monographDetail(int start, int end);


    void insertInfo(OutcomeInfo outcomeInfo);

    void updateInfo(OutcomeInfo outcomeInfo);

    void deleteInfo(OutcomeInfo outcomeInfo);
}
