package com.example.hpf.pomelo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hpf.pomelo.R;
import com.example.hpf.pomelo.app.base.BaseSupportFragment;
import com.example.hpf.pomelo.mvp.contract.FiveContract;
import com.example.hpf.pomelo.mvp.contract.FourContract;
import com.example.hpf.pomelo.mvp.presenter.FivePresenter;
import com.example.hpf.pomelo.mvp.presenter.FourPresenter;
import com.jess.arms.di.component.AppComponent;

public class FiveFragment extends BaseSupportFragment<FivePresenter> implements FiveContract.View {
    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_five, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void setData(@Nullable Object data) {

    }


    @Override
    public void showMessage(@NonNull String message) {

    }
}
