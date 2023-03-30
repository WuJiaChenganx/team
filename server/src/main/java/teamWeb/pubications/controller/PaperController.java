package teamWeb.pubications.controller;

import com.sun.org.apache.bcel.internal.generic.LADD;
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
    public APIResponse paper(@RequestParam(value="start") int start,
                             @RequestParam(value="end") int end,
                             @RequestParam(value = "languageType") String language){
        List<AllPaperBO> paperBOList = null;
        Integer sum = null;
        if (language.equals("Chinese")) {
            paperBOList = outcomeInfoService.paperDetail(start, end);
            sum = outcomeInfoService.sumOutcome("论文");
        }else if (language.equals("English")){
            paperBOList = outcomeInfoService.enPaperDetail(start, end);
            sum = outcomeInfoService.sumEnOutcome("论文");
        }
        return APIResponse.success(paperBOList,sum);
    }

    @GetMapping("/require-patent")
    public APIResponse patent(@RequestParam(value="start") int start,
                              @RequestParam(value="end") int end,
                              @RequestParam(value = "languageType") String language){
        List<AllPaperBO> patentList = null;
        Integer sum = null;
        if (language.equals("Chinese")) {
            patentList = outcomeInfoService.patentDetail(start, end);
            sum = outcomeInfoService.sumOutcome("论文");
        }else if (language.equals("English")){
            patentList = outcomeInfoService.enPatentDetail(start, end);
            sum = outcomeInfoService.sumEnOutcome("论文");
        }
        return APIResponse.success(patentList,sum);
    }

    @GetMapping("/require-monograph")
    public APIResponse monograph(@RequestParam(value="start") int start,
                                 @RequestParam(value="end") int end,
                                 @RequestParam(value = "languageType") String language){
        Integer sum =null;
        List<AllMonographBO> monographBOList = null;
        if (language.equals("Chinese")) {
            monographBOList = outcomeInfoService.monographDetail(start, end);
            sum = outcomeInfoService.sumOutcome("专著");
        }else if (language.equals("English")){
            monographBOList = outcomeInfoService.enMonographDetail(start, end);
            sum = outcomeInfoService.sumEnOutcome("专著");
        }
        return APIResponse.success(monographBOList,sum);
    }
}
