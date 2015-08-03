package com.gavincode.daggerplayground;

import android.app.Application;

import com.gavincode.daggerplayground.presentation.di.components.AppComponent;
import com.gavincode.daggerplayground.presentation.di.components.DaggerAppComponent;
import com.gavincode.daggerplayground.presentation.di.modules.AppModule;

/**
 * Created by gavinlin on 31/07/15.
 */
public class App extends Application{

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    private void buildComponentAndInject() {
        this.component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
