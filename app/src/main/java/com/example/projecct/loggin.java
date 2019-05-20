package com.example.projecct;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.NestedScrollView;
import android.text.Spanned;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loggin extends AppCompatActivity {
    private EditText Email,TextPassword;
    private String email,password;
    private Button Login;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);
        Email = (EditText)findViewById(R.id.Email);
        firebaseAuth = FirebaseAuth.getInstance();
        TextPassword = (EditText)findViewById(R.id.Password);
        Login = (Button)findViewById(R.id.Looogin);
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
        else{
        firebaseAuth.signInWithEmailAndPassword(Email.getText().toString(),TextPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful())
            {  Toast.makeText(loggin.this,"log Successful",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(loggin.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
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

    public void loggg(View view)
    {
        Intent intent = new Intent(this,registerold.class);
        startActivity(intent);
    }

}