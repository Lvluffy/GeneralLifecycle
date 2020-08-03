package com.luffy.lifecycle.printlib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by lvlufei on 2020-08-03
 *
 * @name 打印生命周期
 */
public class PrintLifecycleClient {

    public static void install(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.d(activity.getClass().getSimpleName(), "onCreated");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.d(activity.getClass().getSimpleName(), "onStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.d(activity.getClass().getSimpleName(), "onResumed");
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.d(activity.getClass().getSimpleName(), "onPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.d(activity.getClass().getSimpleName(), "onStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.d(activity.getClass().getSimpleName(), "onSaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.d(activity.getClass().getSimpleName(), "onDestroyed");
            }
        });
    }

}
