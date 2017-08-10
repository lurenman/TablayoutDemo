package com.example.administrator.tablayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_tablayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvent();
    }

    private void initViews()
    {
        tv_tablayout= (TextView) findViewById(R.id.tv_tablayout);
    }
    private void initEvent()
    {
        tv_tablayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TabLayoutActivity.class);
                startActivity(intent);
            }
        });
    }

}
