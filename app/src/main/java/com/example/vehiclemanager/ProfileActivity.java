package com.example.vehiclemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity  implements View.OnClickListener{
    TextView tvId,tvName,tvPass,tvTime;
    Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.profile_layout);
        getSupportActionBar().hide();
        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            tvId = findViewById(R.id.tvId);
            tvName = findViewById(R.id.tvName);
            tvPass = findViewById(R.id.tvPass);
            tvTime = findViewById(R.id.tvCreattime);
            btnLogout = findViewById(R.id.btnLogout);
            User user = SharedPrefManager.getInstance(this).getUser();
            tvId.setText(user.getId());
            tvName.setText(user.getUsername());
            tvPass.setText(user.getPassword());
            tvTime.setText(user.getCreateTime());
            btnLogout.setOnClickListener(this);
        }else{
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public void onClick(View view){
        if(view.equals(btnLogout)){
            SharedPrefManager.getInstance(getApplicationContext()).logout();
        }
    }
}
