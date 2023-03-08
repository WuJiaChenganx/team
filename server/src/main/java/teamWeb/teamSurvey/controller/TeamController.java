package teamWeb.teamSurvey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teamWeb.homepage.entity.RelationInfo;
import teamWeb.research.entity.TextboxInfo;
import teamWeb.teamSurvey.pojo.MemberBO;
import teamWeb.teamSurvey.pojo.MemberDTO;
import teamWeb.teamSurvey.service.MemberInfoService;
import teamWeb.research.service.TextboxInfoService;
import teamWeb.utils.APIResponse;
import teamWeb.utils.BeanUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teamWeb/teamSurvey")
public class TeamController {
    @Autowired
    TextboxInfoService textboxInfoService;
    @Autowired
    MemberInfoService memberInfoService;

    @RequestMapping("/brief")
    public APIResponse brief(){
        List<TextboxInfo> briefDetail = textboxInfoService.briefDetail();

        return APIResponse.success(briefDetail);
    }

    @GetMapping("/require-member")
    public APIResponse allMember(@RequestParam(value="start",defaultValue = "0") int start,
                                 @RequestParam(value="end",defaultValue = "10") int end,
                                 @RequestParam(value = "memberType") String memberType){
        List<MemberBO> allMemberBOList = memberInfoService.allMember(start, end,memberType);
        List<MemberDTO> allMemberDTOList = BeanUtil.convert(allMemberBOList, MemberDTO.class);
        return APIResponse.success(allMemberDTOList);
    }

    @GetMapping("/require-detail")
    public APIResponse memberDetail(@RequestParam(value = "id") Integer id){
        List<MemberBO> memberBOList = memberInfoService.memberDetail(id);
        List<MemberDTO> memberDTOList = BeanUtil.convert(memberBOList, MemberDTO.class);
        return APIResponse.success(memberDTOList);
    }

    @RequestMapping("/relation")
    public APIResponse relation(){
        List<RelationInfo> getRelation = textboxInfoService.getRelation();
        return APIResponse.success(getRelation);
    }


}
