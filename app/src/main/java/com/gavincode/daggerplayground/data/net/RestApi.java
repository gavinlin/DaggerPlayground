package com.gavincode.daggerplayground.data.net;

import com.gavincode.daggerplayground.presentation.model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public interface RestApi {
    static final String API_BASE_URL = "https://api.github.com";

    Observable<List<User>> getUserEntityList();

    Observable<User> getUserEntityById(final int userId);
}
