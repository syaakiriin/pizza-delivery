package com.example.user.pizzadelivery;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    Button bHome,bLogin;
    DatabaseLoginRegister databaseLoginRegister;
    User user;

    @Override
    protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlogin);
        View view = getWindow().getDecorView().getRootView();





        //create a instance of SQLite Database
        databaseLoginRegister = new DatabaseLoginRegister(this);

        //Get the Refference Of Buttons
        bHome = (Button)findViewById(R.id.bHome);
        bLogin = (Button)findViewById(R.id.bLogin);
        signin(view);





        bHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(home);
            }
        });
    }




    public void signin(View view){

        //get the Refferences of views
        final EditText editUsername = (EditText)findViewById(R.id.editUsername);
        final EditText editPassword = (EditText)findViewById(R.id.editPassword);



        //Set on ClickListener
        bLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();




                //fetch the password from database respective username
                String storedpassword =databaseLoginRegister.getSingleEntry(username);
                //check if the stored password matches with password entered by user
                if(password.equals(storedpassword)){
                    Toast.makeText(LoginActivity.this,"Congrats Login Succesfull",
                            Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(LoginActivity.this,"USER NAME OR PASSWORD does not match",
                            Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //
    }




}
