package com.example.mortageapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
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
                (Double.parseDouble(amtInterest.getText().toString()) /100),
                Double.parseDouble(amtTenure.getText().toString()),
                Integer.parseInt(amtMonths.getText().toString()));

        outputStr.setText("Monthly Payment: $" + mortgageAmt);


    }


    // function to deal with mortgage calculation
    private double calculateMortgage(double interestAmt, double principalAmt, int months){

        double mortgageAmt;

        double monthlyInterestRate = interestAmt / 12;

        mortgageAmt = principalAmt *  (monthlyInterestRate * Math.pow((1 + monthlyInterestRate),months) / (Math.pow((1 + monthlyInterestRate),months) - 1));


        return Math.round(mortgageAmt * 100.0) / 100.0;
    }


    public void tdButton(View view) {
        // Create an Intent to open the TD Mortgage Calculator website
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://apps.td.com/mortgage-payment-calculator/"));
        startActivity(intent);

    }
}