package com.gavincode.daggerplayground.domain.repository;

import com.gavincode.daggerplayground.data.UserDataStore;
import com.gavincode.daggerplayground.data.UserDataStoreFactory;
import com.gavincode.daggerplayground.presentation.model.User;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public class UserDataRepository implements UserRepository{

    private final UserDataStoreFactory userDataStoreFactory;


    @Inject
    public UserDataRepository(UserDataStoreFactory userDataStoreFactory) {
        this.userDataStoreFactory = userDataStoreFactory;
    }

    @Override
    public Observable<List<User>> getUsers() {
        UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.getUserEntityList();
    }

    @Override
    public Observable<User> getUser(final int userId) {
        UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
        return userDataStore.getUserEntityDetails(userId);
    }
}
