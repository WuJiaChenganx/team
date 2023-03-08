package teamWeb.pubications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.pubications.entity.OutcomeInfo;
import teamWeb.pubications.service.OutcomeInfoService;
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
        return APIResponse.success(paperDetail);
    }
    @RequestMapping("/Detail")
    public APIResponse getOutcome(@RequestParam(value = "id") int id){
        List<OutcomeInfo> outcome = outcomeInfoService.getOutcome(id);
        return APIResponse.success(outcome);
    }

    @RequestMapping("/patent")
    public APIResponse patent(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<OutcomeInfo> patentDetail = outcomeInfoService.patentDetail(start,end);
        return APIResponse.success(patentDetail);
    }

    @RequestMapping("/monograph")
    public APIResponse monograph(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<OutcomeInfo> monographDetail = outcomeInfoService.monographDetail(start,end);
        return APIResponse.success(monographDetail);
    }
}
