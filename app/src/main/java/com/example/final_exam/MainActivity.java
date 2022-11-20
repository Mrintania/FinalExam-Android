package com.example.final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Car Oil calculator

    EditText Price, Distance;
    Button Calculate,reset;
    RadioButton EcoCar, SUV, Sedan;
    TextView ResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Price = findViewById(R.id.ed_PriceOil);
        Distance =findViewById(R.id.ed_distance);
        EcoCar = findViewById(R.id.rad_ecocar);
        SUV = findViewById(R.id.rad_SUV);
        Sedan = findViewById(R.id.rad_sedan);
        Calculate = findViewById(R.id.btn_cal);
        ResultText = findViewById(R.id.tv_result);
        reset = findViewById(R.id.btn_reset);

        //eco-car 17km/l
        //suv 9km/l
        //sedan 12km/l

        Calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double price = Double.parseDouble(Price.getText().toString());
                double distance = Double.parseDouble(Distance.getText().toString());
                double result = 0;
                if(EcoCar.isChecked()){
                    result = (distance/17)*price;
                }
                else if(SUV.isChecked()){
                    result = (distance/9)*price;
                }
                else if(Sedan.isChecked()){
                    result = (distance/12)*price;
                }
                ResultText.setText("Total cost: " + result + " บาท");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Price.setText("");
                Distance.setText("");
                ResultText.setText("");

            }
        });











    }
}