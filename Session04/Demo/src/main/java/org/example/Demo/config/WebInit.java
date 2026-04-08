package org.example.kha1.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// class nay se chay dau tien vao
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[ ]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[ ]{"/"};
    }
}
