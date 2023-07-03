package com.test.config;

import com.test.filter.DoFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 替代web.xml
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
//        ServletRegistration.Dynamic dynamic = servletContext.addServlet();
//        servletContext.addListener();
//        servletContext.addFilter();
    }

    /**
     * root配置类初始化
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * web配置类初始化
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 映射根路径初始化
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

   // @Override
   // protected Filter[] getServletFilters() {
   //     return new Filter[]{new DoFilter()};
   // }
}
