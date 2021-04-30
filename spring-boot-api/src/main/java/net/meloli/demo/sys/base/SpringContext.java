package net.meloli.demo.sys.base;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class SpringContext {

    public static ApplicationContext applicationContext;
    public static ServletContext servletContext;

    public static final void setApplicationContext(ApplicationContext applicationContext) {
        SpringContext.applicationContext = applicationContext;
    }

    public static final void setServletContext(ServletContext servletContext) {
        SpringContext.servletContext = servletContext;
    }
}
