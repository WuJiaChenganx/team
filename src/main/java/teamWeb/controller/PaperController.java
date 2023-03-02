package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.entity.OutcomeInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.service.OutcomeInfoService;
import teamWeb.service.ReportInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/paper")
public class PaperController {
    @Autowired
    OutcomeInfoService outcomeInfoService;

    @RequestMapping("/paper")
    public APIResponse paper(@RequestParam(value="page") int page){
        List<OutcomeInfo> paperDetail = outcomeInfoService.paperDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(paperDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/patent")
    public APIResponse patent(@RequestParam(value="page") int page){
        List<OutcomeInfo> patentDetail = outcomeInfoService.patentDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(patentDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/monograph")
    public APIResponse monograph(@RequestParam(value="page") int page){
        List<OutcomeInfo> monographDetail = outcomeInfoService.monographDetail((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(monographDetail);
        return APIResponse.success(params);
    }
}
