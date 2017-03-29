package com.vnv.Model;


import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Http {

    private static Logger log = LoggerFactory.getLogger(Http.class);

    public static JSONObject post(String url, List<NameValuePair> params) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);

        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        log.debug(httppost.getURI().toString());
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                JSONObject json = new JSONObject(IOUtils.toString(instream, "UTF-8"));
                log.debug(json.toString());
                return json;
            } finally {
                instream.close();
            }
        }
        return null;
    }

    public static String get(String url, Header header) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        get.setHeader(header);

        HttpResponse response = httpclient.execute(get);
        return responseToString(response);
    }

    public static String get(String url) throws IOException {
        log.debug(url);
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);

        HttpResponse response = httpclient.execute(get);
        return responseToString(response);
    }

    private static String responseToString(HttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                String responseString = IOUtils.toString(instream, "UTF-8");
                log.debug(responseString);
                return responseString;
            } finally {
                instream.close();
            }
        }
        return null;
    }
}
