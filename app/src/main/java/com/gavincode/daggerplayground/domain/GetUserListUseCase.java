package com.gavincode.daggerplayground.domain;

import com.gavincode.daggerplayground.domain.repository.UserRepository;
import com.gavincode.daggerplayground.presentation.model.User;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public class GetUserListUseCase extends UseCase{
    private final UserRepository userRepository;

    @Inject
    public GetUserListUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Observable<java.util.List<User>> buildUseCaseObservable() {
        return this.userRepository.getUsers();
    }

}
