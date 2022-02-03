package com.example.login_interiew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText emailId, password_login, cpassword, contact_no;
    Button login;
    FirebaseAuth auth;
    boolean isEmailValid, isPasswordValid,isPhoneValid;
    TextView not;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.person_email_id_sign_in);
        password_login = findViewById(R.id.person_password_sign_in);
        cpassword = findViewById(R.id.person_password_confirm_password);
        contact_no =  findViewById(R.id.person_mobile_no);
        login = findViewById(R.id.login_successful_to_homepage);
        



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SetValidation();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString().trim();
                String password = password_login.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(), "enter email password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<8){
                    Toast.makeText(getApplicationContext(), "password to short, " +"enter minimum eight character!", Toast.LENGTH_SHORT).show();
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
                                    startActivity(new Intent(MainActivity.this, Login.class));
                                    finish();
                                }
                            }
                        });

            }
        });



    }

    private void SetValidation() {


        // Check for a valid email address.
        if (emailId.getText().toString().isEmpty()) {
            emailId.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailId.getText().toString()).matches()) {
            emailId.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
        }

        // Check for a valid phone number.
        if (contact_no.getText().toString().isEmpty()) {
            contact_no.setError(getResources().getString(R.string.phone_error));
            isPhoneValid = false;
        } else  {
            isPhoneValid = true;
        }

        // Check for a valid password.
        if (password_login.getText().toString().isEmpty()) {
            password_login.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (password_login.getText().length() < 6) {
            password_login.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if ( isEmailValid && isPhoneValid && isPasswordValid) {
            Intent i = new Intent(getApplicationContext(),Login.class);
            startActivity(i);
            finish();
        }


    }
}