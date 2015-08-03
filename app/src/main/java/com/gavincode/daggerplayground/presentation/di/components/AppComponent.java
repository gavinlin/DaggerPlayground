package com.gavincode.daggerplayground.presentation.di.components;

import android.content.Context;

import com.gavincode.daggerplayground.domain.repository.UserRepository;
import com.gavincode.daggerplayground.presentation.di.modules.AppModule;
import com.gavincode.daggerplayground.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gavinlin on 31/07/15.
 */
@Singleton
@Component(
        modules = AppModule.class
)
public interface AppComponent {
        void inject(BaseActivity activity);

        Context context();
        UserRepository userRepository();
}
