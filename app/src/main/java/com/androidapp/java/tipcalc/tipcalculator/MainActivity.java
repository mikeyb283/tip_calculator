package com.androidapp.java.tipcalc.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double mealCost, tip, percentage, billTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cost = findViewById(R.id.enter_bill);
        final Spinner group = findViewById(R.id.spinner);
        final Button calc_total = findViewById(R.id.button);

        calc_total.setOnClickListener(new View.OnClickListener() {
            final TextView total = findViewById(R.id.total);
            @Override
            public void onClick(View view) {
                mealCost = Double.parseDouble(cost.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                percentage = Integer.parseInt(group.getSelectedItem().toString());
                tip = mealCost * (percentage/100);
                billTotal = mealCost + tip;
                total.setText(String.format("Bill total with tip:\n%s", currency.format(billTotal)));
            }
        });
    }
}
