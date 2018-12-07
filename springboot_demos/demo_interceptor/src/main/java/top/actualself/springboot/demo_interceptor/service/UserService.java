package top.actualself.springboot.demo_interceptor.service;

import top.actualself.springboot.demo_interceptor.apimodel.WidelyResult;
import top.actualself.springboot.demo_interceptor.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> getAllUser(Integer page, Integer row);

    WidelyResult modifyUser(User user);

    WidelyResult delUserById(Long id);
 }
