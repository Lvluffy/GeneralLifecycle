package com.luffy.lifycycle.titlebarlib;

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

import com.luffy.lifycycle.titlebarlib.impl.ITitleClick;
import com.luffy.lifycycle.titlebarlib.impl.ITitleLayout;
import com.luffy.lifycycle.titlebarlib.impl.IUIInit;


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
                if (t instanceof ITitleClick) {
                    ((ITitleClick) t).onClickNav();
                }
            }
        });
        getNavBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t instanceof ITitleClick) {
                    ((ITitleClick) t).onClickBack();
                }
            }
        });
        getNavCloseImg().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t instanceof ITitleClick) {
                    ((ITitleClick) t).onClickClose();
                }
            }
        });
        getNavMore().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (t instanceof ITitleClick) {
                    ((ITitleClick) t).onClickMore();
                }
            }
        });
        /*添加子布局*/
        if (((IUIInit) t).setLayoutView() != 0) {
            getBaseChildLayout().addView(inflater.inflate(((IUIInit) t).setLayoutView(), null));
        }
    }

    public void initTitlebarConfig(T t, Context mContext) {
        if (t instanceof ITitleLayout) {
            /*设置标题栏是否可见*/
            if (((ITitleLayout) t).visibilityTitleLayout()) {
                getNavLayout().setVisibility(View.VISIBLE);
            } else {
                getNavLayout().setVisibility(View.GONE);
            }
            /*设置返回是否可见*/
            if (((ITitleLayout) t).visibilityBack()) {
                getNavBack().setVisibility(View.VISIBLE);
            } else {
                getNavBack().setVisibility(View.GONE);
            }
            if (((ITitleLayout) t).visibilityBackImg()) {
                getNavBackImg().setVisibility(View.VISIBLE);
            } else {
                getNavBackImg().setVisibility(View.GONE);
            }
            if (((ITitleLayout) t).visibilityBackTxt()) {
                getNavBackTxt().setVisibility(View.VISIBLE);
            } else {
                getNavBackTxt().setVisibility(View.GONE);
            }
            if (((ITitleLayout) t).visibilityCloseImg()) {
                getNavCloseImg().setVisibility(View.VISIBLE);
            } else {
                getNavCloseImg().setVisibility(View.GONE);
            }
            /*设置更多是否可见*/
            if (((ITitleLayout) t).visibilityMore()) {
                getNavMore().setVisibility(View.VISIBLE);
            } else {
                getNavMore().setVisibility(View.GONE);
            }
            if (((ITitleLayout) t).visibilityMoreImg()) {
                getNavMoreImg().setVisibility(View.VISIBLE);
            } else {
                getNavMoreImg().setVisibility(View.GONE);
            }
            if (((ITitleLayout) t).visibilityMoreTxt()) {
                getNavMoreTxt().setVisibility(View.VISIBLE);
            } else {
                getNavMoreTxt().setVisibility(View.GONE);
            }
            /*设置标题栏背景色*/
            if (((ITitleLayout) t).setBgColor() != 0) {
                getNavLayout().setBackgroundResource(((ITitleLayout) t).setBgColor());
            }
            /*设置不透明度*/
            getNavLayout().getBackground().setAlpha(((ITitleLayout) t).setAlpha());
            /*设置返回图标*/
            if (((ITitleLayout) t).setBackImg() != 0) {
                getNavBackImg().setImageResource(((ITitleLayout) t).setBackImg());
            }
            /*设置关闭图标*/
            if (((ITitleLayout) t).setCloseImg() != 0) {
                getNavCloseImg().setImageResource(((ITitleLayout) t).setCloseImg());
            }
            /*设置返回*/
            if (((ITitleLayout) t).setBackTextInt() != 0) {
                getNavBackTxt().setText(((ITitleLayout) t).setBackTextInt());
            } else if (!TextUtils.isEmpty(((ITitleLayout) t).setBackTextString())) {
                getNavBackTxt().setText(((ITitleLayout) t).setBackTextString());
            }
            /*设置返回颜色*/
            if (((ITitleLayout) t).setBackTextColor() != 0) {
                getNavBackTxt().setTextColor(ContextCompat.getColor(mContext, ((ITitleLayout) t).setBackTextColor()));
            }
            /*设置返回大小*/
            if (((ITitleLayout) t).setBackTextSize() != 0) {
                getNavBackTxt().setTextSize(TypedValue.COMPLEX_UNIT_SP, ((ITitleLayout) t).setBackTextSize());
            }
            /*设置标题*/
            if (((ITitleLayout) t).setTitleInt() != 0) {
                getNavTitle().setText(((ITitleLayout) t).setTitleInt());
            } else if (!TextUtils.isEmpty(((ITitleLayout) t).setTitleString())) {
                getNavTitle().setText(((ITitleLayout) t).setTitleString());
            }
            /*设置标题颜色*/
            if (((ITitleLayout) t).setTitleColor() != 0) {
                getNavTitle().setTextColor(ContextCompat.getColor(mContext, ((ITitleLayout) t).setTitleColor()));
            }
            /*设置标题大小*/
            if (((ITitleLayout) t).setTitleSize() != 0) {
                getNavTitle().setTextSize(TypedValue.COMPLEX_UNIT_SP, ((ITitleLayout) t).setTitleSize());
            }
            /*设置更多图标*/
            if (((ITitleLayout) t).setMoreImg() != 0) {
                getNavMoreImg().setImageResource(((ITitleLayout) t).setMoreImg());
            }
            /*设置更多*/
            if (((ITitleLayout) t).setMoreTextInt() != 0) {
                getNavMoreTxt().setText(((ITitleLayout) t).setMoreTextInt());
            } else if (!TextUtils.isEmpty(((ITitleLayout) t).setMoreTextString())) {
                getNavMoreTxt().setText(((ITitleLayout) t).setMoreTextString());
            }
            /*设置更多颜色*/
            if (((ITitleLayout) t).setMoreTextColor() != 0) {
                getNavMoreTxt().setTextColor(ContextCompat.getColor(mContext, ((ITitleLayout) t).setMoreTextColor()));
            }
            /*设置更多大小*/
            if (((ITitleLayout) t).setMoreTextSize() != 0) {
                getNavMoreTxt().setTextSize(TypedValue.COMPLEX_UNIT_SP, ((ITitleLayout) t).setMoreTextSize());
            }
            /*设置分割线是否可见*/
            if (((ITitleLayout) t).visibilityDivider()) {
                getNavDivider().setVisibility(View.VISIBLE);
            } else {
                getNavDivider().setVisibility(View.GONE);
            }
            /*设置分割线颜色*/
            if (((ITitleLayout) t).setDividerColor() != 0) {
                getNavDivider().setBackgroundColor(ContextCompat.getColor(mContext, ((ITitleLayout) t).setDividerColor()));
            }
        }
    }
}
