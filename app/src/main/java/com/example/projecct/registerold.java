package com.example.projecct;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.GregorianCalendar;
import java.util.regex.Pattern;
public class registerold extends AppCompatActivity {
    private EditText Name,Email,Password,phoneolder,phonerelative;
    private RadioGroup mgender;
    private Button Register;
    private Toolbar toolbar;
    private RadioButton radioMale,radioFemale;
    private DatabaseReference mdatabase;
    FirebaseAuth firebaseAuth;
    //private ProgressBar progressBar;
    private String name,email,pasword,Phoneolder,Phonerelative;
    private String gender = "";
    private ProgressBar progressBar;
    private boolean x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_registerold);
        firebaseAuth = FirebaseAuth.getInstance();
        mdatabase= FirebaseDatabase.getInstance().getReference().child("registerold");
        Name = (EditText)findViewById(R.id.Name);
        Email = (EditText) findViewById(R.id.Email);
        phoneolder=(EditText)findViewById(R.id.phone_older);
        phonerelative=(EditText)findViewById(R.id.phone_relative);
        Password = (EditText)findViewById(R.id.Password);
        mgender = (RadioGroup)findViewById(R.id.Gender);
        Register = (Button)findViewById(R.id.Register);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        //toolbar.setTitle(R.string.app_name);
        mgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioMale:
                        gender = "male";
                        break;
                    case R.id.radioFemale:
                        gender = "female";
                        break;
                    }
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();

            }
        });
    }

    public void register() {
        //progressBar.setVisibility(View.VISIBLE);
        inilize();
        if (!validate()) {
            Toast.makeText(this, "فشل التسجيل", Toast.LENGTH_LONG).show();
        }
        else
        { firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   // progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful())
                    { Toast.makeText(registerold.this,"Register sussfull",Toast.LENGTH_SHORT).show();
                        String user_id = firebaseAuth.getCurrentUser().getUid();
                        DatabaseReference current_userid = mdatabase.child(user_id);
                        current_userid.child("Name").setValue(name);
                        current_userid.child("genger").setValue(gender);
                        current_userid.child("Phone older").setValue(Phoneolder);
                        current_userid.child("Phone relative").setValue(Phonerelative);
                        Email.setText("");
                        Password.setText("");
                        Name.setText("");
                        phoneolder.setText("");
                        phonerelative.setText("");
                        Intent intent = new Intent(getApplicationContext(),loggin.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(registerold.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }


    }
  public   boolean validate()
  {boolean valid = true;
if(name.isEmpty()||name.length()>15)
{
    Name.setError("برجاء ادخال الاسم");
    valid  = false;
}
if (email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches())
{
Email.setError("الاميل غير صحيح");
valid= false;
}
if (pasword.isEmpty())
{
    Password.setError("برجاء ادخال الرقم السرى");
    valid = false;
}
if (Phoneolder.isEmpty())
{
    phoneolder.setError("برجاء ادخال رقم تلفون older");
    valid = false;
}
if (Phonerelative.isEmpty())
{   phonerelative.setError("برجاء ادخال رقم تلفون relative");
    valid = false; }
    if (gender.isEmpty())
    {
        valid = false;
    }
return valid;  }
    public void inilize()
    {
name = Name.getText().toString();
pasword= Password.getText().toString();
email= Email.getText().toString();
Phoneolder=phoneolder.getText().toString();
Phonerelative=phonerelative.getText().toString();
    }
    public void loooo(View view)
    {
        Intent intent = new Intent(this,loggin.class);
        startActivity(intent);
    }


}
