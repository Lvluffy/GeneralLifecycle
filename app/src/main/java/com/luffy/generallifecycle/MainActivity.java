package com.luffy.generallifecycle;

import android.os.Bundle;

import com.luffy.generallifecycle.base.BaseActivity;
import com.luffy.screenlib.impl.IBaseScreen;

public class MainActivity extends BaseActivity implements IBaseScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean visibleTitleBar() {
        return false;
    }

    @Override
    public boolean visibleInfoBar() {
        return false;
    }

    @Override
    public boolean isLockScreen() {
        return false;
    }
}