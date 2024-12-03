package com.example.xunlianyingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private Button goToRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        setupListeners();
    }

    private void initViews() {
        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        goToRegisterButton = findViewById(R.id.goToRegisterButton);
    }

    private void setupListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                
                if(validateLogin(username, password)) {
                    handleLoginSuccess(username);
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

        goToRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        // TODO: 实现实际的登录验证逻辑
        return !username.isEmpty() && !password.isEmpty();
    }

    private void handleLoginSuccess(String username) {
        // 这里模拟获取用户信息，实际应用中应该从服务器获取
        String email = "user@example.com"; // 示例数据
        String phone = "13800138000";      // 示例数据

        Intent intent = new Intent(LoginActivity.this, UserInfoActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);
        startActivity(intent);
        finish();
    }
} 