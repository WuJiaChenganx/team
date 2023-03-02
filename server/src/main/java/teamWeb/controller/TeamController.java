package teamWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.OutcomeInfo;
import teamWeb.entity.RelationInfo;
import teamWeb.entity.TextboxInfo;
import teamWeb.service.MemberInfoService;
import teamWeb.service.TextboxInfoService;
import teamWeb.utils.APIResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/team")
public class TeamController {
    @Autowired
    TextboxInfoService textboxInfoService;
    @Autowired
    MemberInfoService memberInfoService;

    @RequestMapping("/brief")
    public APIResponse brief(){
        List<TextboxInfo> briefDetail = textboxInfoService.briefDetail();
        List<Object> params =new ArrayList<>();
        params.add(briefDetail);
        return APIResponse.success(params);
    }

    @RequestMapping("/member")
    public APIResponse member(@RequestParam(value = "page") int page){
        List<MemberInfo> getMember = memberInfoService.getMember((page-1)*10,page*10);
        List<Object> params =new ArrayList<>();
        params.add(getMember);
        return APIResponse.success(params);
    }

    @RequestMapping("/relation")
    public APIResponse relation(){
        List<RelationInfo> getRelation = textboxInfoService.getRelation();
        List<Object> params =new ArrayList<>();
        params.add(getRelation);
        return APIResponse.success(params);
    }


}
