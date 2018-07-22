package com.example.hpf.pomelo.di.component;

import com.example.hpf.pomelo.di.module.OneModule;
import com.example.hpf.pomelo.di.module.ThreeModule;
import com.example.hpf.pomelo.mvp.ui.fragment.ThreeFragment;
import com.example.hpf.pomelo.mvp.ui.fragment.TwoFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = ThreeModule.class, dependencies = AppComponent.class)
public interface ThreeComponent {
    void inject(ThreeFragment fragment);
}