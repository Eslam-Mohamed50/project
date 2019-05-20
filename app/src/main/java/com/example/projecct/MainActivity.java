package com.example.projecct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void loogin (View view)
        {
            Intent intent = new Intent(MainActivity.this, loooginrelative.class);
            startActivity(intent);

        }
        public void loogi (View view)
        {
            Intent intent = new Intent(MainActivity.this, loggin.class);
            startActivity(intent);

        }
        public void ss(View view)
        {
            Intent intent= new Intent(this,search.class);
            startActivity(intent);

        }

}
