package com.luffy.lifycycle.titlebarlib.impl;

/**
 * Created by lvlufei on 2020-04-14
 *
 * @name 公共UI初始化-回调监听
 * @desc
 */
public interface IUIInit<T> {
    /**
     * 设置布局
     *
     * @return
     */
    int setLayoutView();

    /**
     * 绑定控件
     *
     * @param target Activity-Activity;Fragment-View
     */
    void bindButterKnife(T target);

    /**
     * 初始化接收到的数据
     */
    void initReceiveData();

    /**
     * 初始化布局
     */
    void initView();
}
