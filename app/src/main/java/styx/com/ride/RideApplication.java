package styx.com.ride;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by amalg on 11-10-2015.
 */
public class RideApplication extends Application{
    public static final String YOUR_APPLICATION_ID = "uXRedn85172yfCkHuGa6YalcevkfhO7K9pMmKPYW";
    public static final String YOUR_CLIENT_KEY = "7Py3UfTpBApsau0ktqcfKVRXLBJmDQ9alR6fi3YU";

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);

        // ...
    }
}