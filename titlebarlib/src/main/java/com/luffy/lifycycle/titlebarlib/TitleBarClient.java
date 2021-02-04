package com.luffy.lifycycle.titlebarlib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.luffy.lifycycle.titlebarlib.impl.IPresenter;
import com.luffy.lifycycle.titlebarlib.impl.IUIInit;

/**
 * Created by lvlufei on 2020-04-13
 *
 * @name 标题栏
 * @desc
 */
public class TitleBarClient {

    public static void install(Application application, final int rootResource) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if (activity instanceof IUIInit) {
                    if (rootResource == 0) {
                        TitleBarWidget.getInstance().setRootView(activity.getLayoutInflater().inflate(R.layout.root_layout, null));
                    } else {
                        TitleBarWidget.getInstance().setRootView(activity.getLayoutInflater().inflate(rootResource, null));
                    }
                    /*绑定布局*/
                    activity.setContentView(TitleBarWidget.getInstance().getRootView());
                    /*初始化标题栏控件*/
                    TitleBarWidget.getInstance().initTitlebarWidget();
                    /*初始化标题栏事件*/
                    TitleBarWidget.getInstance().initTitleEvent(activity, activity.getLayoutInflater());
                    /*绑定控件*/
                    ((IUIInit) activity).bindButterKnife(activity);
                    /*初始化接收到的数据*/
                    ((IUIInit) activity).initReceiveData();
                    /*初始化标题栏配置*/
                    TitleBarWidget.getInstance().initTitlebarConfig(activity, activity);
                    /*初始化界面*/
                    ((IUIInit) activity).initView();
                }
                if (activity instanceof IPresenter) {
                    /*初始化Presenter*/
                    ((IPresenter) activity).initPresenter();
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
                if (activity instanceof IPresenter) {
                    /*为Presenter分离视图*/
                    ((IPresenter) activity).detachViewForPresenter();
                }
            }
        });
    }
}
