package org.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.demo")
public class AppConfig {
    // 1 . bean spring resource template resolver - doc cau hinh folder chua file html
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        // tien to
        resolver.setPrefix("/WEB-INF/views/");
        // hau to
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        // set character encoding de nhan ki tu tieng viet
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
    // 2 . bean string template engine - bo may trung tam chuyen doi cac cu phap thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }
    // 3 . bean thymeleaf view resolver - giao tiep giua springmvc va thymeleaf
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
