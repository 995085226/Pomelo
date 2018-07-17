package com.example.hpf.pomelo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.hpf.pomelo.app.base.BaseSupportActivity;
import com.example.hpf.pomelo.mvp.ui.fragment.FiveFragment;
import com.example.hpf.pomelo.mvp.ui.fragment.FourFragment;
import com.example.hpf.pomelo.mvp.ui.fragment.OneFragment;
import com.example.hpf.pomelo.mvp.ui.fragment.ThreeFragment;
import com.example.hpf.pomelo.mvp.ui.fragment.TwoFragment;
import com.example.hpf.pomelo.mvp.ui.widget.bottombar.BottomBar;
import com.example.hpf.pomelo.mvp.ui.widget.bottombar.BottomBarTab;
import com.jaeger.library.StatusBarUtil;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.hpf.pomelo.di.component.DaggerMainComponent;
import com.example.hpf.pomelo.di.module.MainModule;
import com.example.hpf.pomelo.mvp.contract.MainContract;
import com.example.hpf.pomelo.mvp.presenter.MainPresenter;

import com.example.hpf.pomelo.R;


import butterknife.BindView;
import me.yokeyword.fragmentation.ISupportFragment;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseSupportActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    private ISupportFragment[] mFragments = new ISupportFragment[5];
    private BottomBarTab homeTab;
    private BottomBarTab categoryTab;
    private BottomBarTab cartTab;
    private BottomBarTab findTab;
    private BottomBarTab selfTab;
    private double firstTime = 0;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        setStatusBar();
        initBottomBar();
    }

    private void initBottomBar() {
        addFragment();
        homeTab = new BottomBarTab(mContext, R.drawable.icon_navigation_home, "one");
        categoryTab = new BottomBarTab(mContext, R.drawable.icon_navigation_category, "two");
        cartTab = new BottomBarTab(mContext, R.drawable.icon_navigation_cart, "thr");
        findTab = new BottomBarTab(mContext, R.drawable.icon_navigation_find, "fou");
        selfTab = new BottomBarTab(mContext, R.drawable.icon_navigation_self, "fiv");
        mBottomBar
                .addItem(homeTab)
                .addItem(categoryTab)
                .addItem(cartTab)
                .addItem(findTab)
                .addItem(selfTab);
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
    private void addFragment() {
        ISupportFragment recommendFragment = findFragment(OneFragment.class);
        if (recommendFragment == null) {
            mFragments[0] = new OneFragment();
            mFragments[1] = new TwoFragment();
            mFragments[2] = new ThreeFragment();
            mFragments[3] = new FourFragment();
            mFragments[4] = new FiveFragment();
            loadMultipleRootFragment(R.id.fragment_contain, 0, mFragments);
        } else {
            mFragments[0] = findFragment(OneFragment.class);
            mFragments[1] = findFragment(TwoFragment.class);
            mFragments[2] = findFragment(ThreeFragment.class);
            mFragments[3] = findFragment(FourFragment.class);
            mFragments[4] = findFragment(FiveFragment.class);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, null);
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void onBackPressedSupport() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ArmsUtils.snackbarText("再按一次退出程序");
            firstTime = secondTime;
        } else {
            ArmsUtils.exitApp();
        }
    }

}
