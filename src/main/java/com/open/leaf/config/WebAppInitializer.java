package com.open.leaf.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.open.leaf.security.SecurityConfig;


public class WebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class , LangConfig.class , DatabaseConfig.class,SecurityConfig .class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    
    // ✅ هنا نضيف Spring Security filter
   /* @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        FilterRegistration.Dynamic securityFilter = servletContext.addFilter(
            "springSecurityFilterChain",
            new DelegatingFilterProxy("springSecurityFilterChain")
        );
        securityFilter.addMappingForUrlPatterns(null, false, "/*");
    }*/
}
