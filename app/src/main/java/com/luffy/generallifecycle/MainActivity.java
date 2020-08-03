package com.luffy.generallifecycle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.luffy.generallifecycle.base.BaseActivity;
import com.luffy.lifycycle.screenlib.impl.IBaseScreen;

public class MainActivity extends BaseActivity implements IBaseScreen {

    @Override
    public int setLayoutView() {
        return 0;
    }

    @Override
    public void bindButterKnife(Object target) {

    }

    @Override
    public void initReceiveData() {

    }

    @Override
    public void initView() {
        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, mainFragment).commitAllowingStateLoss();
    }

    @Override
    public boolean visibilityMoreView() {
        return true;
    }

    @Override
    public View setMoreView() {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.root_nav_finish);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "自定义view点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        return imageView;
    }
}