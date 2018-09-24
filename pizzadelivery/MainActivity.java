package com.example.user.pizzadelivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Button bMenu, bLogin, bRegister;

        bMenu = (Button)findViewById(R.id.bMenu);
        bLogin = (Button)findViewById(R.id.bLogin);
        bRegister = (Button)findViewById(R.id.bRegister);

        bMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(getApplicationContext(),
                        MenuActivity.class);
                startActivity(menu);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(login);
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(),
                        RgisterActivity.class);
                startActivity(register);
            }
        });
    }
}
