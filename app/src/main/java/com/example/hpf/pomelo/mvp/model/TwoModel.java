package com.example.hpf.pomelo.mvp.model;

import android.app.Application;

import com.example.hpf.pomelo.mvp.contract.OneContract;
import com.example.hpf.pomelo.mvp.contract.TwoContract;
import com.google.gson.Gson;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;


@FragmentScope
public class TwoModel extends BaseModel implements TwoContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public TwoModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}