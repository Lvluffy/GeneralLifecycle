package com.luffy.lifycycle.screenlib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.luffy.lifycycle.screenlib.impl.IBaseScreen;

/**
 * Created by lvlufei on 2020-04-13
 *
 * @name 屏幕
 * @desc
 */
public class ScreenClient {
    public static void install(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                if (activity instanceof IBaseScreen) {
                    /*不显示标题栏*/
                    if (!((IBaseScreen) activity).visibleTitleBar()) {
                        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    }
                    /*不显示信息栏*/
                    if (!((IBaseScreen) activity).visibleInfoBar()) {
                        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    }
                    /*不锁屏(保持屏幕不变黑)*/
                    if (!((IBaseScreen) activity).isLockScreen()) {
                        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                    }
                }
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }
}
