package com.vpbank.sqlitesimple.sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vpbank.sqlitesimple.R;

public class Main2Activity extends AppCompatActivity {
    EditText etName, etQuantity;
    Button btnInsert;

    SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName = findViewById(R.id.etNameInsert);
        etQuantity = findViewById(R.id.etQuantityInsert);
        btnInsert = findViewById(R.id.btnInsertNew);

        sqlHelper = new SQLHelper(getBaseContext());

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String quantity = etQuantity.getText().toString();

                sqlHelper.insertProduct(name, quantity);
                Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
            }
        });
    }
}
