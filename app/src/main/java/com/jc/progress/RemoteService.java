package com.jc.progress;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.Toast;

/**
 * 远程服务
 */
public class RemoteService extends Service {
    MyBinder myBinder;
    MyServiceConnection myServiceConnection;

    @Override
    public void onCreate() {
        super.onCreate();
        if (myBinder == null) {
            myBinder = new MyBinder();
        }
        myServiceConnection = new MyServiceConnection();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.bindService(new Intent(this, RemoteService.class), myServiceConnection, Context.BIND_IMPORTANT);
        PendingIntent pintent = PendingIntent.getService(this, 0, new Intent(this, RemoteService.class), 0);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Jc守护进程").setContentText("双进程守护中...")
                .setContentIntent(pintent).build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, notification);
        return START_STICKY;
    }

    class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName arg0, IBinder arg1) {
            JCLoger.debug("本地服务连接成功");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            // 连接出现了异常断开了，LocalService被杀死了
            Toast.makeText(RemoteService.this, "本地服务Local被干掉", Toast.LENGTH_LONG).show();
            // 启动LocalService
            startService(new Intent(RemoteService.this, LocalService.class));
            bindService(new Intent(RemoteService.this, LocalService.class), myServiceConnection, Context.BIND_IMPORTANT);
        }

    }

    class MyBinder extends ProgressConnection.Stub {

        @Override
        public String getProName() {
            JCLoger.debug("远程服务 XXXX");
            return "";
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) {
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return myBinder;
    }
}
