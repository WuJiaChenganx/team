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
    public APIResponse member(@RequestParam(value="start",defaultValue = "0") int start,@RequestParam(value="end",defaultValue = "10") int end){
        List<MemberInfo> getMember = memberInfoService.getMember(start, end);
        List<Object> params =new ArrayList<>();
        params.add(getMember);
        return APIResponse.success(params);
    }

    @RequestMapping("/Detail")
    public APIResponse getMember(@RequestParam(value = "id") int id){
        List<MemberInfo> member = memberInfoService.getDetail(id);
        List<Object> params =new ArrayList<>();
        params.add(member);
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
