package teamWeb.pubications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.pubications.entity.OutcomeInfo;
import teamWeb.pubications.pojo.AllMonographBO;
import teamWeb.pubications.pojo.AllPaperBO;
import teamWeb.pubications.service.OutcomeInfoService;
import teamWeb.utils.APIResponse;
import teamWeb.utils.Address;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/paper")
public class PaperController {
    @Autowired
    OutcomeInfoService outcomeInfoService;

    @GetMapping("/require-paper")
    public APIResponse paper(@RequestParam(value="start") int start, @RequestParam(value="end") int end, HttpServletRequest request){
        List<AllPaperBO> paperBOList = outcomeInfoService.paperDetail(start,end);

        return APIResponse.success(paperBOList,outcomeInfoService.sumOutcome("论文"));
    }

    @GetMapping("/require-patent")
    public APIResponse patent(@RequestParam(value="start") int start,@RequestParam(value="end") int end){
        List<AllPaperBO> patentList = outcomeInfoService.patentDetail(start,end);
        return APIResponse.success(patentList,outcomeInfoService.sumOutcome("专利"));
    }

    @GetMapping("/require-monograph")
    public APIResponse monograph(@RequestParam(value="start") int start,@RequestParam(value="end") int end,HttpServletRequest request){
        List<AllMonographBO> monographBOList = outcomeInfoService.monographDetail(start,end);
        return APIResponse.success(monographBOList,outcomeInfoService.sumOutcome("专著"));
    }
}
