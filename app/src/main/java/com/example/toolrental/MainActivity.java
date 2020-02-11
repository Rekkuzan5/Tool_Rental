package com.example.toolrental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double washer = 55.99;
    private double tiller = 68.99;
    private int days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        Button update = findViewById(R.id.button);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText daysText = findViewById(R.id.editText);
                String guess = daysText.getText().toString();
                if (TextUtils.isEmpty(guess)) {
                    Toast.makeText(getApplicationContext(),"Please enter amount of days for rental.", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Toast.makeText(getApplicationContext(),"Please enter amount of days for rental.", Toast.LENGTH_SHORT).show();
                    days = Integer.parseInt(daysText.getText().toString());
                }

                RadioButton tillerButton, washerButton;
                tillerButton = findViewById(R.id.radioButton);
                washerButton = findViewById(R.id.radioButton2);

                if (tillerButton.isChecked() || washerButton.isChecked()) {
                    Log.d("check", "a button is selected.");
                } else {
                    Toast.makeText(getApplicationContext(), "Please select a rental tool option.", Toast.LENGTH_SHORT).show();
                    Log.d("check", "button is null.");
                }

                if (tillerButton.isChecked()) {
                    double tillerRentalPrice = tiller * days;
                    //String tillerTotal = Double.toString(tillerRentalPrice);
                    DecimalFormat df = new DecimalFormat("$###.##");
                    TextView total = findViewById(R.id.textView2);
                    total.setText(df.format(tillerRentalPrice));
                }
                else if (washerButton.isChecked()) {
                    double washerRentalPrice = washer * days;
                    //String washerTotal = Double.toString(washerRentalPrice);
                    DecimalFormat df = new DecimalFormat("$###.##");
                    TextView total = findViewById(R.id.textView2);
                    total.setText(df.format(washerRentalPrice));
                }

            }
        });

    }


}
