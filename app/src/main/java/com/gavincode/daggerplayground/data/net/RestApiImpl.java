package com.gavincode.daggerplayground.data.net;

import com.gavincode.daggerplayground.presentation.model.User;

import java.util.List;

import retrofit.RestAdapter;
import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public class RestApiImpl implements RestApi{

    private final RestAdapter restAdapter;
    private final GithubService githubService;

    public RestApiImpl() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(RestApi.API_BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        githubService = restAdapter.create(GithubService.class);
    }

    @Override
    public Observable<List<User>> getUserEntityList() {
        return githubService.listUsers();
    }

    @Override
    public Observable<User> getUserEntityById(int userId) {
        return githubService.user(userId);
    }

}
