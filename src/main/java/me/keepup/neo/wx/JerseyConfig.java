package me.keepup.neo.wx;

import me.keepup.neo.wx.controller.NoteBookController;
import me.keepup.neo.wx.controller.RootController;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(RequestContextFilter.class);
        register(MultiPartFeature.class);
        //packages("me.keepup.neo.wx.controller");
        register(RootController.class);
        register(NoteBookController.class);
    }

}
