package top.actualself.springboot.demo_interceptor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.actualself.springboot.demo_interceptor.apimodel.WidelyResult;
import top.actualself.springboot.demo_interceptor.model.User;
import top.actualself.springboot.demo_interceptor.service.UserService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("user")
@Api(value = "用户相关接口", description = "用户相关")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("getUser")
    @ApiOperation(value = "获取用户", notes = "获取用户")
    public User getUser(Integer id) {
        //该线程调用底层查询方法
        Runnable run = new Runnable() {
            @Override
            public void run() {
                userService.getUserById(id);
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 100; i++) {
            executorService.submit(run);

        }

        return userService.getUserById(id);
    }

    @PostMapping("getAllUserPaging")
    @ApiOperation(value = "获取所有用户分页显示", notes = "获取所有用户")
    public List<User> getAllUser(Integer page, Integer row) {
        return userService.getAllUser(page, row);
    }

    @PostMapping("delUser")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public WidelyResult delUser(Integer id) {
        return userService.delUserById(id);
    }

    @PostMapping("modifyUser")
    @ApiOperation(value = "修改用户", notes = "修改用户")
    public WidelyResult modifyUser(User user) {
        return userService.modifyUser(user);
    }


}


