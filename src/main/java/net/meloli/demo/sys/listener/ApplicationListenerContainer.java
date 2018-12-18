package net.meloli.demo.sys.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationListenerContainer implements ApplicationListener<ApplicationPreparedEvent>{

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {

    }
}
