package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public APIResponse paper(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<OutcomeInfo> paperDetail = outcomeInfoService.paperDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(paperDetail);
        return APIResponse.success(params);
    }
    @RequestMapping("/Detail")
    public APIResponse getOutcome(@RequestParam(value = "id") int id){
        List<OutcomeInfo> outcome = outcomeInfoService.getOutcome(id);
        List<Object> params =new ArrayList<>();
        params.add(outcome);
        return APIResponse.success(params);
    }

    @RequestMapping("/patent")
    public APIResponse patent(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<OutcomeInfo> patentDetail = outcomeInfoService.patentDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(patentDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/monograph")
    public APIResponse monograph(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<OutcomeInfo> monographDetail = outcomeInfoService.monographDetail(start,end);
        List<Object> params =new ArrayList<>();
        params.add(monographDetail);
        return APIResponse.success(params);
    }
}
