package com.lexieluv.homeworkthirteenth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {
    private EditText edt_username,edt_password;
    private Button btn_regst;
    public static final String INFO_NAME = "INFO_NAME";
    public static final String INFO_PASS = "INFO_PASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_password);

        btn_regst = findViewById(R.id.btn_regst);
        btn_regst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                String name = edt_username.getText().toString();
                String pass = edt_password.getText().toString();
                intent.putExtra(INFO_NAME,name);
                intent.putExtra(INFO_PASS,pass);
                startActivity(intent);
                RegisterActivity.this.finish();
            }
        });
    }
}
