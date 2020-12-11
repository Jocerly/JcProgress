package com.jc.progress;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 启动本地服务和远程服务
//        startService(new Intent(this, LocalService.class));
//        startService(new Intent(this, RemoteService.class));
//        startService(new Intent(this, JobSchedulerService.class));


    }
}
