package lbs.com.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import lbs.com.R;
import lbs.com.model.MUser;
import lbs.com.model.MUserList;
import lbs.com.webservice.MultipleResource;
import lbs.com.webservice.RestAPIClient;
import lbs.com.webservice.RestAPIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainMenuActivity extends AppCompatActivity {

    RestAPIInterface apiInterface;
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = RestAPIClient.getClient().create(RestAPIInterface.class);


        /**
         GET List Resources
         **/
        Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {


                Log.d("TAG",response.code()+"");

                String displayResponse = "";

                MultipleResource resource = response.body();
                Integer text = resource.page;
                Integer total = resource.total;
                Integer totalPages = resource.totalPages;
                List<MultipleResource.Datum> datumList = resource.data;

                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";

                for (MultipleResource.Datum datum : datumList) {
                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
                }

                responseText.setText(displayResponse);

            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                call.cancel();
            }
        });

        /**
         Create new user
         **/
        MUser user = new MUser("morpheus", "leader");
        Call<MUser> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<MUser>() {
            @Override
            public void onResponse(Call<MUser> call, Response<MUser> response) {
                MUser user1 = response.body();

                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<MUser> call, Throwable t) {
                call.cancel();
            }
        });

        /**
         GET List Users
         **/
        Call<MUserList> call2 = apiInterface.doGetUserList("2");
        call2.enqueue(new Callback<MUserList>() {
            @Override
            public void onResponse(Call<MUserList> call, Response<MUserList> response) {

                MUserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<MUserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();

                for (MUserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<MUserList> call, Throwable t) {
                call.cancel();
            }
        });


        /**
         POST name and job Url encoded.
         **/
        Call<MUserList> call3 = apiInterface.doCreateUserWithField("morpheus","leader");
        call3.enqueue(new Callback<MUserList>() {
            @Override
            public void onResponse(Call<MUserList> call, Response<MUserList> response) {
                MUserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<MUserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();

                for (MUserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MUserList> call, Throwable t) {
                call.cancel();
            }
        });

    }


    }

