package top.actualself.springboot.demo_interceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("top.actualself.springboot.demo_interceptor.dao")
@ServletComponentScan(basePackages = {"top.actualself.springboot.demo_interceptor.servlet","top.actualself.springboot.demo_interceptor.filter"})
public class DemoInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoInterceptorApplication.class, args);
    }
}
