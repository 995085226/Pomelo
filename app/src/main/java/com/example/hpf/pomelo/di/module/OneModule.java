package com.example.hpf.pomelo.di.module;

import android.content.Context;
import android.service.notification.ConditionProviderService;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hpf.pomelo.mvp.contract.OneContract;
import com.example.hpf.pomelo.mvp.model.OneModel;
import com.example.hpf.pomelo.mvp.ui.adapter.OneAdapter;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;


@Module
public class OneModule {
    private OneContract.View view;
    private Context mContext;

    /**
     * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public OneModule(OneContract.View view,Context mContext) {
        this.view = view;
        this.mContext = mContext;
    }

    @FragmentScope
    @Provides
    OneContract.View provideOneView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    OneContract.Model provideMainModel(OneModel model) {
        return model;
    }
    @FragmentScope
    @Provides
    OneAdapter provideAdapter() {
        return new OneAdapter();
    }

    @FragmentScope
    @Provides
    Context provideContext() {
        return mContext;
    }

    @FragmentScope
    @Provides
    RecyclerView.LayoutManager provideLayoutManager(Context mContext){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return linearLayoutManager;
    }
}