package com.example.hpf.pomelo.di.component;

import com.example.hpf.pomelo.di.module.FiveModule;
import com.example.hpf.pomelo.mvp.ui.fragment.FiveFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = FiveModule.class, dependencies = AppComponent.class)
public interface FiveComponent {
    void inject(FiveFragment fragment);
}