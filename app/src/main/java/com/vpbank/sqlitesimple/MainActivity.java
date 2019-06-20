package com.vpbank.sqlitesimple;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btnUpdate;
    SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUpdate = findViewById(R.id.btnUpdate);

        sqlHelper = new SQLHelper(this);
        sqlHelper.insertProduct();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlHelper.updateProduct(1);
                sqlHelper.getAllProduct();
            }
        });
    }


//    public void getFragment(Fragment fragment) {
//        try {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, fragment)
//                    .commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d(TAG, "getFragment: " + e.getMessage());
//        }
//    }
}
