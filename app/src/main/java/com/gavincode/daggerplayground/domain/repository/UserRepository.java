package com.gavincode.daggerplayground.domain.repository;

import com.gavincode.daggerplayground.presentation.model.User;

import java.util.List;

import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public interface UserRepository {

    Observable<List<User>> getUsers();

    Observable<User> getUser(final int userId);
}
