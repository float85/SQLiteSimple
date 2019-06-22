package com.vpbank.sqlitesimple.sql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vpbank.sqlitesimple.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btnUpdate, btnInsert;
    EditText etName, etQuantity, etNameUpdate, etQuantityUpdate, etID;
    SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlHelper = new SQLHelper(getBaseContext());

        btnInsert = findViewById(R.id.btnInsert);
        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);

        btnUpdate = findViewById(R.id.btnUpdate);
        etID = findViewById(R.id.etIDUpdate);
        etNameUpdate = findViewById(R.id.etNameUpdate);
        etQuantityUpdate = findViewById(R.id.etQuantityUpdate);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String quantity = etQuantity.getText().toString();
                sqlHelper.insertProduct(name, quantity);
                Toast.makeText(getBaseContext(), "Insert Done", Toast.LENGTH_LONG).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etID.getText().toString();
                String nameUpdate = etNameUpdate.getText().toString();
                String quantityUpdate = etQuantityUpdate.getText().toString();
                sqlHelper.updateProduct(id, nameUpdate, quantityUpdate);
            }
        });
    }
}
