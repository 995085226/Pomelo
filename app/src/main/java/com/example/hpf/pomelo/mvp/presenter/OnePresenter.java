package com.example.hpf.pomelo.mvp.presenter;

import android.app.Application;

import com.example.hpf.pomelo.mvp.contract.OneContract;
import com.example.hpf.pomelo.mvp.model.entity.MyItem;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;


@FragmentScope
public class OnePresenter extends BasePresenter<OneContract.Model, OneContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public OnePresenter(OneContract.Model model, OneContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void getItemList(){
        List<MyItem> listData = mModel.getListData();
        mRootView.showList(listData);
    }
}
