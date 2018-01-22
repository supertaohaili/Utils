package com.thl.utils;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;


public class MainActivity extends FragmentActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}