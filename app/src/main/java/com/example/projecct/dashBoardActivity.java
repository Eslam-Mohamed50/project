package com.example.projecct;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class dashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        CardView alarmCard = (CardView)findViewById(R.id.alarm);
        CardView medListCard = (CardView)findViewById(R.id.medicinesList);


        alarmCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashBoardActivity.this, alarm.class);
                startActivity(intent);
            }
        });

        medListCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashBoardActivity.this, medicines.class);
                startActivity(intent);
            }
        });

    }














}