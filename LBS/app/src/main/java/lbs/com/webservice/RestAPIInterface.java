package lbs.com.webservice;

import lbs.com.model.MUser;
import lbs.com.model.MUserList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by BenPa on 10/05/2018.
 */

public interface RestAPIInterface {

        @GET("/api/unknown")
        Call<MultipleResource> doGetListResources();

        @POST("/api/users")
        Call<MUser> createUser(@Body MUser user);

        @GET("/api/users?")
        Call<MUserList> doGetUserList(@Query("page") String page);

        @FormUrlEncoded
        @POST("/api/users?")
        Call<MUserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
    }
