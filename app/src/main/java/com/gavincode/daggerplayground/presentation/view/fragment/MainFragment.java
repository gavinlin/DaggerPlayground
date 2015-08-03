package com.gavincode.daggerplayground.presentation.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gavincode.daggerplayground.R;
import com.gavincode.daggerplayground.presentation.di.components.UserComponent;
import com.gavincode.daggerplayground.presentation.model.User;
import com.gavincode.daggerplayground.presentation.presenter.UserListPresenter;
import com.gavincode.daggerplayground.presentation.view.UserListView;
import com.gavincode.daggerplayground.presentation.view.adapter.UsersAdapter;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gavinlin on 31/07/15.
 */
public class MainFragment extends BaseFragment implements UserListView{

    public interface UserListListener {
        void onUserClicked(final User user);
    }

    private UsersAdapter usersAdapter;
    private UserListListener userListListener;

    @Inject
    UserListPresenter userListPresenter;

    @Bind(R.id.rv_users)
    RecyclerView rv_users;

    public MainFragment() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof UserListListener) {
            this.userListListener = (UserListListener) activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_user_list, container, true);
        ButterKnife.bind(this, fragmentView);
        setupUI();
        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.initialize();
        this.loadUserList();
    }

    private void loadUserList() {
        this.userListPresenter.initialize();
    }

    private void initialize() {
        this.getComponent(UserComponent.class).inject(this);
        this.userListPresenter.setView(this);
    }

    private void setupUI() {
        this.rv_users.setLayoutManager(new LinearLayoutManager(getActivity()));

        this.usersAdapter = new UsersAdapter(getActivity(), new ArrayList<User>());
        this.usersAdapter.setOnItemClickListener(onItemClickListener);
        this.rv_users.setAdapter(usersAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.userListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.userListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.userListPresenter.destroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void renderUserList(Collection<User> userCollection) {
        if (userCollection != null) {
            this.usersAdapter.setUsersCollection(userCollection);
        }
    }

    @Override
    public void viewUser(User user) {
        if (this.userListListener != null) {
            this.userListListener.onUserClicked(user);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return null;
    }

    private UsersAdapter.OnItemClickListener onItemClickListener =
            user -> {
                if (MainFragment.this.userListPresenter != null && user != null) {
                    MainFragment.this.userListPresenter.ouUserClicked(user);
                }
            };
}
