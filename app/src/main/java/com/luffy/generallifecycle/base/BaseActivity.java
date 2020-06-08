package com.luffy.generallifecycle.base;

import android.support.v7.app.AppCompatActivity;

import com.luffy.lifycycle.screenlib.impl.IBaseScreen;
import com.luffy.lifycycle.statusbarlib.IStatus;
import com.luffy.lifycycle.titlebarlib.impl.IPresenter;
import com.luffy.lifycycle.titlebarlib.impl.ITitleClick;
import com.luffy.lifycycle.titlebarlib.impl.ITitleLayout;
import com.luffy.lifycycle.titlebarlib.impl.IUIInit;

public abstract class BaseActivity extends AppCompatActivity implements IBaseScreen,
        ITitleLayout,
        ITitleClick,
        IPresenter,
        IUIInit,
        IStatus {

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

    @Override
    public void initPresenter() {

    }

    @Override
    public void detachViewForPresenter() {

    }

    @Override
    public void onClickNav() {

    }

    @Override
    public void onClickBack() {
        onBackPressed();
    }

    @Override
    public void onClickMore() {

    }

    @Override
    public void onClickClose() {

    }

    @Override
    public boolean visibilityTitleLayout() {
        return true;
    }

    @Override
    public boolean visibilityBack() {
        return true;
    }

    @Override
    public boolean visibilityBackImg() {
        return true;
    }

    @Override
    public boolean visibilityBackTxt() {
        return false;
    }

    @Override
    public boolean visibilityCloseImg() {
        return false;
    }

    @Override
    public void visibilityCloseImg(boolean b) {

    }

    @Override
    public boolean visibilityMore() {
        return false;
    }

    @Override
    public boolean visibilityMoreImg() {
        return false;
    }

    @Override
    public boolean visibilityMoreTxt() {
        return false;
    }

    @Override
    public boolean visibilityDivider() {
        return true;
    }

    @Override
    public int setBgColor() {
        return 0;
    }

    @Override
    public int setAlpha() {
        return 255;
    }

    @Override
    public int setBackImg() {
        return 0;
    }

    @Override
    public int setCloseImg() {
        return 0;
    }

    @Override
    public int setBackTextInt() {
        return 0;
    }

    @Override
    public String setBackTextString() {
        return null;
    }

    @Override
    public void setBackTextString(String backStr) {

    }

    @Override
    public int setBackTextColor() {
        return 0;
    }

    @Override
    public int setBackTextSize() {
        return 0;
    }

    @Override
    public int setTitleInt() {
        return 0;
    }

    @Override
    public String setTitleString() {
        return "主界面";
    }

    @Override
    public void setTitleString(String titleStr) {

    }

    @Override
    public int setTitleColor() {
        return 0;
    }

    @Override
    public int setTitleSize() {
        return 0;
    }

    @Override
    public int setMoreImg() {
        return 0;
    }

    @Override
    public int setMoreTextInt() {
        return 0;
    }

    @Override
    public String setMoreTextString() {
        return null;
    }

    @Override
    public void setMoreTextString(String moreStr) {

    }

    @Override
    public int setMoreTextColor() {
        return 0;
    }

    @Override
    public int setMoreTextSize() {
        return 0;
    }

    @Override
    public int setDividerColor() {
        return 0;
    }

}
