package top.actualself.springboot.demo_interceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.actualself.springboot.demo_interceptor.dao")
public class DemoInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoInterceptorApplication.class, args);
    }
}
