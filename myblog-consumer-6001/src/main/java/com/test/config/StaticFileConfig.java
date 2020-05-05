package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class StaticFileConfig implements WebMvcConfigurer {
    //静态资源映射

    @Value("${file.uploadFolder}")
    private  String FILEPATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//        registry.addResourceHandler("/img/**").addResourceLocations("file:"+FILEPATH+"/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+FILEPATH+"/");
//        registry.addResourceHandler("/img1/**").addResourceLocations("classpath:/static/img/");
    }

    //解决@vaule取不到值的问题
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
