package com.example.projecct;
import android.support.annotation.NonNull;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import static android.view.View.VISIBLE;

public class registerreltive extends AppCompatActivity {
    private EditText Name,Email,Password,phone_rel;
    private RadioGroup Gender;
    private RadioButton radioMale,radioFemale;
    private Button Register;
    FirebaseAuth firebaseAuth;
    private DatabaseReference mdatabase;
    private String name,email,pasword,nameolder,Phone_rel;
    private RadioGroup mgender;
    private String gender = "";
    private ProgressBar progressBar;
    private boolean z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar =findViewById(R.id.progressbar);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_registerreltive);
        firebaseAuth = FirebaseAuth.getInstance();
        Name = (EditText)findViewById(R.id.Name);
        mdatabase= FirebaseDatabase.getInstance().getReference().child("registerrelative");
        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText)findViewById(R.id.Password);
        phone_rel =(EditText)findViewById(R.id.phone_rel);
        //Gender = (RadioGroup)findViewById(R.id.Gender);
        mgender = (RadioGroup)findViewById(R.id.Gender);
        radioFemale = (RadioButton)findViewById(R.id.radioFemale);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        Register = (Button)findViewById(R.id.Register);
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
                //progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
    public void register()
    { inilize();
        if(!validate())
        {
            Toast.makeText(this,"فشل التسجيل",Toast.LENGTH_LONG).show();
        }
        else
        {
            firebaseAuth.createUserWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   // progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful())
                    {
                        Toast.makeText(registerreltive.this,"Register sussfull",Toast.LENGTH_SHORT).show();
                        String user_id = firebaseAuth.getCurrentUser().getUid();
                        DatabaseReference current_userid = mdatabase.child(user_id);
                        current_userid.child("Name").setValue(name);
                        current_userid.child("Phone relative").setValue(Phone_rel);
                        current_userid.child("Gender").setValue(gender);
                        Email.setText("");
                        Password.setText("");
                        Name.setText("");
                        phone_rel.setText("");
                        mgender.clearCheck();
                        Intent intent = new Intent(getApplicationContext(),loooginrelative.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(registerreltive.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        z=false;
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
        if (Phone_rel.isEmpty())
        {
            phone_rel.setError("برجاء ادخال رقم تلفون relative");
            valid = false;
        }
        return valid;  }
    public void inilize()
    {
        name = Name.getText().toString();
        pasword= Password.getText().toString();
        email= Email.getText().toString();
       Phone_rel = phone_rel.getText().toString();
    }
    public void looo(View view)
    {
        Intent intent = new Intent(this,loooginrelative.class);
        startActivity(intent);
    }
}