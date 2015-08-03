package com.gavincode.daggerplayground.presentation.di.modules;

import android.app.Activity;

import com.gavincode.daggerplayground.presentation.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gavinlin on 31/07/15.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @PerActivity Activity activity() {
        return this.activity;
    }
}
