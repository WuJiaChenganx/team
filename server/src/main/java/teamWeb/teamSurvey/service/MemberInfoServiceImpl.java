package teamWeb.teamSurvey.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teamWeb.teamSurvey.entity.MemberDO;
import teamWeb.teamSurvey.mapper.MemberInfoMapper;
import teamWeb.teamSurvey.pojo.MemberBO;
import teamWeb.teamSurvey.pojo.MemberDTO;
import teamWeb.utils.Address;
import teamWeb.utils.BeanUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoMapper, MemberDO> implements MemberInfoService {
    final
    MemberInfoMapper memberInfoMapper;

    public MemberInfoServiceImpl(MemberInfoMapper memberInfoMapper) {
        this.memberInfoMapper = memberInfoMapper;
    }




    @Override
    public MemberBO memberDetail(Integer id) {
        MemberBO memberBO = memberInfoMapper.memberDetail(id);
        Integer memberId = memberBO.getId();
        memberBO.setMemberType(memberBO.getmClass());
        memberBO.setPaperList(memberInfoMapper.allPaper(memberId));
        memberBO.setEducationList(memberInfoMapper.allEducation(memberId));
        memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        return memberBO;
    }

    @Override
    public MemberBO enMemberDetail(Integer id) {
        MemberBO memberBO = memberInfoMapper.enMemberDetail(id);
        Integer memberId = memberBO.getId();
        memberBO.setMemberType(memberBO.getmClass());
        memberBO.setPaperList(memberInfoMapper.enAllPaper(memberId));
        memberBO.setEducationList(memberInfoMapper.enAllEducation(memberId));
        memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        return memberBO;
    }

    @Override
    public Map<Integer, List<MemberDTO>> student(String memberType) {
        List<MemberDO> memberDOList = memberInfoMapper.student(memberType);
        List<MemberBO> memberBOList = BeanUtil.convert(memberDOList, MemberBO.class);

        for (MemberBO memberBO:
                memberBOList) {
            memberBO.setTitle(memberBO.getEdu());
            memberBO.setMemberType(memberBO.getmClass());
            memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        }
        List<MemberDTO> memberDTOList = BeanUtil.convert(memberBOList,MemberDTO.class);
        Map<Integer, List<MemberDTO>> memberMap = memberDTOList.stream().collect(Collectors.groupingBy(memberDTO -> memberDTO.getComeInDate()));
        return memberMap;
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
        List<MemberBO> memberBOList = memberInfoMapper.allMember(start, end-start, memberType);
        for (MemberBO memberBO:
                memberBOList) {
            Integer memberBOId = memberBO.getId();
            memberBO.setInfo(memberInfoMapper.teacherInfo(memberBOId));
            memberBO.setTitle(memberBO.getEdu());
            memberBO.setMemberType(memberBO.getmClass());
            memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        }
        return memberBOList;
    }

    @Override
    public Integer sumMember(String memberType) {
        return memberInfoMapper.sumMember(memberType);
    }
    public Integer sumEnMember(String memberType) {
        return memberInfoMapper.sumEnMember(memberType);
    }


    @Override
    public List<MemberBO> homeMember() {
        List<MemberBO> memberBOList = memberInfoMapper.allMember(0, 1000, "teacher");
        memberBOList.addAll(memberInfoMapper.allMember(0, 1000, "doctor"));
        memberBOList.addAll(memberInfoMapper.allMember(0, 1000, "master"));
        for (MemberBO memberBO:
                memberBOList) {
            memberBO.setTitle(memberBO.getEdu());
            memberBO.setMemberType(memberBO.getmClass());
            memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        }
        return memberBOList;
    }

    @Override
    public List<MemberBO> enHomeMember() {
        List<MemberDO> memberDOList = memberInfoMapper.enAllMember(0, 1000, "teacher");
        memberDOList.addAll(memberInfoMapper.enAllMember(0, 1000, "doctor"));
        memberDOList.addAll(memberInfoMapper.enAllMember(0, 1000, "master"));
        List<MemberBO> memberBOList = BeanUtil.convert(memberDOList, MemberBO.class);
        for (MemberBO memberBO:
                memberBOList) {
            memberBO.setTitle(memberBO.getEdu());
            memberBO.setMemberType(memberBO.getmClass());
            memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        }
        return memberBOList;
    }



    @Override
    public List<MemberBO> enAllMember(int start, int end, String memberType) {
        List<MemberDO> memberDOList = memberInfoMapper.enAllMember(start, end-start, memberType);
        List<MemberBO> memberBOList = BeanUtil.convert(memberDOList, MemberBO.class);
        for (MemberBO memberBO:
                memberBOList) {
            memberBO.setTitle(memberBO.getEdu());
            memberBO.setMemberType(memberBO.getmClass());
            memberBO.setPicUrl(Address.rootAddress() + memberBO.getPictureUrl());
        }
        return memberBOList;
    }
}
