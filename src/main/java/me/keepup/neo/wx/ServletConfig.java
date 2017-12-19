package me.keepup.neo.wx;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ServletConfig {


    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet);
        registration.addUrlMappings("/page/*");
        return registration;
    }
    @Bean
    public ServletRegistrationBean registrationJerseyBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(new JerseyConfig()));
        registration.setEnabled(true);
        registration.setName("jersey-servlet");
        registration.addUrlMappings("/rest/*");
        registration.setLoadOnStartup(0);
        return registration;
    }



}
