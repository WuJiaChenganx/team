package manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import manage.service.ManageService;
import org.springframework.stereotype.Service;
import teamWeb.entity.MemberInfo;
import teamWeb.entity.ReportInfo;
import teamWeb.mapper.MemberInfoMapper;
import teamWeb.service.MemberInfoService;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Override
    public List<ReportInfo> showNews(int start, int end) {
        return null;
    }
}
