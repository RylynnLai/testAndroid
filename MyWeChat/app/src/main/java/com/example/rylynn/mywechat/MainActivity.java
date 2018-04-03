package com.example.rylynn.mywechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button tabBarBtn;
    Button toastBtn;
    Button testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        selectorMethod();
    }

    private void initView() {
        tabBarBtn = findViewById(R.id.tabbar_btn);
        toastBtn = findViewById(R.id.toast_btn);
        testBtn = findViewById(R.id.test_btn);
    }

    private void selectorMethod() {
        tabBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabBarActivity.class);
                intent.putExtra("meg", "5555555");
                startActivity(intent);
            }
        });
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast不会中断界面交互
//                Toast t = Toast.makeText(getApplicationContext(), "test，toast不会中断界面交互", Toast.LENGTH_LONG);
//                t.setGravity(0, 0, 100);
//                t.show();

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout, null);
                Toast toast = new Toast(getApplicationContext());
                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("test", "testtest");
            }
        });

    }
}
