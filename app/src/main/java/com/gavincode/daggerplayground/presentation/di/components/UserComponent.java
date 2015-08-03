package com.gavincode.daggerplayground.presentation.di.components;

import com.gavincode.daggerplayground.presentation.di.PerActivity;
import com.gavincode.daggerplayground.presentation.di.modules.ActivityModule;
import com.gavincode.daggerplayground.presentation.di.modules.UserModule;
import com.gavincode.daggerplayground.presentation.view.fragment.MainFragment;

import dagger.Component;

/**
 * Created by gavinlin on 31/07/15.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent{
    void inject(MainFragment fragment);
}
