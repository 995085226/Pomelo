package com.example.hpf.pomelo.mvp.model;

import android.app.Application;

import com.example.hpf.pomelo.mvp.contract.OneContract;
import com.google.gson.Gson;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;


@FragmentScope
public class OneModel extends BaseModel implements OneContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public OneModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}