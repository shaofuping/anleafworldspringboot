package top.actualself.springboot.demo_interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.actualself.springboot.demo_interceptor.interceptor.MyInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] pass = {
                "/hello",
                "/swagger**/**"
        };
        String [] inPass = {"/user/**"};

        registry.addInterceptor(new MyInterceptor()).addPathPatterns(pass).excludePathPatterns(inPass);
    }
}
