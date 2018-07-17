package com.example.hpf.pomelo.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.hpf.pomelo.di.module.SplashModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.hpf.pomelo.mvp.ui.activity.SplashActivity;

@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}