package lbs.com.model;


import java.util.Properties;

/**
 * Environment variables and current state of system
 */
public class Env {

    private static Properties props;

    public static void addProperty(String name, Object value){
        props.put(name, value);
    }

    public static Object getProperty(String name){
        return props.getProperty(name);
    }


}
