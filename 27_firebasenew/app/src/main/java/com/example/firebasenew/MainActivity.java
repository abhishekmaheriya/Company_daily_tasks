package com.example.firebasenew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText1, editText2;
    Button button;
    FirebaseAuth auth;
    boolean isEmailValid, isPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.login);
        editText1 = findViewById(R.id.email);
        editText2 = findViewById(R.id.password);
        button = findViewById(R.id.btnlogin);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editText1.getText().toString().trim();
                String password = editText2.getText().toString().trim();



                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "enter email password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<6){
                    Toast.makeText(getApplicationContext(), "password to short, " +"enter minimum six character!", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(MainActivity.this, "createUserWithEmail:on complete:\""+
                                        "+ task.isSuccessful(),", Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Authentication Faild"+task.getException(), Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    startActivity(new Intent(MainActivity.this, login.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}