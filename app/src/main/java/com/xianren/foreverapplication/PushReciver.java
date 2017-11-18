package com.xianren.foreverapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by xianren on 2017/11/18.
 */

public class PushReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        final Intent intent2 = new Intent(context, ForeverServerice.class);
        intent2.setAction("com.xianren.ForeverServerice");
        context.startService(intent2);

    }
}
