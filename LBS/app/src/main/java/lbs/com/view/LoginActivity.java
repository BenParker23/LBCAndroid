package lbs.com.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import lbs.com.R;


public class LoginActivity extends AppCompatActivity implements OnClickListener{


    private Button loginBut;
    private Button signupBut;
    private EditText username;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /** Initialise variables **/
        loginBut = (Button)findViewById(R.id.email_sign_in_button);
        signupBut = (Button)findViewById(R.id.signupBut);
        username = (EditText) findViewById(R.id.username);
        loginBut.setOnClickListener(this);
        pass = (EditText)findViewById(R.id.password);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onClick(View view) {

        /** Handle all login button clicks **/
        if (view.getId() == loginBut.getId()){
            if (username.getText() != null && pass.getText() != null){
                Intent mainMenu = new Intent(this.getApplicationContext(), MainMenuActivity.class);
                startActivity(mainMenu);
            }
        }
    }
}

