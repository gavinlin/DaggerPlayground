package com.gavincode.daggerplayground.data;

import com.gavincode.daggerplayground.data.net.RestApi;
import com.gavincode.daggerplayground.data.net.RestApiImpl;

import javax.inject.Inject;

/**
 * Created by gavinlin on 31/07/15.
 */
public class UserDataStoreFactory {

    @Inject
    public UserDataStoreFactory() {
    }

    public UserDataStore create(int userId) {
        return createCloudDataStore();
    }

    public UserDataStore createCloudDataStore() {
        RestApi restApi = new RestApiImpl();
        return new CloudUserDataStore(restApi);
    }
}
