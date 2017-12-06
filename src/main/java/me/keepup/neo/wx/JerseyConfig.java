package me.keepup.neo.wx;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(RequestContextFilter.class);
        register(MultiPartFeature.class);
        packages("me.keepup.neo.wx.controller");
    }

}
