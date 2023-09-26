package com.hamidul.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main3);

        textView = findViewById(R.id.textView);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

        String name = sharedPreferences.getString("name","Default");
        String email = sharedPreferences.getString("email","Default");
        int password = sharedPreferences.getInt("password",0);
        int nid = sharedPreferences.getInt("nid",0);
        int studentId = sharedPreferences.getInt("studentId",0);

        textView.append("Name : "+name+"\nEmail : "+email+"\nPassword : "+password+"\nNID : "+nid+"\nStudent ID : "+studentId);


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}