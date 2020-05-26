package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    //read application.properties
    private ResourceBundle bundle;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url =bundle.getString("test.url");
        System.out.println(url);
    }
    @Test
    public void testGetCookies() throws IOException {
        //Get page info
//        String result;
//        HttpGet get = new HttpGet(this.url + bundle.getString("getCookies.uri"));
//        HttpClient client = new DefaultHttpClient();
//        HttpResponse response = client.execute(get);
//        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(result);

        //Get Cookies
        String result;
        HttpGet get = new HttpGet(this.url + bundle.getString("getCookies.uri"));
        //get cookies
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //get cookies
        CookieStore store = client.getCookieStore();
        List<Cookie> cookiesList = store.getCookies();

        for (Cookie cookie : cookiesList) {
           String name = cookie.getName();
           String value = cookie.getValue();
            System.out.println(name + " = " + value);
        }

    }

}
