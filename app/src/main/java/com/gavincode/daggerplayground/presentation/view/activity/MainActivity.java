package com.gavincode.daggerplayground.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.gavincode.daggerplayground.R;
import com.gavincode.daggerplayground.presentation.di.HasComponent;
import com.gavincode.daggerplayground.presentation.di.components.DaggerUserComponent;
import com.gavincode.daggerplayground.presentation.di.components.UserComponent;
import com.gavincode.daggerplayground.presentation.model.User;
import com.gavincode.daggerplayground.presentation.view.fragment.MainFragment;

public class MainActivity extends BaseActivity implements HasComponent<UserComponent>,
        MainFragment.UserListListener{

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

    @Override
    public void onUserClicked(User user) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("url", user.getAvatar_url());
        startActivity(intent);
    }
}
