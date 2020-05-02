package com.luffy.generallifecycle.base;

import android.app.Application;

import com.luffy.lamentlib.LamentClient;
import com.luffy.screenlib.ScreenClient;
import com.luffy.statusbarlib.StatusBarClient;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenClient.install(this);
        StatusBarClient.install(this);
        LamentClient.install(this);
    }
}
