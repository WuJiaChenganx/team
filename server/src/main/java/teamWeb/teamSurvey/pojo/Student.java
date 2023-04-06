package teamWeb.teamSurvey.pojo;

import java.util.List;

public class Student {
    private Integer title;
    private List<MemberDTO> memberInfo;

    public Student(Integer title, List<MemberDTO> memberInfo) {
        this.title = title;
        this.memberInfo = memberInfo;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public List<MemberDTO> getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(List<MemberDTO> memberInfo) {
        this.memberInfo = memberInfo;
    }
}
