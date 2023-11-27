package com.example.soc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class MyReceiver extends BroadcastReceiver {

    //收到后进行的操作
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent intent1=new Intent(context,MusicService.class); Uri uri=Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + "music1");
        intent1.setData(uri);
        context.startService(intent1);
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}