package lbs.com.model;

/**
 * Created by BenPa on 10/05/2018.
 */

import com.google.gson.Gson;

/** All persistent objects must
 * implement this class to become saveable
 **/
public abstract class DBObject implements I_Saveable {

    public abstract int fromJson(String json);


}
