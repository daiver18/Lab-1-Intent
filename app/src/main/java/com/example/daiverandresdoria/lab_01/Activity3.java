package com.example.daiverandresdoria.lab_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    private Button btnInfo;
    private ImageButton btnSharing;

    private String Name = "";
    private int Age;
    private int Option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnInfo = findViewById(R.id.buttonActivity3);
        btnSharing = findViewById(R.id.imageButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && !bundle.isEmpty()){
            Name = bundle.getString("name");
            Age = bundle.getInt("age");
            Option = bundle.getInt("option");
            btnSharing.setVisibility(View.INVISIBLE);
        }

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity3.this, createMessage(Name,Age,Option), Toast.LENGTH_LONG).show();
                btnSharing.setVisibility(View.VISIBLE);
                btnInfo.setVisibility(View.INVISIBLE);
            }
        });

        btnSharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSharing = new Intent(Intent.ACTION_SEND);
                intentSharing.setType("text/plain");
                intentSharing.putExtra(Intent.EXTRA_TEXT, createMessage(Name,Age,Option));
                startActivity(intentSharing);
            }
        });

    }

    private String createMessage(String Name, int Age, int Option) {
        if (Option == Activity2.Option_Hello) {
            return "Hola " + Name + " como llevas esos " + Age + " años? #Myfrom";
        } else {
           return "espero verte pronto " + Name + " antes de que cumplas esos " + (Age + 1) + " años #Myfrom";

        }

    }
}
