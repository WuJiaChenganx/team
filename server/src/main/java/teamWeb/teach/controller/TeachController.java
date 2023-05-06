package teamWeb.teach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.award.mapper.AwardMapper;
import teamWeb.award.service.AwardService;
import teamWeb.research.pojo.CoursePageBO;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.teach.pojo.TeachAward;
import teamWeb.utils.APIResponse;

import java.util.List;

@RestController
@RequestMapping("/teamWeb/teach")
public class TeachController {
    @Autowired
    TextboxInfoService textboxInfoService;
    @Autowired
    AwardService awardService;

    @GetMapping("/require-courses")
    public APIResponse course(@RequestParam(value = "languageType") String languageType,
                              @RequestParam(value="start",defaultValue = "0") int start,
                              @RequestParam(value="end",defaultValue = "10") int end,
                              @RequestParam(value="type") String type) {
        List<CoursePageBO> teachDetail=null;
        teachDetail = textboxInfoService.teachDetail(start,end,type);
        return APIResponse.success(teachDetail,textboxInfoService.sumCourse(type));
    }

    @GetMapping("/require-brief")
    public APIResponse brief(@RequestParam(value = "languageType") String languageType) {
        String brief = textboxInfoService.teachBrief();
        return APIResponse.success(brief);
    }

    @GetMapping("/require-studentAward")
    public APIResponse studentAward(@RequestParam(value = "languageType") String languageType) {
        List<TeachAward> ta = awardService.studentAward();
        return APIResponse.success(ta);
    }
}
