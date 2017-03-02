package com.dm4x.Configuration;

/**
 * Created by kiselev on 26.02.17.
 */

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //search @Bean
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                MainConfig.class
        };
    }

    //ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{
                MainConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}