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
    public APIResponse member(@RequestParam(value="start",defaultValue = "0") int start,
                                 @RequestParam(value="end",defaultValue = "10") int end,
                                 @RequestParam(value = "memberType") String memberType,
                              @RequestParam(value = "languageType") String languageType){
        List<MemberBO> allMemberBOList =null;
        List<MemberDTO> allMemberDTOList =null;
        Integer sum =null;
        if (languageType.equals("Chinese")) {
            allMemberBOList = memberInfoService.allMember(start, end, memberType);
            allMemberDTOList = BeanUtil.convert(allMemberBOList, MemberDTO.class);
            sum = memberInfoService.sumMember(memberType);
        }else if(languageType.equals("English")){
            allMemberBOList = memberInfoService.enAllMember(start, end, memberType);
            allMemberDTOList = BeanUtil.convert(allMemberBOList, MemberDTO.class);
            sum = memberInfoService.sumEnMember(memberType);
        }
        return APIResponse.success(allMemberDTOList,sum);
    }


    @GetMapping("require-student")
    public APIResponse student(@RequestParam(value = "comeInYear") Integer comeInYear,
                               @RequestParam(value = "languageType") String languageType,
                               @RequestParam(value = "memberType" ) String memberType){
        List<MemberBO> allMemberBOList =null;
        List<MemberDTO> allMemberDTOList =null;
        if (languageType.equals("Chinese")) {
            allMemberBOList = memberInfoService.student(comeInYear,memberType);
            allMemberDTOList = BeanUtil.convert(allMemberBOList, MemberDTO.class);
        }else if(languageType.equals("English")){
            allMemberBOList = memberInfoService.student(comeInYear,memberType);
            allMemberDTOList = BeanUtil.convert(allMemberBOList, MemberDTO.class);
        }
        return APIResponse.success(allMemberDTOList);
    }

    @GetMapping("/require-homeMember")
    public APIResponse homeMember(@RequestParam(value = "languageType") String languageType){
        List<MemberBO> homeMemberList = null;
        List<MemberDTO> homeMemberDTOList = null;
        if (languageType.equals("Chinese")) {
            homeMemberList = memberInfoService.homeMember();
            homeMemberDTOList = BeanUtil.convert(homeMemberList, MemberDTO.class);
        }else if (languageType.equals("English")){
            homeMemberList = memberInfoService.enHomeMember();
            homeMemberDTOList = BeanUtil.convert(homeMemberList, MemberDTO.class);
        }
        return APIResponse.success(homeMemberDTOList);
    }


    @GetMapping("/require-detail")
    public APIResponse memberDetail(@RequestParam(value = "id") Integer id,
                                    @RequestParam(value = "languageType") String languageType){
        MemberBO member = null;
        if (languageType.equals("Chinese")) {
            member = memberInfoService.memberDetail(id);
        }else if (languageType.equals("English")){
            member = memberInfoService.enMemberDetail(id);
        }
        return APIResponse.success(member);
    }

    @RequestMapping("/relation")
    public APIResponse relation(){
        List<RelationInfo> getRelation = textboxInfoService.getRelation();
        return APIResponse.success(getRelation);
    }


}
