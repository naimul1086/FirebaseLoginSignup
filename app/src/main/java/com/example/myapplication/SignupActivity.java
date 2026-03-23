package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
   MaterialButton signup;
   TextInputEditText email,password;
   FirebaseAuth auth;
   TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        auth = FirebaseAuth.getInstance();
        login = findViewById(R.id.loginSwitch);
        signup = findViewById(R.id.signupButton);
        email = findViewById(R.id.emailaddress);
        password = findViewById(R.id.passwordinput);

        signup.setOnClickListener(view -> {
            signupUsingFirebase();
        });
        login.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

    }

    private void signupUsingFirebase() {
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        if (TextUtils.isEmpty(emailText)){
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordText)){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passwordText.length()<6) {
            Toast.makeText(this, "Password length should be greater than 6", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show();
                Log.d("FIREBASE","Signup Successful");
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show();
                Log.d("ERROR FROM FIREBASE",task.getException().getMessage());
            }
        });


    }
}