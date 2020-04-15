package com.luffy.generallifecycle.base;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.luffy.screenlib.impl.IBaseScreen;
import com.luffy.titlebarlibrary.TitleBarWidget;
import com.luffy.titlebarlibrary.impl.IBasePresenter;
import com.luffy.titlebarlibrary.impl.IBaseTitleClick;
import com.luffy.titlebarlibrary.impl.IBaseTitleLayout;
import com.luffy.titlebarlibrary.impl.IBaseUIInit;

public abstract class BaseActivity extends AppCompatActivity implements IBaseScreen,
        IBaseUIInit<Activity>,
        IBaseTitleLayout,
        IBaseTitleClick,
        IBasePresenter {

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
        if (b) {
            TitleBarWidget.getInstance().getNavCloseImg().setVisibility(View.VISIBLE);
        } else {
            TitleBarWidget.getInstance().getNavCloseImg().setVisibility(View.GONE);
        }
    }

    @Override
    public boolean visibilityMore() {
        return true;
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
        TitleBarWidget.getInstance().getNavBackTxt().setText(backStr);
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
        return null;
    }

    @Override
    public void setTitleString(String titleStr) {
        TitleBarWidget.getInstance().getNavTitle().setText(titleStr);
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
        TitleBarWidget.getInstance().getNavMoreTxt().setText(moreStr);
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

    @Override
    public void bindButterKnife(Activity target) {

    }

}
