package com.xianren.foreverapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by xianren on 2017/11/18.
 */

public class ForeverServerice extends Service {
    int i = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("push", "[ExampleApplication] onCreate");
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPus
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
