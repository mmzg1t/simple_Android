package com.example.soc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver2 extends BroadcastReceiver {
    //自定义广播，要对有效范围进行界定
    //收到后进行的操作
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent intent1=new Intent(context,MusicService.class);
        context.startService(intent1);
        throw new UnsupportedOperationException("Not yet implemented");
    }
}