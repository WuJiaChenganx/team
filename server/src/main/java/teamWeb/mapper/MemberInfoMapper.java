package teamWeb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.ReportInfo;

import java.util.List;

public interface MemberInfoMapper extends BaseMapper<MemberInfo> {
    List<MemberInfo> getAllDetail(String name);

    List<MemberInfo> getMember(int start, int end);

    List<MemberInfo> getHomeMember(int start, int end);

    List<MemberInfo> getMemberDetail(int id);
}
