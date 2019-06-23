package com.vpbank.sqlitesimple.webapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vpbank.sqlitesimple.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebAPISimple extends AppCompatActivity {
    TextView tvResult, tvResultArray;
    String result = "";
    String json = "{ \"id\" : 1, \"name\" : \"Coca\", \"quantity\" : 32}";
    String jsonArray = "[ { \"id\" : 1, \"name\" : \"Coca\", \"quantity\" : 15}, { \"id\" : 2, \"name\" : \"Pepsi\", \"quantity\" : 32}, { \"id\" : 3, \"name\" : \"Sting\", \"quantity\" : 45}, { \"id\" : 4, \"name\" : \"Lavie\", \"quantity\" : 86} ]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_apisimple);

        //bóc dữ liệu từ Json
        tvResult = findViewById(R.id.tvResult);
        try {
            JSONObject jProduct = new JSONObject(json);
            String id = jProduct.getString("id");
            String name = jProduct.getString("name");
            String quantity = jProduct.getString("quantity");

            tvResult.setText("Id : " + id + "\nName : " + name + "\nQuantity: " + quantity);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Bóc dữ liệu từ JsonArray
        tvResultArray = findViewById(R.id.tvResultArray);
        try {
            JSONArray jArrayProduct = new JSONArray(jsonArray);
            int length = jArrayProduct.length();
            for (int i = 0; i < length; i++) {
                JSONObject jsonObject = jArrayProduct.getJSONObject(i);

                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String quantity = jsonObject.getString("quantity");

                result += "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + "\n";
            }

            tvResultArray.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
