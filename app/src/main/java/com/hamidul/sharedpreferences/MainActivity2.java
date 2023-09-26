package com.hamidul.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText edEmail,edPassword;
    Button login;
    TextInputLayout passLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main2);

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        login = findViewById(R.id.login);
        passLay = findViewById(R.id.passLay);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

        String name = sharedPreferences.getString("name","Default");
        String email = sharedPreferences.getString("email","Default");
        int password = sharedPreferences.getInt("password",1234);

        Toast.makeText(this, "Welcome "+name, Toast.LENGTH_SHORT).show();

        edEmail.addTextChangedListener(watcher);
        edPassword.addTextChangedListener(watcher);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edEmail.getText().toString().equals("")){
                    edEmail.setError("Enter Your Email");
                    edEmail.requestFocus();
                    return;
                }
                if (edPassword.getText().toString().equals("")){
                    edPassword.setError("Enter Your Password");
                    edPassword.requestFocus();
                    return;
                }
                String myEmail = edEmail.getText().toString().trim();
                int myPassword = Integer.parseInt(edPassword.getText().toString());

                if (myEmail.equals(""+email) && myPassword==password){
                    startActivity(new Intent(MainActivity2.this,MainActivity3.class));
                }else if (!myEmail.equals(""+email)){
                    Toast.makeText(MainActivity2.this, "Incorrect Email Address", Toast.LENGTH_SHORT).show();
                }else if (myPassword!=password){
                    Toast.makeText(MainActivity2.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String email = edEmail.getText().toString();
            String password = edPassword.getText().toString();

            if (password.length()==0){
                passLay.setHelperText(" ");
            }else if (password.length()<4){
                passLay.setHelperText("Enter 4-digit PIN");
            }else if (password.length()==4){
                passLay.setHelperText(" ");
            }

            login.setEnabled(!email.isEmpty() && password.length()==4);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}