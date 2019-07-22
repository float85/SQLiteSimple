package com.vpbank.sqlitesimple.sql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vpbank.sqlitesimple.R;
import com.vpbank.sqlitesimple.sql.adapter.AdapterProduct;
import com.vpbank.sqlitesimple.sql.adapter.onClickProduct;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btnUpdate, btnInsert, btnDelete, btnDelAll, btnShow;
    EditText etName, etQuantity, etNameUpdate, etQuantityUpdate, etID, etIDDelete;
    SQLHelper sqlHelper;

    RecyclerView rvProduct;
    List<Product> productList;
    AdapterProduct adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlHelper = new SQLHelper(getBaseContext());

        //Insert
        btnInsert = findViewById(R.id.btnInsert);
        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String quantity = etQuantity.getText().toString();

                sqlHelper.insertProduct(name, quantity);
                Toast.makeText(getBaseContext(), "Insert Done", Toast.LENGTH_LONG).show();
            }
        });

        //Update
        btnUpdate = findViewById(R.id.btnUpdate);
        etID = findViewById(R.id.etIDUpdate);
        etNameUpdate = findViewById(R.id.etNameUpdate);
        etQuantityUpdate = findViewById(R.id.etQuantityUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etID.getText().toString();
                String nameUpdate = etNameUpdate.getText().toString();
                String quantityUpdate = etQuantityUpdate.getText().toString();
                sqlHelper.updateProduct(id, nameUpdate, quantityUpdate);
            }
        });

        //Delete
        btnDelete = findViewById(R.id.btnDelete);
        btnDelAll = findViewById(R.id.btnDeleteAll);
        etIDDelete = findViewById(R.id.etIDDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etIDDelete.getText().toString();
                int iddelete = sqlHelper.deleteProduct(id);

                /*iddelete = 1 => xóa thành công
                iddelete = 0 => xóa thất bại*/
                Toast.makeText(getBaseContext(), "Delete : " + iddelete, Toast.LENGTH_LONG).show();
            }
        });

        btnDelAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sqlHelper.delAllProduct())
                    Toast.makeText(getBaseContext(), "Delete All Done ", Toast.LENGTH_LONG).show();
                else Toast.makeText(getBaseContext(), "Delete Fail", Toast.LENGTH_LONG).show();
            }
        });

        //View Product to list
        rvProduct = findViewById(R.id.rvListProduct);
        btnShow = findViewById(R.id.btnShowList);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productList = sqlHelper.getAllProductAdvanced();

                if (productList != null) {
                    adapterProduct = new AdapterProduct(productList, getBaseContext());
                    rvProduct.setAdapter(adapterProduct);

                    adapterProduct.setOnClickProduct(new onClickProduct() {
                        @Override
                        public void onClick(Product product) {
                            Toast.makeText(getBaseContext(), "Id : " + product.getId() + "\nName : " +
                                    product.getName() + "\nQuantity : " + product.getQuantity(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

    }
}
