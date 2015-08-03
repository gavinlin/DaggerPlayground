package com.gavincode.daggerplayground.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gavincode.daggerplayground.App;
import com.gavincode.daggerplayground.presentation.di.components.AppComponent;
import com.gavincode.daggerplayground.presentation.di.modules.ActivityModule;

/**
 * Created by gavinlin on 31/07/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getAppComponent().inject(this);
    }

    protected AppComponent getAppComponent() {
        return ((App)getApplication()).getComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
