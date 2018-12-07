package top.actualself.springboot.demo_interceptor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.actualself.springboot.demo_interceptor.apimodel.WidelyResult;
import top.actualself.springboot.demo_interceptor.dao.UserMapper;
import top.actualself.springboot.demo_interceptor.model.User;
import top.actualself.springboot.demo_interceptor.model.UserExample;
import top.actualself.springboot.demo_interceptor.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    @Override
    public User getUserById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUser(Integer page, Integer row) {
        PageHelper.startPage(page, row);
        UserExample abc = new UserExample();
        List<User> list = mapper.selectByExample(abc);
        PageInfo info = new PageInfo(list);
        return info.getList();
    }

    @Transactional
    @Override
    public WidelyResult modifyUser(User user) {
        UserExample example = new UserExample();
        mapper.updateByExampleSelective(user, example);
        return WidelyResult.ok();
    }

    @Override
    public WidelyResult delUserById(Integer id) {

        mapper.deleteByPrimaryKey(id);
        return WidelyResult.ok();
    }
}
