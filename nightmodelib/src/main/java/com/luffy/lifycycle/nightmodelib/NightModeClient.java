package com.luffy.lifycycle.nightmodelib;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by lvlufei on 2020-09-29
 *
 * @name 夜间模式
 */
public class NightModeClient {

    public static void install(Application application, final boolean openNightMode) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                View nightView = null;
                ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
                if (openNightMode) {
                    if (nightView == null) {
                        nightView = new View(activity);
                        nightView.setBackgroundColor(Color.parseColor("#80000000"));
                    }
                    if (nightView.getParent() == null) {
                        decorView.addView(nightView, new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
                    }
                } else {
                    if (nightView != null) {
                        decorView.removeView(nightView);
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
