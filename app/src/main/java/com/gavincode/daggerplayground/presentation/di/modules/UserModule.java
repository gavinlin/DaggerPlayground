package com.gavincode.daggerplayground.presentation.di.modules;

import com.gavincode.daggerplayground.domain.GetUserListUseCase;
import com.gavincode.daggerplayground.domain.UseCase;
import com.gavincode.daggerplayground.presentation.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gavinlin on 31/07/15.
 */
@Module
public class UserModule {

    private int userId = -1;

    public UserModule() {}

    public UserModule(int userId) {
        this.userId = userId;
    }

    @Provides @PerActivity @Named("userList")
    UseCase provideGetUserListUseCase(GetUserListUseCase getUserListUseCase) {
        return getUserListUseCase;
    }
}
