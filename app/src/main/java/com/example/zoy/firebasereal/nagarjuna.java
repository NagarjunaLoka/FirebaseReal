package com.example.zoy.firebasereal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class nagarjuna extends AppCompatActivity {

    String nagarjuna;
    TextView nag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagarjuna);
        nag=findViewById(R.id.nag);


        nagarjuna=getIntent().getStringExtra("empid");
        nag.setText(nagarjuna);

        nag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(com.example.zoy.firebasereal.nagarjuna.this,my_activity.class);
                startActivity(i);
            }
        });
    }
}
