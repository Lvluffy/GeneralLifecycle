package com.luffy.generallifecycle.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.luffy.screenlib.impl.IBaseScreen;

public class BaseActivity extends AppCompatActivity implements IBaseScreen {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
