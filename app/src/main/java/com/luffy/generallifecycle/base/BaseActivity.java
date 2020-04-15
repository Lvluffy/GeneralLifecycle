package com.luffy.generallifecycle.base;

import android.support.v7.app.AppCompatActivity;

import com.luffy.screenlib.impl.IBaseScreen;

public abstract class BaseActivity extends AppCompatActivity implements IBaseScreen {

    @Override
    public boolean visibleTitleBar() {
        return true;
    }

    @Override
    public boolean visibleInfoBar() {
        return true;
    }

    @Override
    public boolean isLockScreen() {
        return true;
    }

}
