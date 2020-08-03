package com.luffy.generallifecycle.base;

import android.app.Application;

import com.luffy.generallifecycle.R;
import com.luffy.lifecycle.printlib.PrintLifecycleClient;
import com.luffy.lifycycle.lamentlib.LamentClient;
import com.luffy.lifycycle.screenlib.ScreenClient;
import com.luffy.lifycycle.statusbarlib.StatusBarClient;
import com.luffy.lifycycle.titlebarlib.TitleBarClient;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenClient.install(this);
        StatusBarClient.install(this, R.color.white, true);
        LamentClient.install(this);
        TitleBarClient.install(this, R.layout.base_layout);
        PrintLifecycleClient.install(this);
    }
}
