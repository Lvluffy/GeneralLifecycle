package com.luffy.generallifecycle;

import com.luffy.generallifecycle.base.BaseActivity;
import com.luffy.screenlib.impl.IBaseScreen;

public class MainActivity extends BaseActivity implements IBaseScreen {

    @Override
    public int setLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void bindButterKnife(Object target) {

    }

    @Override
    public void initReceiveData() {

    }

    @Override
    public void initView() {

    }
}