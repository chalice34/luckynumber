package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class secondact extends AppCompatActivity {

    TextView txt;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondact);

        txt=findViewById(R.id.textView3);
        btn1=findViewById(R.id.button2);

        Intent i=getIntent();
        String username=i.getStringExtra("name");

        int randno=genre();
        txt.setText(""+randno);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedata(username,randno);
            }
        });

    }

    public int genre(){
        Random rand = new Random();
        int limit=100;
        return rand.nextInt(limit);

    }
    public void sharedata(String u,int randno){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,u+" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"My lucky number is: "+randno);
        startActivity(Intent.createChooser(i,"Choose a platform to share"));
        
    }
}