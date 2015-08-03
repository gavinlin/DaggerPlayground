package com.gavincode.daggerplayground.presentation.di.components;

import android.app.Activity;

import com.gavincode.daggerplayground.presentation.di.PerActivity;
import com.gavincode.daggerplayground.presentation.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by gavinlin on 31/07/15.
 */
@PerActivity
@Component(
        dependencies = AppComponent.class,
        modules =  ActivityModule.class
)
public interface ActivityComponent {
        Activity activity();
}
