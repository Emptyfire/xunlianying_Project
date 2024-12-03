package com.example.xunlianyingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText usernameEdit;
    private EditText passwordEdit;
    private EditText emailEdit;
    private EditText phoneEdit;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 初始化视图
        initViews();
        
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()) {
                    // 执行注册操作
                    performRegister();
                }
            }
        });
    }

    private void initViews() {
        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);
        emailEdit = findViewById(R.id.email);
        phoneEdit = findViewById(R.id.phone);
        registerButton = findViewById(R.id.registerButton);
    }

    private boolean validateInput() {
        String username = usernameEdit.getText().toString().trim();
        String password = passwordEdit.getText().toString().trim();
        String email = emailEdit.getText().toString().trim();
        String phone = phoneEdit.getText().toString().trim();

        if(username.isEmpty()) {
            showToast("请输入用户名");
            return false;
        }
        if(password.isEmpty()) {
            showToast("请输入密码");
            return false;
        }
        if(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("请输入有效的邮箱地址");
            return false;
        }
        if(phone.isEmpty() || phone.length() != 11) {
            showToast("请输入有效的手机号");
            return false;
        }
        return true;
    }

    private void performRegister() {
        String username = usernameEdit.getText().toString().trim();
        String password = passwordEdit.getText().toString().trim();
        String email = emailEdit.getText().toString().trim();
        String phone = phoneEdit.getText().toString().trim();

        // 注册成功后直接跳转到用户信息页面
        Intent intent = new Intent(RegisterActivity.this, UserInfoActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);
        startActivity(intent);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
} 