package blog.ordincode.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/js/**",
                "/css/**",
                "/img/**"
        )
                .addResourceLocations(
                        "classpath:/dist/js/",
                        "classpath:/dist/css/",
                        "classpath:/dist/img/",
                        "classpath:/static/js/",
                        "classpath:/static/css/",
                        "classpath:/static/img/"
                )
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }
}
