package com.example.rylynn.mywechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button tabBarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        selectorMethod();
    }

    private void initView() {
        tabBarBtn = findViewById(R.id.tabbar_btn);
    }

    private void selectorMethod() {
        tabBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabBarActivity.class);
                startActivity(intent);
            }
        });
    }
}
