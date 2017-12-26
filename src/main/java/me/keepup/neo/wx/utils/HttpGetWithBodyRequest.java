package me.keepup.neo.wx.utils;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * Created by neoyin on 2017/12/23.
 */
public class HttpGetWithBodyRequest extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "GET";

    public HttpGetWithBodyRequest() {
    }

    public HttpGetWithBodyRequest(URI uri) {
        this.setURI(uri);
    }

    public HttpGetWithBodyRequest(String uri) {
        this.setURI(URI.create(uri));
    }

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }
}
