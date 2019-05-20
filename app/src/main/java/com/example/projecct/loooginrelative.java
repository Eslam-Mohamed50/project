package com.example.projecct;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loooginrelative extends AppCompatActivity {
    private EditText Email,TextPassword;
    private String email,password;
    private Button Login;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loooginrelative);
        Email = (EditText)findViewById(R.id.Email);
        TextPassword = (EditText)findViewById(R.id.TextPassword);
        Login = (Button)findViewById(R.id.Login);
        firebaseAuth = FirebaseAuth.getInstance();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser !=null)
        {
            Intent intent = new Intent(this,search.class);
            startActivity(intent);
        }
    }
    public void register()
    { inilize();
        if(!validate())
        {
            Toast.makeText(this,"فشل التسجيل",Toast.LENGTH_LONG).show();
        }
        else {
            firebaseAuth.signInWithEmailAndPassword(Email.getText().toString(),TextPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {  Toast.makeText(loooginrelative.this,"log Successful",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(loooginrelative.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
    public   boolean validate()
    {boolean valid = true;
        if (password.isEmpty())
        {
            TextPassword.setError("برجاء ادخال الرقم السرى");
            valid = false;
        }
        if (email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Email.setError("الاميل غير صحيح");
            valid= false;
        }
        return valid;
    }
    public void inilize()
    {
        email = Email.getText().toString().trim();
        password = TextPassword.getText().toString().trim();
    }
    public void logg(View view)
    {
        Intent intent = new Intent(this,registerreltive.class);
        startActivity(intent);
    }
}
