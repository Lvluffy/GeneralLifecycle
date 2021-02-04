package com.luffy.lifycycle.nightmodelib;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;
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
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
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
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
