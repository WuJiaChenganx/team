package teamWeb.teamSurvey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.teamSurvey.entity.MemberDO;
import teamWeb.teamSurvey.pojo.MemberBO;

import java.util.List;

public interface MemberInfoService extends IService<MemberDO> {
    // List<MemberDO> memberDetail(String name);

    List<MemberDO> getHomeMember(int start, int end);

    MemberBO memberDetail(Integer id);

    void insertInfo(MemberDO memberDo);

    void updateInfo(MemberDO memberDo);

    void deleteInfo(MemberDO memberDo);

    List<MemberBO> allMember(int start, int end,String memberType);

    Integer sumMember(String memberType);

}
