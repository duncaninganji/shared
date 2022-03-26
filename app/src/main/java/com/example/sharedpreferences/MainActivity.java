package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = MainActivity.this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void onSaveUserInfo(View view) {
        TextView nameView = findViewById(R.id.nameInput);
        editor.putString("name", nameView.getText().toString());
        TextView emailView =  findViewById(R.id.emailInput);
        editor.putString("email", emailView.getText().toString());
        editor.commit();
    }

    public void onRetrieveUserInfo(View view) {
        String name = sharedPreferences.getString("name", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String res = "NAME: " + name + "\nEMAIL: " + email;
        TextView userInfoView = findViewById(R.id.userInfoView);
        userInfoView.setText(res);
    }
}