package com.hamidul.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText edName,edPassword,edEmail,edNID,edStudentID;
    Button button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean flag;
    TextInputLayout passLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edNID = findViewById(R.id.edNID);
        edStudentID = findViewById(R.id.edStudentID);
        button = findViewById(R.id.button);
        passLay = findViewById(R.id.passLay);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();

        flag = sharedPreferences.getBoolean("flag", false);

        if (flag) {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
            finish();
        }

        edPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String s1 = edPassword.getText().toString();
                if (s1.length()==4){
                    passLay.setError(null);
                    passLay.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edName.getText().toString().equals("")){
                    edName.setError("Please Enter Your Name");
                    edName.requestFocus();
                    return;
                }
                if (edEmail.getText().toString().equals("")){
                    edEmail.setError("Please Enter Your Email");
                    edEmail.requestFocus();
                    return;
                }
                if (edPassword.getText().toString().equals("")){
                    edPassword.setError("Enter Your Password");
                    edPassword.requestFocus();
                    return;
                }
                if (edNID.getText().toString().equals("")){
                    edNID.setError("Enter Your NID Number");
                    edNID.requestFocus();
                    return;
                }
                if (edStudentID.getText().toString().equals("")){
                    edStudentID.setError("Enter Your Student ID");
                    edStudentID.requestFocus();
                    return;
                }
                if (edPassword.length()<4){
                    passLay.setError("Set 4-digit PIN");
                    edPassword.requestFocus();
                    return;
                }
                String sName = edName.getText().toString();
                String sEmail = edEmail.getText().toString().trim();
                int iPassword = Integer.parseInt(edPassword.getText().toString());
                int iNID = Integer.parseInt(edNID.getText().toString());
                int iStudentID = Integer.parseInt(edStudentID.getText().toString());

                editor.putString("name",""+sName);
                editor.putString("email",""+sEmail);
                editor.putInt("password",iPassword);
                editor.putInt("nid",iNID);
                editor.putInt("studentId",iStudentID);
                editor.putBoolean("flag", true);
                editor.apply();

                startActivity(new Intent(MainActivity.this, MainActivity3.class));

            }
        });

    }
}