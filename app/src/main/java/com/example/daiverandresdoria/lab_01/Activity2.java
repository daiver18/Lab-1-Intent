package com.example.daiverandresdoria.lab_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private RadioButton RBsaludar;
    private RadioButton RBdespedir;
    private Button btnNext;
    private SeekBar seekbar;
    private TextView textViewEdad;
    //////////////////////////////////////
    private int age = 18;
    private String Name="";
    private final int Max_age = 60;
    private final int Min_age = 16;
    //////////////////////////////////////
    public static final int Option_Hello = 1;
    public static final int Option_Bye = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle name = getIntent().getExtras();
        Name = name.getString("Name");

        RBsaludar=findViewById(R.id.radioButton);
        RBdespedir=findViewById(R.id.radioButton2);
        seekbar=findViewById(R.id.seekBar);
        textViewEdad=findViewById(R.id.textView);
        btnNext=findViewById(R.id.button);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int currentAge, boolean fromUser) {
                age = currentAge;
                textViewEdad.setText(age + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                age = seekBar.getProgress();
                textViewEdad.setText(age+"");

                if (age > Max_age){
                    btnNext.setVisibility(View.INVISIBLE);
                    Toast.makeText(Activity2.this,"the Max is 60",Toast.LENGTH_LONG).show();
                }else if (age < Min_age){
                    btnNext.setVisibility(View.INVISIBLE);
                    Toast.makeText(Activity2.this,"the Min is 16",Toast.LENGTH_LONG).show();
                }else
                    btnNext.setVisibility(View.VISIBLE);
            }
        });

       btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intetNext = new Intent(Activity2.this,Activity3.class);
                intetNext.putExtra("age",age);
                intetNext.putExtra("name",Name);
                int option = (RBsaludar.isChecked()) ? Option_Hello : Option_Bye;
                intetNext.putExtra("option",option);
                startActivity(intetNext);
                Toast.makeText(Activity2.this, seekbar.getProgress()+"", Toast.LENGTH_LONG).show();
            }

        });

    }
}
