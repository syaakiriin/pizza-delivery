package com.example.user.pizzadelivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RgisterActivity extends AppCompatActivity {

    EditText editUsername,editPassword,editEmail,editAddress,editNoPhone;
    Button bSignup, bHome;

    DatabaseLoginRegister databaseLoginRegister;
    User user;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);

        //get instance of databaseloginregister
        databaseLoginRegister = new DatabaseLoginRegister(this);


        //get reference of views
        editUsername=(EditText)findViewById(R.id.editUsername);
        editPassword=(EditText)findViewById(R.id.editPassword);
        editEmail=(EditText)findViewById(R.id.editEmail);
        editAddress=(EditText)findViewById(R.id.editAddress);
        editNoPhone=(EditText)findViewById(R.id.editNoPhone);

        bSignup = (Button)findViewById(R.id.bSignUp) ;
        bHome =(Button)findViewById(R.id.bHome);
        bHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(home);
            }
        });
        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = editUsername.getText().toString();
                String Password = editPassword.getText().toString();
                String Email = editEmail.getText().toString();
                String Address = editAddress.getText().toString();
                String NoPhone = editNoPhone.getText().toString();
                //save data in database
                databaseLoginRegister.addUser(user);
                Toast.makeText(getApplicationContext(), "Account Succesfully Created",Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
