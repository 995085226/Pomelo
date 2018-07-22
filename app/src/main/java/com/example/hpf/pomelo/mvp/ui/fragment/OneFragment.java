package com.example.hpf.pomelo.mvp.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.hpf.pomelo.R;
import com.example.hpf.pomelo.app.base.BaseSupportFragment;
import com.example.hpf.pomelo.di.component.DaggerOneComponent;
import com.example.hpf.pomelo.di.module.OneModule;
import com.example.hpf.pomelo.mvp.contract.OneContract;
import com.example.hpf.pomelo.mvp.model.entity.MyItem;
import com.example.hpf.pomelo.mvp.presenter.OnePresenter;
import com.example.hpf.pomelo.mvp.ui.adapter.OneAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class OneFragment extends BaseSupportFragment<OnePresenter> implements OneContract.View {


    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.banner_header)
    View banner;

    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.iv_conversation)
    ImageView ivConversation;
    @BindView(R.id.rl_search_bar)
    RelativeLayout rlSearchBar;

    @Inject
    OneAdapter mOneAdapter;

    @Inject
    RecyclerView.LayoutManager layoutManager;
    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerOneComponent
                .builder()
                .appComponent(appComponent)
                .oneModule(new OneModule(this,_mActivity))
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
          initAppLayout();
          initRefresh();
          initRV();
    }

    private void initRV() {
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mOneAdapter);
        mPresenter.getItemList();
    }
    private void initAppLayout() {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset >= 0) {
                swipeRefresh.setEnabled(true);
            } else {
                swipeRefresh.setEnabled(false);
            }
            mToolbar.setBackgroundColor(changeAlpha(ContextCompat.getColor(_mActivity,R.color.white), Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange()));
        });
    }
    public int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }
    private void initRefresh() {
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ArmsUtils.snackbarText(getString(R.string.refresh_success));
                swipeRefresh.setRefreshing(false);
            }
        });
        swipeRefresh.setProgressViewOffset(true, 130, 300);
        swipeRefresh.setColorSchemeColors(ContextCompat.getColor(_mActivity,R.color.refresh_color));
    }

    @Override
    public void setData(@Nullable Object data) {

    }


    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showList(List<MyItem> myItemList) {
        mOneAdapter.addData(myItemList);
        mOneAdapter.notifyDataSetChanged();
    }
}
