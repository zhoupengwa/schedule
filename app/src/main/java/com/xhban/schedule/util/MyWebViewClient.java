package com.xhban.schedule.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * Created by peng on 2017/9/30.
 * this is a son class
 */

public class MyWebViewClient extends WebViewClient
{
    private Context mcontext;

    public MyWebViewClient(Context context)
    {
        this.mcontext = context;
    }

    @Override
    public void onPageFinished(WebView view, String url)
    {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        CookieManager cookieManager = CookieManager.getInstance();
        String cookieStr = cookieManager.getCookie(url);
        // Log.i("————服务器设置的cookie", cookieStr+"");
        try
        {
            out = mcontext.openFileOutput("cookies.txt", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(cookieStr + "");
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (writer != null)
                {
                    writer.close();
                }
                if (out != null)
                {
                    out.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        super.onPageFinished(view, url);
    }
}
