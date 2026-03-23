package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends AppCompatActivity {
   TextInputEditText loginemail,loginpassword;
   MaterialButton loginButton;
   TextView signup;
   FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loginemail = findViewById(R.id.loginemail);
        loginpassword = findViewById(R.id.loginpassword);
        loginButton = findViewById(R.id.loginButton);
        signup = findViewById(R.id.signupSwitch);
        signup.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        });
        auth = FirebaseAuth.getInstance();
        loginButton.setOnClickListener(view -> {
            loginUsingFirebase();
        });

    }

    private void loginUsingFirebase() {
        String emailText = loginemail.getText().toString();
        String passwordText = loginpassword.getText().toString();
        auth.signInWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                Log.d("FIREBASE","Login Successful");
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
            else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
                Log.d("ERROR FROM FIREBASE",task.getException().getMessage());
            }
        });
    }
}
