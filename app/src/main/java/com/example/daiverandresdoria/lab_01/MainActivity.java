package com.example.daiverandresdoria.lab_01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_myicon2);

        btnNext=findViewById(R.id.buttonActivity2);
        editTextName=findViewById(R.id.editTextName);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = editTextName.getText().toString();
                if (Name!=null && !Name.isEmpty()){
                    Intent intentNext = new Intent(MainActivity.this, Activity2.class);
                    intentNext.putExtra("Name", Name);
                    startActivity(intentNext);
                }else{
                    Toast.makeText(MainActivity.this,"imput a valid Name",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
