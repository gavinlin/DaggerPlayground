package com.gavincode.daggerplayground.data;

import com.gavincode.daggerplayground.presentation.model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public interface UserDataStore {

    Observable<List<User>> getUserEntityList();
    Observable<User> getUserEntityDetails(final int id);
}
