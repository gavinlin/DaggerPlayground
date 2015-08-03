package com.gavincode.daggerplayground.presentation.view.activity;

import android.os.Bundle;

import com.gavincode.daggerplayground.R;
import com.gavincode.daggerplayground.presentation.di.HasComponent;
import com.gavincode.daggerplayground.presentation.di.components.DaggerUserComponent;
import com.gavincode.daggerplayground.presentation.di.components.UserComponent;

public class MainActivity extends BaseActivity implements HasComponent<UserComponent>{

    private UserComponent userComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeInjector();
    }

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public UserComponent getComponent() {
        return userComponent;
    }
}
