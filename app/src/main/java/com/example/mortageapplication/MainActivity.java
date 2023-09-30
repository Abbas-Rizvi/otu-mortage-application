package com.example.mortageapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private TextView outputStr;
    private EditText amtTenure;
    private EditText amtInterest;
    private EditText amtMonths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputStr = (TextView) findViewById(R.id.outputString);

        amtInterest = (EditText) findViewById((R.id.interestText));
        amtTenure = (EditText) findViewById((R.id.principalAmt));
        amtMonths = (EditText) findViewById((R.id.monthPeriods));


    }

    // called when the calculate button is pressed
    public void handleCalculateBtn(View v) {

        double mortgageAmt;

        mortgageAmt = calculateMortgage(
                Double.parseDouble(amtInterest.getText().toString()),
                Double.parseDouble(amtTenure.getText().toString()),
                Integer.parseInt(amtMonths.getText().toString()));

        outputStr.setText("Monthly Payment: $" + mortgageAmt);


    }


    // function to deal with mortgage calculation
    private double calculateMortgage(double interestAmt, double principalAmt, int months){

        double mortgageAmt;


        mortgageAmt = principalAmt *  interestAmt * Math.pow(( 1 - interestAmt),months) / (Math.pow(( 1 + interestAmt), months) - 1);

        return mortgageAmt;
    }

}