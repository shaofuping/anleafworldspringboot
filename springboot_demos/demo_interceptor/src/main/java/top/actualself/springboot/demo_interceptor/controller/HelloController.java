package top.actualself.springboot.demo_interceptor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "入门测试", description = "入门测试调用")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "hello", notes = "hello")
    public String sayHello() {
        return  "hello springboot !" ;
    }

}
