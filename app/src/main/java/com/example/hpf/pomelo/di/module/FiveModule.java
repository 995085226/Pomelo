package com.example.hpf.pomelo.di.module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hpf.pomelo.mvp.contract.FiveContract;
import com.example.hpf.pomelo.mvp.contract.OneContract;
import com.example.hpf.pomelo.mvp.model.FiveModel;
import com.example.hpf.pomelo.mvp.model.OneModel;
import com.example.hpf.pomelo.mvp.ui.adapter.OneAdapter;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;


@Module
public class FiveModule {
    private FiveContract.View view;
    private Context mContext;

    /**
     * 构建MainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public FiveModule(FiveContract.View view, Context mContext) {
        this.view = view;
        this.mContext = mContext;
    }

    @FragmentScope
    @Provides
    FiveContract.View provideView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    FiveContract.Model provideModel(FiveModel model) {
        return model;
    }


    @FragmentScope
    @Provides
    Context provideContext() {
        return mContext;
    }

}