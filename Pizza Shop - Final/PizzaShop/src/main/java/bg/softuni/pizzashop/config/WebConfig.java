package bg.softuni.pizzashop.config;

import bg.softuni.pizzashop.interceptor.IpBlackListInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    private final LocaleChangeInterceptor localeChangeInterceptor;
    private final IpBlackListInterceptor ipBlackListInterceptor;

    public WebConfig(LocaleChangeInterceptor localeChangeInterceptor, IpBlackListInterceptor ipBlackListInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
        this.ipBlackListInterceptor = ipBlackListInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(ipBlackListInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
