package org.example.kha1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// danh dau la lop cau hinh
@Configuration

// bat che do web mvc
@EnableWebMvc

// quet cac bean dang can duoc khoi tao
@ComponentScan(basePackages = "org.example.kha1")

public class AppConfig {

    // cau hinh bean viewreolver de doc duoc view
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // cau hinh tien to
        viewResolver.setPrefix("/WEB-INF/views/");
        // cau hinh hau to
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
