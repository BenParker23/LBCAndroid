package lbs.com.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lbs.com.R;
import lbs.com.webservice.WebServiceConnection;

public class MainMenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        WebServiceConnection wsc = new WebServiceConnection();
                wsc.execute();
    }


}

