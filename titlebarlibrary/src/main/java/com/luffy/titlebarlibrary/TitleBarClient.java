package com.luffy.titlebarlibrary;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.luffy.titlebarlibrary.impl.IBasePresenter;
import com.luffy.titlebarlibrary.impl.IBaseUIInit;

/**
 * Created by lvlufei on 2020-04-13
 *
 * @name 标题栏
 * @desc
 */
public class TitleBarClient {

    private TitleBarClient() {
    }

    public static TitleBarClient getInstance() {
        return TitleBarClientHelper.M_TITLE_BAR_CLIENT;
    }

    private static class TitleBarClientHelper {
        private static final TitleBarClient M_TITLE_BAR_CLIENT = new TitleBarClient();
    }

    public void install(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                if (activity instanceof IBaseUIInit) {
                    TitleBarWidget.getInstance().setRootView(activity.getLayoutInflater().inflate(R.layout.activity_base, null));
                    /*绑定布局*/
                    activity.setContentView(TitleBarWidget.getInstance().getRootView());
                    /*初始化标题栏控件*/
                    TitleBarWidget.getInstance().initTitlebarWidget();
                    /*初始化标题栏事件*/
                    TitleBarWidget.getInstance().initTitleEvent(activity, activity.getLayoutInflater());
                    /*初始化标题栏配置*/
                    TitleBarWidget.getInstance().initTitlebarConfig(activity, activity);
                    /*绑定控件*/
                    ((IBaseUIInit) activity).bindButterKnife(activity);
                    /*初始化接收到的数据*/
                    ((IBaseUIInit) activity).initReceiveData();
                    /*初始化界面*/
                    ((IBaseUIInit) activity).initView();
                }
                if (activity instanceof IBasePresenter) {
                    /*初始化Presenter*/
                    ((IBasePresenter) activity).initPresenter();
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
                if (activity instanceof IBasePresenter) {
                    /*为Presenter分离视图*/
                    ((IBasePresenter) activity).detachViewForPresenter();
                }
            }
        });
    }
}
