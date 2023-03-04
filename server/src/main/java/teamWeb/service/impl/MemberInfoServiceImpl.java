package teamWeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.mapper.MemberInfoMapper;
import teamWeb.mapper.ReportInfoMapper;
import teamWeb.service.MemberInfoService;
import teamWeb.service.ReportInfoService;

import java.util.List;

@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoMapper, MemberInfo> implements MemberInfoService {
    @Autowired
    MemberInfoMapper memberInfoMapper;


    @Override
    public List<MemberInfo> memberDetail(String  name) {
        return memberInfoMapper.getAllDetail(name);
    }

    @Override
    public List<MemberInfo> getMember(int start, int end) {
        return memberInfoMapper.getMember(start,end);
    }

    @Override
    public List<MemberInfo> getHomeMember(int start, int end) {
        return memberInfoMapper.getHomeMember(start,end);
    }

    @Override
    public List<MemberInfo> getDetail(int id) {
        return memberInfoMapper.getMemberDetail(id);
    }
}
