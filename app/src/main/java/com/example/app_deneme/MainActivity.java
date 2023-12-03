package com.example.app_deneme;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   TextView no;
   TextView name;
   Button convertor;
   Button rndGenerator;
   Button sms;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        no = findViewById(R.id.no);
        name = findViewById(R.id.name);
        convertor = findViewById(R.id.convertor);
        rndGenerator = findViewById(R.id.rnd_generator);
        sms = findViewById(R.id.sms);

        startAnimation();
        
        convertor.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,Convertor.class);
            startActivity(i);
        });
        rndGenerator.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,Rnd_generator.class);
            startActivity(i);
        });
        sms.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,Sms.class);
            startActivity(i);
        });
    }

    public void startAnimation(){
        animateView(no);
        animateView(name);
        animateView(convertor);
        animateView(rndGenerator);
        animateView(sms);
    }
    public void animateView(View view){
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(view,"alpha",0f,1f);
        fadeIn.setDuration(3500);
        fadeIn.setInterpolator(new AccelerateInterpolator());

        fadeIn.start();
    }

}