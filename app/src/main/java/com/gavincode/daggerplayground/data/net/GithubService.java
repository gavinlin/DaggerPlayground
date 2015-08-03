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
            "Authorization: token b7e8cdf8b8352d11cfbf632d9239643a11688ccf"    })
    @GET("/users")
    Observable<List<User>> listUsers();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App",
            "Authorization: token b7e8cdf8b8352d11cfbf632d9239643a11688ccf"    })
    @GET("/user/{id}")
    Observable<User> user(@Path("id") int id);
}
