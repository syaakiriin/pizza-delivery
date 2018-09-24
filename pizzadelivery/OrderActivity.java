package com.example.user.pizzadelivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class OrderActivity extends AppCompatActivity {

    Spinner tOrder;
    EditText editQuantity,editID,tTopping;
    Button bBack,bAdd,bProceed;
    private DatabaseHelper Mydb;


    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderlayout);
        Mydb = new DatabaseHelper(this);



        bAdd = (Button)findViewById(R.id.bAdd);
        bBack = (Button)findViewById(R.id.bBack);
        bProceed = (Button)findViewById(R.id.bProceed);
        editQuantity = (EditText)findViewById(R.id.editQuantity);
        editID = (EditText)findViewById(R.id.editID);
        tOrder = (Spinner)findViewById(R.id.tOrder);
        tTopping = (EditText)findViewById(R.id.editTopping);

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(),
                        MenuActivity.class);
                startActivity(back);
            }
        });

        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proceed = new Intent(getApplicationContext(),
                        ProceedActivity.class);
                startActivity(proceed);
            }
        });

        String [] pizzas = {"Double Cheese Pan Crust Mushroom","Extra Mushroom Pan Pizza","Sausage Pan Pizza"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<>(this,android.R.layout.simple_spinner_item,pizzas);
        tOrder.setAdapter(adapter);



        //instantiate

        Mydb = new DatabaseHelper(this);
        addData();
    }


    public void addData() {
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from layout to insert into table
                boolean insertData = Mydb.insertData(tOrder.getSelectedItem().toString(),editQuantity.getText().toString(),tTopping.getText().toString());

                if (insertData == true) {
                    //create Toast to alert user
                    Toast.makeText(OrderActivity.this, " Data Inserted ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(OrderActivity.this, " Data NOT Inserted ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
