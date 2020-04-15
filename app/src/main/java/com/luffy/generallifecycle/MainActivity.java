package com.luffy.generallifecycle;

import com.luffy.generallifecycle.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int setLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void initReceiveData() {

    }

    @Override
    public void initView() {
        setTitleString("主界面");
    }
}