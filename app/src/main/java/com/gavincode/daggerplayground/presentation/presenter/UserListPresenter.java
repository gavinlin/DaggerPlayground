package com.gavincode.daggerplayground.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.gavincode.daggerplayground.domain.GetUserListUseCase;
import com.gavincode.daggerplayground.presentation.model.User;
import com.gavincode.daggerplayground.presentation.view.UserListView;
import com.gavincode.daggerplayground.util.DefaultSubscriber;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by gavinlin on 31/07/15.
 */
public class UserListPresenter extends DefaultSubscriber<List<User>> implements Presenter {

    private static final String TAG = UserListPresenter.class.getSimpleName();

    private UserListView userListView;

    private final GetUserListUseCase getUserListUseCase;

    @Inject
    public UserListPresenter( GetUserListUseCase getUserListUseCase) {
        this.getUserListUseCase = getUserListUseCase;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getUserListUseCase.unsubscribe();
    }

    public void initialize() {
        this.loadUserList();
    }

    private void loadUserList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getUserList();
    }

    private void showViewLoading() {
        this.userListView.showLoading();
    }

    private void hideViewLoading() {
        this.userListView.hideLoading();
    }

    private void showViewRetry() {
        this.userListView.showRetry();
    }

    private void hideViewRetry() {
        this.userListView.hideRetry();
    }

    private void showErrorMessage(String message) {
        this.userListView.showError(message);
    }

    private void showUsersCollectionInView(Collection<User> userCollection) {
        this.userListView.renderUserList(userCollection);
    }

    private void getUserList() {
        this.getUserListUseCase.execute(new UserListSubscriber());
    }

    public void ouUserClicked(User user) {
        Log.i(TAG, user.toString());
    }

    public void setView(@NonNull UserListView view) {
        this.userListView = view;

    }

    private final class UserListSubscriber extends DefaultSubscriber<List<User>> {
        @Override
        public void onCompleted() {
            UserListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            UserListPresenter.this.hideViewLoading();
            UserListPresenter.this.showErrorMessage(e.getMessage());
            UserListPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<User> users) {
            UserListPresenter.this.showUsersCollectionInView(users);
        }
    }
}
