package org.example.demo.config;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//        location: dia chi luu tam thoi,
//        maxFileSize: kich thuoc toi da cua 1 file,
//        maxRequestSize: kich thuoc toi da cua 1 request,
//        fileSizeThreshold: muon luu vao file temp kich co bao nhieu
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        "/",
                        25 * 1024 * 1024L,
                        25 * 1024 * 1024L,
                        0

                )
        );
    }
}
