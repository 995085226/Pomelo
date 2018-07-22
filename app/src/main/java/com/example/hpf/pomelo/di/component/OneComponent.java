package com.example.hpf.pomelo.di.component;

import com.example.hpf.pomelo.di.module.OneModule;
import com.example.hpf.pomelo.mvp.ui.fragment.OneFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = OneModule.class, dependencies = AppComponent.class)
public interface OneComponent {
    void inject(OneFragment fragment);
}