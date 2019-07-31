package com.lexieluv.homeworkthirteenth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.System.exit;


public class LoginActivity extends AppCompatActivity {
    private EditText edt_name,edt_pass;
    private Button btn_login;
    private TextView tv_regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        //注册键
        tv_regist = findViewById(R.id.tv_regist);
        tv_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        //账号值返回
        edt_name = findViewById(R.id.edt_name);
        String name = getIntent().getStringExtra(RegisterActivity.INFO_NAME);
        final String pass = getIntent().getStringExtra(RegisterActivity.INFO_PASS);
        if(name != null && pass != null){
            edt_name.setText(name);
        }
        //判断密码是否正确
        edt_pass = findViewById(R.id.edt_pass);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass_2 = edt_pass.getText().toString();
                if(pass_2.equals(pass)){
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    LoginActivity.this.finish();
                    exit(0);
                } else{
                    Toast.makeText(LoginActivity.this,"密码错误！请重新输入！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
