package manage.Controller;
import manage.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.service.MemberInfoService;
import teamWeb.service.ReportInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    ManageService manageService;
    @Autowired
    ReportInfoService reportInfoService;

    /*
    @RequestMapping("/news")
    public APIResponse news(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<ReportInfo> news = reportInfoService.allNews(start,end);
        List<Object> params =new ArrayList<>();
        params.add(news);
        return APIResponse.success(params);
    }*/
    @RequestMapping("/news")
    public APIResponse news(@RequestParam(value="operate") String operate,ReportInfo reportInfo){
        if(Objects.equals(operate, "input")){
            reportInfoService.insertInfo(reportInfo);
        } else if (Objects.equals(operate, "updata")) {
            reportInfoService.updateInfo(reportInfo);
        }else {
            reportInfoService.deleteInfo(reportInfo);
        }
        return APIResponse.success();
    }

}
