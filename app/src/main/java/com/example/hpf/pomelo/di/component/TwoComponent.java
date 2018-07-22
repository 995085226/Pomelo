package com.example.hpf.pomelo.di.component;

import com.example.hpf.pomelo.di.module.OneModule;
import com.example.hpf.pomelo.di.module.TwoModule;
import com.example.hpf.pomelo.mvp.ui.fragment.TwoFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = TwoModule.class, dependencies = AppComponent.class)
public interface TwoComponent {
    void inject(TwoFragment fragment);
}