package com.example.xunlianyingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {
    private TextView usernameTv;
    private TextView emailTv;
    private TextView phoneTv;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initViews();
        displayUserInfo();
        setupLogoutButton();
    }

    private void initViews() {
        usernameTv = findViewById(R.id.usernameTv);
        emailTv = findViewById(R.id.emailTv);
        phoneTv = findViewById(R.id.phoneTv);
        logoutButton = findViewById(R.id.logoutButton);
    }

    private void displayUserInfo() {
        // 从Intent中获取用户信息
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        // 显示用户信息
        usernameTv.setText(username);
        emailTv.setText(email);
        phoneTv.setText(phone);
    }

    private void setupLogoutButton() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回登录页面
                Intent intent = new Intent(UserInfoActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
} 