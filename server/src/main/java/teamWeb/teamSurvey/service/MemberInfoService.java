package teamWeb.teamSurvey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.interflow.pojo.FlowMemberBO;
import teamWeb.teamSurvey.entity.MemberDO;
import teamWeb.teamSurvey.pojo.MemberBO;
import teamWeb.teamSurvey.pojo.MemberDTO;
import teamWeb.teamSurvey.pojo.Student;

import java.util.List;
import java.util.Map;

public interface MemberInfoService extends IService<MemberDO> {
    // List<MemberDO> memberDetail(String name);

    MemberBO memberDetail(Integer id);

    void insertInfo(MemberDO memberDo);

    void updateInfo(MemberDO memberDo);

    void deleteInfo(MemberDO memberDo);

    List<MemberBO> allMember(int start, int end,String memberType);

    Integer sumMember(String memberType);

    List<MemberBO> homeMember();

    List<MemberBO> enAllMember(int start, int end, String memberType);

    Integer sumEnMember(String memberType);

    List<MemberBO> enHomeMember();

    MemberBO enMemberDetail(Integer id);

    List<Student> student(String memberType);

    List<FlowMemberBO> internalFlow();

    List<FlowMemberBO> foreignFlow();
}
