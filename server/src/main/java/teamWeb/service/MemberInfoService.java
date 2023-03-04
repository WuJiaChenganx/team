package teamWeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.ReportInfo;

import java.util.List;

public interface MemberInfoService extends IService<MemberInfo> {
    List<MemberInfo> memberDetail(String name);

    List<MemberInfo> getMember(int start, int end);

    List<MemberInfo> getHomeMember(int start, int end);

    List<MemberInfo> getDetail(int id);
}
