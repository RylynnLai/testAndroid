package com.example.rylynn.mywechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button firstBtn;
    Button secondBtn;
    Button thirdBtn;
    Button fourthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstBtn = this.findViewById(R.id.firstBtn);
        secondBtn = this.findViewById(R.id.secondBtn);
        thirdBtn = this.findViewById(R.id.thirdBtn);
        fourthBtn = this.findViewById(R.id.fourthBtn);

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("firth btn");
            }
        });

        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("second btn");
            }
        });

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("third btn");
            }
        });

        fourthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("fourth btn");
            }
        });

    }
}
