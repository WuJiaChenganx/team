package manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.OutcomeInfo;
import teamWeb.entity.ReportInfo;

import java.util.List;

public interface ManageService  {

    List<ReportInfo> showNews(int start, int end);
}
