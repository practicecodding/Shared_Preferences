package com.hamidul.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    TextView tName,tEmail,tPassword,tNID,tStudentId;
    SharedPreferences sharedPreferences;
    ClipboardManager cm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main3);

        tName = findViewById(R.id.tName);
        tEmail = findViewById(R.id.tEmail);
        tPassword = findViewById(R.id.tPassword);
        tNID = findViewById(R.id.tNID);
        tStudentId = findViewById(R.id.tStudentId);
        cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

        String name = sharedPreferences.getString("name","Default");
        String email = sharedPreferences.getString("email","Default");
        int password = sharedPreferences.getInt("password",0);
        int nid = sharedPreferences.getInt("nid",0);
        int studentId = sharedPreferences.getInt("studentId",0);

        tName.setText("Name : "+name);
        tName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setText(name);
                Toast.makeText(MainActivity3.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        tEmail.setText("Email : "+email);
        tEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setText(email);
                Toast.makeText(MainActivity3.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        tPassword.setText("Password : "+password);
        tPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setText(""+password);
                Toast.makeText(MainActivity3.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        tNID.setText("NID : "+nid);
        tNID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setText(""+nid);
                Toast.makeText(MainActivity3.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        tStudentId.setText("Student ID : "+studentId);
        tStudentId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cm.setText(""+studentId);
                Toast.makeText(MainActivity3.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}