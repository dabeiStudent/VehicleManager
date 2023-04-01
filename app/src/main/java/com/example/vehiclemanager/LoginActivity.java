package com.example.vehiclemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etName,etPassword;
    private Button btnLogin,btnProfile;
    private TextView txtV,txtReg;
    APIService mapiService;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        getSupportActionBar().hide();
        etName=findViewById(R.id.etName);
        etPassword=findViewById(R.id.etPass);
        txtV=findViewById(R.id.textView);
        btnProfile= findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(view -> profile());
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> login());
        txtReg=findViewById(R.id.tvRegister);
        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void profile(){
        mapiService=RetrofitClient.getRetrofit().create(APIService.class);
        Call<User> call = mapiService.getprofile();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                txtV.setText(response.body().getPassword());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                txtV.setText(t.getMessage());
            }
        });
    }
    private void login(){
        String userName = etName.getText().toString().trim();
        String passWord = etPassword.getText().toString().trim();
        mapiService=RetrofitClient.getRetrofit().create(APIService.class);
        Call<User> call = mapiService.login(userName,passWord);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Tai khoan hoac mat khau khong dung", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Khong the lay API",Toast.LENGTH_LONG).show();
            }
        });
    }

}
