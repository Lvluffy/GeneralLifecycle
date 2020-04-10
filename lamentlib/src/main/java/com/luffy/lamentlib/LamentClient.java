package com.luffy.lamentlib;

import android.app.Activity;
import android.app.Application;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Paint paint = new Paint();
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0);
                paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                activity.getWindow().getDecorView().setLayerType(View.LAYER_TYPE_HARDWARE, paint);
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
