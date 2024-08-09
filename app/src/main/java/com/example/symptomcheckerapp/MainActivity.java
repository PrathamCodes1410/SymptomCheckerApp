package com.example.symptomcheckerapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // For any queries contact : prathamdt@gmail.com
        // Written by Pratham Darshankumar Thakkar

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final String[] symptoms = {
                "Fever",
                "Cough",
                "Headache",
                "Fatigue",
                "Sore Throat",
                "Runny Nose",
                "Muscle Pain",
                "Chills",
                "Shortness of Breath",
                "Loss of Taste",
                "Loss of Smell",
                "Nausea",
                "Vomiting",
                "Diarrhea",
                "Congestion",
                "Sneezing",
                "Chest Pain"
        };

        Spinner spinner = findViewById(R.id.spin);
        Button btn = findViewById(R.id.submit_button);
        Button btn2 = findViewById(R.id.button2);
        LinearLayout llv = findViewById(R.id.linearLayout3);
        llv.removeAllViews();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button clear = findViewById(R.id.button3);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, symptoms);

        spinner.setAdapter(adapter);

        final int[] ClickCountAdd = {0};
        final String[][] strArray = {new String[5]};
        final String[][] arr = {{}};
        final int[] cc = {0};
        final String[][] finalSymptom = {{}};

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llv.removeAllViews();
                llv.invalidate();
                ClickCountAdd[0] = 0;
                cc[0] = 0;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(ClickCountAdd[0] == 0){
                    ClickCountAdd[0]++;
                    arr[0] = symptoms;
                }
                else{
                    ClickCountAdd[0]++;
                }
                if(ClickCountAdd[0] <= 5) {

                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(spinner.getSelectedItem().toString());
                    String str = spinner.getSelectedItem().toString();
                    strArray[0][cc[0]] = str;
                    cc[0] = cc[0] + 1;
                    llv.addView(textView);
                    String[] arr_new = new String[arr[0].length - 1];
                    ;
                    if (ClickCountAdd[0] > 0) {
                        for (int i = 0, j = 0; i < arr[0].length; i++) {
                            if (!Objects.equals(str, arr[0][i])) {
                                arr_new[j] = arr[0][i];
                                j++;
                            }
                        }
                        arr[0] = arr_new;

                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, arr[0]);
                        spinner.setAdapter(adapter2);

                    }
                    if(ClickCountAdd[0] >= 6){
                        Toast t = Toast.makeText(MainActivity.this, "Cannot Add more than 5", Toast.LENGTH_LONG);
                        t.show();
                        System.out.println("Here");
                    }
                }

            }
        });




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String s = spinner.getSelectedItem().toString();
                //Toast.makeText(MainActivity.this, "Current Dropdown is : " + s, Toast.LENGTH_LONG).show();
                String first = "", sec = "", third = "";
                for(int i = 0; i < 3; i++){
                    if(i == 0){
                        first = strArray[0][0];
                    }
                    if(i == 1){
                        sec = strArray[0][1];
                    }
                    if(i == 2){
                        third = strArray[0][2];
                    }
                }
                goToAnotherActivity(first, sec, third);
            }
        });

        /*

        © Pratham Darshankumar Thakkar

        */

    }


    public void goToAnotherActivity(String first_symp, String sec_symp, String third_symp){
        Intent add = new Intent(this, SecondActivity.class);
        add.putExtra("first", first_symp);
        add.putExtra("second", sec_symp);
        add.putExtra("third", third_symp);
        startActivity(add);
    }
}