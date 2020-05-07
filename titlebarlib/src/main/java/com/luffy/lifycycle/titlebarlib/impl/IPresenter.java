package com.luffy.lifycycle.titlebarlib.impl;

/**
 * Created by lvlufei on 2020-04-15
 *
 * @name
 * @desc
 */
public interface IPresenter {
    /**
     * 初始化Presenter
     */
    void initPresenter();

    /**
     * 为Presenter分离视图
     */
    void detachViewForPresenter();
}
