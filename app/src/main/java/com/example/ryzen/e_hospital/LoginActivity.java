package com.example.ryzen.e_hospital;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ProgressBar progressBarLogin;
    EditText Userpassword;
    EditText Useremail;
    Button userLogin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLogin = findViewById(R.id.login_btn);
        Useremail = findViewById(R.id.email_txt_box);
        Userpassword = findViewById(R.id.password_txt_box);
        progressBarLogin = findViewById(R.id.progress_bar_login);
        firebaseAuth = FirebaseAuth.getInstance();


    }

    public void login(View view) {
        progressBarLogin.setVisibility(View.VISIBLE);
        firebaseAuth.signInWithEmailAndPassword(Useremail.getText().toString(),
                Userpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBarLogin.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    startActivity(new Intent (LoginActivity.this,MainActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this, task.getException().getMessage()
                    ,Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void signup(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
