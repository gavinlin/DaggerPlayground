package com.gavincode.daggerplayground.data;

import com.gavincode.daggerplayground.data.net.RestApi;
import com.gavincode.daggerplayground.presentation.model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public class CloudUserDataStore implements UserDataStore{

    private final RestApi restApi;

    public CloudUserDataStore(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<List<User>> getUserEntityList() {
        return this.restApi.getUserEntityList();
    }

    @Override
    public Observable<User> getUserEntityDetails(int id) {
        return this.restApi.getUserEntityById(id);
    }
}
