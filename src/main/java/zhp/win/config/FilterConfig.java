package zhp.win.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import zhp.win.filter.LoginFilter;

/**
 * 将登录验证的过滤组件加入spring容器
 */
@Configuration
public class FilterConfig implements WebMvcConfigurer {
    @Autowired
    LoginFilter loginFilter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginFilter);
    }

}
