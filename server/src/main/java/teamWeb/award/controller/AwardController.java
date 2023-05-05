package teamWeb.award.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.award.pojo.AwardBO;
import teamWeb.award.service.AwardService;
import teamWeb.research.pojo.CoursePageBO;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.List;

@RestController
@RequestMapping("/teamWeb/award")
public class AwardController {
    @Autowired
    private AwardService awardService;

    @GetMapping("/require-award")
    public APIResponse course(@RequestParam(value = "languageType") String languageType,
                              @RequestParam(value="start",defaultValue = "0") int start,
                              @RequestParam(value="end",defaultValue = "10") int end,
                              @RequestParam(value="type") String type) {
        List<AwardBO> awardBOList=null;
        awardBOList = awardService.award(start,end,type);
        return APIResponse.success(awardBOList,awardService.sumAward(type));
    }
}
