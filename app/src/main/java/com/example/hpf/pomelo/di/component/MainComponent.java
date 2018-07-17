package com.example.hpf.pomelo.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.hpf.pomelo.di.module.MainModule;

import com.jess.arms.di.scope.ActivityScope;
import com.example.hpf.pomelo.mvp.ui.activity.MainActivity;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}