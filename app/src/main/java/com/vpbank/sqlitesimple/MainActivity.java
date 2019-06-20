package com.vpbank.sqlitesimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLHelper sqlHelper = new SQLHelper(this);
        sqlHelper.insertProduct();
    }
}
