package com.xhban.schedule.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xhban.schedule.beans.Version;
import com.xhban.schedule.util.HttpUtil;
import com.xhban.schedule.util.UpdateCheckUtil;

import com.xhban.schedule.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class AppInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appinfo);
        TextView versionName = (TextView) findViewById(R.id.version_info);
        SharedPreferences pref = getSharedPreferences("version", MODE_PRIVATE);
        String name = pref.getString("version_name", "1.0.0");
        versionName.setText("v" + name);
        final TextView updateCheck = (TextView) findViewById(R.id.check_update);
        updateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCheck.setText("检测中...");
                updateCheck.setEnabled(false);
                updateCheck.setTextColor(Color.parseColor("#BBBBBB"));
                new UpdateCheckUtil(AppInfoActivity.this).checkVersion();
            }
        });
    }
}
