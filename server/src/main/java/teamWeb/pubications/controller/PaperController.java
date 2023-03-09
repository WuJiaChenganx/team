package teamWeb.pubications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.pubications.entity.OutcomeInfo;
import teamWeb.pubications.pojo.AllMonographBO;
import teamWeb.pubications.pojo.AllPaperBO;
import teamWeb.pubications.service.OutcomeInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/paper")
public class PaperController {
    @Autowired
    OutcomeInfoService outcomeInfoService;

    @RequestMapping("/require-paper")
    public APIResponse paper(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<AllPaperBO> paperBOList = outcomeInfoService.paperDetail(start,end);
        return APIResponse.success(paperBOList);
    }

    @RequestMapping("/require-patent")
    public APIResponse patent(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<AllPaperBO> patentList = outcomeInfoService.patentDetail(start,end);
        return APIResponse.success(patentList);
    }

    @RequestMapping("/require-monograph")
    public APIResponse monograph(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<AllMonographBO> monographBOList = outcomeInfoService.monographDetail(start,end);
        return APIResponse.success(monographBOList);
    }
}
