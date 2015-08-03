package com.gavincode.daggerplayground.data.net;

import com.gavincode.daggerplayground.presentation.model.User;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by gavinlin on 31/07/15.
 */
public interface GithubService {

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App",
            "Authorization: token fd1cc1c24799e8844c88a0600f949c07a242e487"})
    @GET("/users")
    Observable<List<User>> listUsers();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App",
            "Authorization: token fd1cc1c24799e8844c88a0600f949c07a242e487"})
    @GET("/user/{id}")
    Observable<User> user(@Path("id") int id);
}
