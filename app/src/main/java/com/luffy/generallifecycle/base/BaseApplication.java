package com.luffy.generallifecycle.base;

import android.app.Application;

import com.luffy.generallifecycle.R;
import com.luffy.lamentlib.LamentClient;
import com.luffy.lifycycle.titlebarlib.TitleBarClient;
import com.luffy.screenlib.ScreenClient;
import com.luffy.statusbarlib.StatusBarClient;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenClient.install(this);
        StatusBarClient.install(this, R.color.white, true);
        LamentClient.install(this);
        TitleBarClient.install(this, R.layout.base_layout);
    }
}
