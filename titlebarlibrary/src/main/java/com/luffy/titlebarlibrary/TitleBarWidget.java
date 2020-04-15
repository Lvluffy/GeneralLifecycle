package com.luffy.titlebarlibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luffy.titlebarlibrary.impl.IBaseTitleClick;
import com.luffy.titlebarlibrary.impl.IBaseTitleLayout;
import com.luffy.titlebarlibrary.impl.IBaseUIInit;

/**
 * Created by lvlufei on 2020-04-15
 *
 * @name 标题栏控件
 * @desc
 */
public class TitleBarWidget<T> {

    /*根布局*/
    protected View rootView;
    /*标题栏布局*/
    private RelativeLayout navLayout;
    private LinearLayout navBack;
    private ImageView navBackImg;
    private ImageView navCloseImg;
    private TextView navBackTxt;
    private TextView navTitle;
    private LinearLayout navMore;
    private ImageView navMoreImg;
    private TextView navMoreTxt;
    private View navDivider;
    /*子界面布局*/
    private FrameLayout baseChildLayout;

    private TitleBarWidget() {
    }

    public static TitleBarWidget getInstance() {
        return TitleBarWidgetHelper.mTitleBarWidget;
    }

    private static class TitleBarWidgetHelper {
        private static final TitleBarWidget mTitleBarWidget = new TitleBarWidget();
    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public RelativeLayout getNavLayout() {
        return navLayout;
    }

    public void setNavLayout(RelativeLayout navLayout) {
        this.navLayout = navLayout;
    }

    public LinearLayout getNavBack() {
        return navBack;
    }

    public void setNavBack(LinearLayout navBack) {
        this.navBack = navBack;
    }

    public ImageView getNavBackImg() {
        return navBackImg;
    }

    public void setNavBackImg(ImageView navBackImg) {
        this.navBackImg = navBackImg;
    }

    public ImageView getNavCloseImg() {
        return navCloseImg;
    }

    public void setNavCloseImg(ImageView navCloseImg) {
        this.navCloseImg = navCloseImg;
    }

    public TextView getNavBackTxt() {
        return navBackTxt;
    }

    public void setNavBackTxt(TextView navBackTxt) {
        this.navBackTxt = navBackTxt;
    }

    public TextView getNavTitle() {
        return navTitle;
    }

    public void setNavTitle(TextView navTitle) {
        this.navTitle = navTitle;
    }

    public LinearLayout getNavMore() {
        return navMore;
    }

    public void setNavMore(LinearLayout navMore) {
        this.navMore = navMore;
    }

    public ImageView getNavMoreImg() {
        return navMoreImg;
    }

    public void setNavMoreImg(ImageView navMoreImg) {
        this.navMoreImg = navMoreImg;
    }

    public TextView getNavMoreTxt() {
        return navMoreTxt;
    }

    public void setNavMoreTxt(TextView navMoreTxt) {
        this.navMoreTxt = navMoreTxt;
    }

    public View getNavDivider() {
        return navDivider;
    }

    public void setNavDivider(View navDivider) {
        this.navDivider = navDivider;
    }

    public FrameLayout getBaseChildLayout() {
        return baseChildLayout;
    }

    public void setBaseChildLayout(FrameLayout baseChildLayout) {
        this.baseChildLayout = baseChildLayout;
    }


    @SuppressLint("WrongViewCast")
    public void initTitlebarWidget() {
        setNavLayout((RelativeLayout) getRootView().findViewById(R.id.nav_layout));
        setNavBack((LinearLayout) getRootView().findViewById(R.id.nav_back));
        setNavBackImg((ImageView) getRootView().findViewById(R.id.nav_back_img));
        setNavBackTxt((TextView) getRootView().findViewById(R.id.nav_back_txt));
        setNavCloseImg((ImageView) getRootView().findViewById(R.id.nav_close_img));
        setNavTitle((TextView) getRootView().findViewById(R.id.nav_title));
        setNavMore((LinearLayout) getRootView().findViewById(R.id.nav_more));
        setNavMoreImg((ImageView) getRootView().findViewById(R.id.nav_more_img));
        setNavMoreTxt((TextView) getRootView().findViewById(R.id.nav_more_txt));
        setNavDivider(getRootView().findViewById(R.id.nav_divider));
        setBaseChildLayout((FrameLayout) getRootView().findViewById(R.id.base_child_layout));
    }

    public void initTitleEvent(final T t, LayoutInflater inflater) {
        getNavLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t instanceof IBaseTitleClick) {
                    ((IBaseTitleClick) t).onClickNav();
                }
            }
        });
        getNavBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t instanceof IBaseTitleClick) {
                    ((IBaseTitleClick) t).onClickBack();
                }
            }
        });
        getNavCloseImg().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t instanceof IBaseTitleClick) {
                    ((IBaseTitleClick) t).onClickClose();
                }
            }
        });
        getNavMore().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t instanceof IBaseTitleClick) {
                    ((IBaseTitleClick) t).onClickMore();
                }
            }
        });
        /*添加子布局*/
        if (((IBaseUIInit) t).setLayoutView() != 0) {
            getBaseChildLayout().addView(inflater.inflate(((IBaseUIInit) t).setLayoutView(), null));
        }
    }

    public void initTitlebarConfig(T t, Context mContext) {
        if (t instanceof IBaseTitleLayout) {
            /*设置标题栏是否可见*/
            if (((IBaseTitleLayout) t).visibilityTitleLayout()) {
                getNavLayout().setVisibility(View.VISIBLE);
            } else {
                getNavLayout().setVisibility(View.GONE);
            }
            /*设置返回是否可见*/
            if (((IBaseTitleLayout) t).visibilityBack()) {
                getNavBack().setVisibility(View.VISIBLE);
            } else {
                getNavBack().setVisibility(View.GONE);
            }
            if (((IBaseTitleLayout) t).visibilityBackImg()) {
                getNavBackImg().setVisibility(View.VISIBLE);
            } else {
                getNavBackImg().setVisibility(View.GONE);
            }
            if (((IBaseTitleLayout) t).visibilityBackTxt()) {
                getNavBackTxt().setVisibility(View.VISIBLE);
            } else {
                getNavBackTxt().setVisibility(View.GONE);
            }
            if (((IBaseTitleLayout) t).visibilityCloseImg()) {
                getNavCloseImg().setVisibility(View.VISIBLE);
            } else {
                getNavCloseImg().setVisibility(View.GONE);
            }
            /*设置更多是否可见*/
            if (((IBaseTitleLayout) t).visibilityMore()) {
                getNavMore().setVisibility(View.VISIBLE);
            } else {
                getNavMore().setVisibility(View.GONE);
            }
            if (((IBaseTitleLayout) t).visibilityMoreImg()) {
                getNavMoreImg().setVisibility(View.VISIBLE);
            } else {
                getNavMoreImg().setVisibility(View.GONE);
            }
            if (((IBaseTitleLayout) t).visibilityMoreTxt()) {
                getNavMoreTxt().setVisibility(View.VISIBLE);
            } else {
                getNavMoreTxt().setVisibility(View.GONE);
            }
            /*设置标题栏背景色*/
            if (((IBaseTitleLayout) t).setBgColor() != 0) {
                getNavLayout().setBackgroundResource(((IBaseTitleLayout) t).setBgColor());
            }
            /*设置不透明度*/
            getNavLayout().getBackground().setAlpha(((IBaseTitleLayout) t).setAlpha());
            /*设置返回图标*/
            if (((IBaseTitleLayout) t).setBackImg() != 0) {
                getNavBackImg().setImageResource(((IBaseTitleLayout) t).setBackImg());
            }
            /*设置关闭图标*/
            if (((IBaseTitleLayout) t).setCloseImg() != 0) {
                getNavCloseImg().setImageResource(((IBaseTitleLayout) t).setCloseImg());
            }
            /*设置返回*/
            if (((IBaseTitleLayout) t).setBackTextInt() != 0) {
                getNavBackTxt().setText(((IBaseTitleLayout) t).setBackTextInt());
            } else if (!TextUtils.isEmpty(((IBaseTitleLayout) t).setBackTextString())) {
                getNavBackTxt().setText(((IBaseTitleLayout) t).setBackTextString());
            }
            /*设置返回颜色*/
            if (((IBaseTitleLayout) t).setBackTextColor() != 0) {
                getNavBackTxt().setTextColor(ContextCompat.getColor(mContext, ((IBaseTitleLayout) t).setBackTextColor()));
            }
            /*设置返回大小*/
            if (((IBaseTitleLayout) t).setBackTextSize() != 0) {
                getNavBackTxt().setTextSize(TypedValue.COMPLEX_UNIT_SP, ((IBaseTitleLayout) t).setBackTextSize());
            }
            /*设置标题*/
            if (((IBaseTitleLayout) t).setTitleInt() != 0) {
                getNavTitle().setText(((IBaseTitleLayout) t).setTitleInt());
            } else if (!TextUtils.isEmpty(((IBaseTitleLayout) t).setTitleString())) {
                getNavTitle().setText(((IBaseTitleLayout) t).setTitleString());
            }
            /*设置标题颜色*/
            if (((IBaseTitleLayout) t).setTitleColor() != 0) {
                getNavTitle().setTextColor(ContextCompat.getColor(mContext, ((IBaseTitleLayout) t).setTitleColor()));
            }
            /*设置标题大小*/
            if (((IBaseTitleLayout) t).setTitleSize() != 0) {
                getNavTitle().setTextSize(TypedValue.COMPLEX_UNIT_SP, ((IBaseTitleLayout) t).setTitleSize());
            }
            /*设置更多图标*/
            if (((IBaseTitleLayout) t).setMoreImg() != 0) {
                getNavMoreImg().setImageResource(((IBaseTitleLayout) t).setMoreImg());
            }
            /*设置更多*/
            if (((IBaseTitleLayout) t).setMoreTextInt() != 0) {
                getNavMoreTxt().setText(((IBaseTitleLayout) t).setMoreTextInt());
            } else if (!TextUtils.isEmpty(((IBaseTitleLayout) t).setMoreTextString())) {
                getNavMoreTxt().setText(((IBaseTitleLayout) t).setMoreTextString());
            }
            /*设置更多颜色*/
            if (((IBaseTitleLayout) t).setMoreTextColor() != 0) {
                getNavMoreTxt().setTextColor(ContextCompat.getColor(mContext, ((IBaseTitleLayout) t).setMoreTextColor()));
            }
            /*设置更多大小*/
            if (((IBaseTitleLayout) t).setMoreTextSize() != 0) {
                getNavMoreTxt().setTextSize(TypedValue.COMPLEX_UNIT_SP, ((IBaseTitleLayout) t).setMoreTextSize());
            }
            /*设置分割线是否可见*/
            if (((IBaseTitleLayout) t).visibilityDivider()) {
                getNavDivider().setVisibility(View.VISIBLE);
            } else {
                getNavDivider().setVisibility(View.GONE);
            }
            /*设置分割线颜色*/
            if (((IBaseTitleLayout) t).setDividerColor() != 0) {
                getNavDivider().setBackgroundColor(ContextCompat.getColor(mContext, ((IBaseTitleLayout) t).setDividerColor()));
            }
        }
    }
}
