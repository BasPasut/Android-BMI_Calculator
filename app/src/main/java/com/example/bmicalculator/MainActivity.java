package com.example.bmicalculator;

import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI(View view){
        EditText heightText = (EditText) findViewById(R.id.height);
        EditText weightText = (EditText) findViewById(R.id.weight);
        TextView result = (TextView) findViewById(R.id.textShow);
        ImageView imgResult = (ImageView) findViewById(R.id.imageShow);

        double height = Double.parseDouble(heightText.getText().toString());
        double weight = Double.parseDouble(weightText.getText().toString());
        double bmi = weight/Math.pow((height/100),2);

        imgResult.setVisibility(View.VISIBLE);
        if(bmi < 18.5){
            imgResult.setImageResource(R.drawable.uw);
            result.setText("Underweight");
        }
        else if(bmi >= 18.5 && bmi < 24.9){
            imgResult.setImageResource(R.drawable.norm);
            result.setText("Normal");
        }
        else if(bmi >= 24.9 && bmi < 29.9){
            imgResult.setImageResource(R.drawable.ow);
            result.setText("Overweight");
        }
        else if(bmi >= 29.9 && bmi < 34.9){
            imgResult.setImageResource(R.drawable.obese);
            result.setText("Obese");
        }
        else if(bmi >= 34.9){
            imgResult.setImageResource(R.drawable.exobe);
            result.setText("ExtremeObese");
        }
        else{
            imgResult.setImageResource(R.drawable.uw);
            result.setText("Unknown");
        }
    }
}
