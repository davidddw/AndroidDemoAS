package jbuilder.org.android_dagger2_demo.data.api;

import java.util.List;

import jbuilder.org.android_dagger2_demo.data.api.response.RepositoryResponse;
import jbuilder.org.android_dagger2_demo.data.api.response.UserResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by d05660ddw on 16/9/4.
 */
public interface GithubApiService {

    @GET("/users/{username}")
    Observable<UserResponse> getUser(@Path("username") String username);

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(@Path("username") String username);
}
