package com.example.hpf.pomelo.mvp.model;

import android.app.Application;

import com.example.hpf.pomelo.R;
import com.example.hpf.pomelo.mvp.contract.OneContract;
import com.example.hpf.pomelo.mvp.model.entity.MyItem;
import com.google.gson.Gson;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<MyItem> getListData() {
        List<MyItem> itemList = new ArrayList<>();
        for (int i = 0;i<20;i++){
            MyItem myItem = new MyItem();
            myItem.setName(mApplication.getString(R.string.jay)+i);
            myItem.setDescription(mApplication.getString(R.string.song_night_seven)+i);
            itemList.add(myItem);
        }
        return itemList;
    }
}