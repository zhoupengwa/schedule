package com.xhban.schedule.util;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by peng on 2017/9/11.
 * this is a util to post request to the server and get the response from it
 */

public class HttpUtil
{
    public static void sendOkHttpRequestMethodPOST(String address, String cookies, String username, String password, String checkcode, okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .add("checkcode", checkcode)
                .build();
        Request request = new Request.Builder().url(address).addHeader("cookie", cookies).post(requestBody).build();
        client.newCall(request).enqueue(callback);
    }

    public static void sendOkHttpRequestMethodGET(String address, okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
