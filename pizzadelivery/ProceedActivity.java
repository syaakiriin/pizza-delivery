package com.example.user.pizzadelivery;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ProceedActivity extends AppCompatActivity {
    Button bView,bDone;
    DatabaseHelper Mydb;

    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutproceed);
        Mydb = new DatabaseHelper(this);

        bView = (Button)findViewById(R.id.bView);
        bDone = (Button)findViewById(R.id.bDone);

        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent done = new Intent(getApplicationContext(),
                        MenuActivity.class);
                startActivity(done);
            }
        });
        view();
    }

    public void view() {
        bView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = Mydb.getAllData();
                if(result.getCount()==0){
                    showMessage("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()) {
                    buffer.append("NO ID : "+result.getString(0)+"\n");
                    buffer.append("Pizza : "+result.getString(1)+"\n");
                    buffer.append("Quantity : "+result.getString(2)+"\n");
                    buffer.append("Topping : "+result.getString(3)+"\n");

                }
                //show all data
                showMessage("All Data",buffer.toString());
            }
        });
    }

    public  void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }




}
