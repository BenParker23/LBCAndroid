package lbs.com.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by BenPa on 10/05/2018.
 */

public class MUser  {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public MUser(String name, String job) {
        this.name = name;
        this.job = job;
    }


}
