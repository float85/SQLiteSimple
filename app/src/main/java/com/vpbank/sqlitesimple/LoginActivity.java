package com.vpbank.sqlitesimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateLogin()) {
                    Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean validateLogin() {
        if (TextUtils.isEmpty(etPass.getText().toString())) {
            etPass.setError(getResources().getString(R.string.app_name));
            etPass.requestFocus();
            return false;
        }

        return true;
    }
}
