package com.weboniselab.meghana.android.app.recyclerandcardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String name,age;
    EditText tvAge,tvName;
    Button btnAdd;
    DatabaseOperations databaseOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
    }

    public void initialise(){
        tvName=(EditText) findViewById(R.id.tvName);
        tvAge=(EditText) findViewById(R.id.tvAge);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        databaseOperations=new DatabaseOperations(this);
        name=tvName.getText().toString();
        Log.d("********",name);
        age=tvAge.getText().toString();

    }

    @Override
    public void onClick(View v) {

        databaseOperations.addDetailsToDatabase(name,age);
        Intent intent=new Intent(MainActivity.this,RecyclerView.class);
        startActivity(intent);

    }
}
