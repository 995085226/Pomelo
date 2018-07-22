package com.example.hpf.pomelo.di.component;

import com.example.hpf.pomelo.di.module.FourModule;
import com.example.hpf.pomelo.mvp.ui.fragment.FourFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = FourModule.class, dependencies = AppComponent.class)
public interface FourComponent {
    void inject(FourFragment fragment);
}