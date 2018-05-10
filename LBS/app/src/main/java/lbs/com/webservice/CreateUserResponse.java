package lbs.com.webservice;

import com.google.gson.annotations.SerializedName;

/**
 * Created by BenPa on 10/05/2018.
 */

public class CreateUserResponse {
        @SerializedName("name")
        public String name;
        @SerializedName("job")
        public String job;
        @SerializedName("id")
        public String id;
        @SerializedName("createdAt")
        public String createdAt;
    }



