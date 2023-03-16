package teamWeb.teamSurvey.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.teamSurvey.entity.MemberDO;
import teamWeb.teamSurvey.mapper.MemberInfoMapper;
import teamWeb.teamSurvey.pojo.MemberBO;
import teamWeb.utils.Address;
import teamWeb.utils.BeanUtil;

import java.util.List;

@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoMapper, MemberDO> implements MemberInfoService {
    final
    MemberInfoMapper memberInfoMapper;

    public MemberInfoServiceImpl(MemberInfoMapper memberInfoMapper) {
        this.memberInfoMapper = memberInfoMapper;
    }


    @Override
    public List<MemberBO> memberDetail(Integer id) {
        List<MemberBO> memberBOList = memberInfoMapper.memberDetail(id);
        for (MemberBO memberBO:
             memberBOList) {
            Integer memberId = memberBO.getId();
            memberBO.setPaperList(memberInfoMapper.allPaper(memberId));
            memberBO.setEducationList(memberInfoMapper.allEducation(memberId));
            memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        }

        return memberBOList;
    }


    @Override
    public List<MemberDO> getHomeMember(int start, int end) {
        return memberInfoMapper.getHomeMember(start,end);
    }


    @Override
    public void insertInfo(MemberDO memberDo) {
        memberInfoMapper.insert(memberDo);
    }

    @Override
    public void updateInfo(MemberDO memberDo) {
        memberInfoMapper.updateInfo(memberDo);
    }

    @Override
    public void deleteInfo(MemberDO memberDo) {
        memberInfoMapper.deleteInfo(memberDo.getId());
    }

    @Override
    public List<MemberBO> allMember(int start, int end, String memberType) {
        List<MemberDO> memberDOList = memberInfoMapper.allMember(start, end, memberType);
        List<MemberBO> memberBOList = BeanUtil.convert(memberDOList, MemberBO.class);
        for (MemberBO memberBO:
                memberBOList) {
            Integer memberId = memberBO.getId();
            memberBO.setPaperList(memberInfoMapper.allPaper(memberId));
            memberBO.setEducationList(memberInfoMapper.allEducation(memberId));
            memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        }
        return memberBOList;
    }

    @Override
    public Integer sumMember(String memberType) {
        return memberInfoMapper.sumMember(memberType);
    }
}
