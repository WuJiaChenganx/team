package teamWeb.manage.server;

import teamWeb.teamDynamics.entity.ReportDO;

import java.util.List;

public interface ManageService  {

    List<ReportDO> showNews(int start, int end);
}
