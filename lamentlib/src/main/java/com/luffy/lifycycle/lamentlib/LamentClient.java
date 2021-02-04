package com.luffy.lifycycle.lamentlib;

import android.app.Activity;
import android.app.Application;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

/**
 * Created by lvlufei on 2020-04-10
 *
 * @name 哀悼
 * @desc
 */
public class LamentClient {

    public static void install(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Paint paint = new Paint();
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0);
                paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                activity.getWindow().getDecorView().setLayerType(View.LAYER_TYPE_HARDWARE, paint);
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
