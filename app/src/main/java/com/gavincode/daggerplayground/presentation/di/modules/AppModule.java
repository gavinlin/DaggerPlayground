package com.gavincode.daggerplayground.presentation.di.modules;

import android.content.Context;

import com.gavincode.daggerplayground.App;
import com.gavincode.daggerplayground.domain.repository.UserDataRepository;
import com.gavincode.daggerplayground.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gavinlin on 31/07/15.
 */
@Module
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    protected Context provideApp() {
        return app;
    }

    @Provides
    @Singleton
    protected UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
