package net.meloli.demo.sys.listener;

import net.meloli.demo.sys.base.SpringContext;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 初始化类
 * @author LiRETRO
 */
@Component
public class ApplicationListenerContainer implements ApplicationContextAware, ServletContextAware, ApplicationListener<ApplicationPreparedEvent>{

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        System.out.println("--------------------System Started-----------------------");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.setApplicationContext(applicationContext);
//        RedisHelper.setApplicationContext(applicationContext);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        SpringContext.setServletContext(servletContext);
    }
}
