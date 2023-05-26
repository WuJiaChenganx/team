package teamWeb.interflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.interflow.pojo.FlowMemberBO;
import teamWeb.pubications.service.OutcomeInfoService;
import teamWeb.teamSurvey.service.MemberInfoService;
import teamWeb.utils.APIResponse;

import java.util.List;

@RestController
@RequestMapping("/teamWeb/interflow")
public class Interflow {
    @Autowired
    MemberInfoService memberInfoService;

    @GetMapping("/require-internal")
    public APIResponse internal(@RequestParam(value = "languageType") String language){
        List<FlowMemberBO> flowMemberBOList = memberInfoService.internalFlow();
        return APIResponse.success(flowMemberBOList);
    }

    @GetMapping("/require-foreign")
    public APIResponse foreign(@RequestParam(value = "languageType") String language){
        List<FlowMemberBO> flowMemberBOList = memberInfoService.foreignFlow();
        return APIResponse.success(flowMemberBOList);
    }
}