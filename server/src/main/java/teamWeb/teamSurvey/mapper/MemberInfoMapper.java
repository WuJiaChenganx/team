package teamWeb.teamSurvey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.teamSurvey.entity.EducationDO;
import teamWeb.teamSurvey.entity.MemberDO;
import teamWeb.teamSurvey.entity.PaperDO;
import teamWeb.teamSurvey.pojo.MemberBO;

import java.util.List;

public interface MemberInfoMapper extends BaseMapper<MemberDO> {

    List<MemberDO> getHomeMember(int start, int end);

    void updateInfo(MemberDO memberDo);

    void deleteInfo(Integer id);

    List<MemberDO> allMember(int start, int end, String memberType);

    MemberBO memberDetail(Integer id);

    List<PaperDO> allPaper(Integer id);

    List<EducationDO> allEducation(Integer id);

    Integer sumMember(String memberType);

    List<MemberDO> enAllMember(int start, int end, String memberType);

    Integer sumEnMember(String memberType);

    MemberBO enMemberDetail(Integer id);

    List<PaperDO> enAllPaper(Integer memberId);

    List<EducationDO> enAllEducation(Integer memberId);
}