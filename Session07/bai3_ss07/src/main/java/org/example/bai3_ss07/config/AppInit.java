package org.example.bai3_ss07.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        String location = "C:/RikkeiFood_Temp/";
        long maxFileSize = 5 * 1024 * 1024;
        long maxRequestSize = 10 * 1024 * 1024;
        int fileSizeThreshold = 0;

        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(location, maxFileSize, maxRequestSize, fileSizeThreshold);

        registration.setMultipartConfig(multipartConfigElement);
    }
}