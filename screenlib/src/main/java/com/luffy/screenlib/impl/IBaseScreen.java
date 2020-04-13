package com.luffy.screenlib.impl;

/**
 * Created by lvlufei on 2018/1/1
 *
 * @desc 回调接口
 */
public interface IBaseScreen {

    /**
     * 是否显示标题栏
     *
     * @return
     */
    boolean visibleTitleBar();

    /**
     * 是否显示信息栏
     *
     * @return
     */
    boolean visibleInfoBar();

    /**
     * 是否锁屏
     *
     * @return
     */
    boolean isLockScreen();
}
