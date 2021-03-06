package com.luffy.lifycycle.statusbarlib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

/**
 * Created by lvlufei on 2020-04-26
 *
 * @name 状态栏
 * @desc
 */
public class StatusBarClient {

    public static void install(Application application, final int colorId, final boolean isDarkColor) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                if (activity instanceof IStatus) {
                    FrameLayout decorView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
                    decorView.setFitsSystemWindows(true);
                    /*沉浸式状态栏*/
                    StatusBarUtils.getInstance().setStatusBar(activity, colorId, isDarkColor);
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
