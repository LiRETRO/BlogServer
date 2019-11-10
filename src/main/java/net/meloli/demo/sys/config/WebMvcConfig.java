package net.meloli.demo.sys.config;

import net.meloli.demo.sys.util.FileTools;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置
 * @ClassName WebMvcConfig
 * @Date 19/11/09
 * @Author LiRETRO
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        FileTools.resourcePath = System.getProperty("user.dir");
        registry.addResourceHandler("/**").addResourceLocations("file:" + FileTools.resourcePath + "/");
    }
}
