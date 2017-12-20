package me.keepup.neo.wx.controller;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Path("/note")
public class NoteBookController {


    @Value("")


    @Path("/weixin")
    @GET
    public String weixin(@QueryParam("signature")String signature,
                         @QueryParam("echostr")String echostr,
                         @QueryParam("token")String token,
                         @QueryParam("timestamp")String timestamp,
                         @QueryParam("nonce")String nonce){







        return echostr;
    }


    @Path("/init")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String init() {
        return "init";
    }

    @Path("/upload")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String upload(@FormDataParam("file") InputStream file,
                         @FormDataParam("file") FormDataContentDisposition fileDisposition) {

        System.out.println(file);
        return null;
    }


}
