package com.luffy.generallifecycle.base;

import android.app.Application;

import com.luffy.screenlib.ScreenClient;
import com.luffy.titlebarlibrary.TitleBarClient;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenClient.install(this);
        TitleBarClient.getInstance().install(this);
    }
}
