package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class page1 extends AppCompatActivity {
    Button next;
    RadioButton correct;
    RadioButton wrong;
    public static int score=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);
        /*
        Cette méthode indique à l'activité d'utiliser le layout XML spécifié
         */
        next=findViewById(R.id.button);

        wrong=findViewById(R.id.non);
        correct=findViewById(R.id.oui);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correct.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Reponse Vrai", Toast.LENGTH_LONG);
                    toast.show();
                    score=score+1;
                    //redirection vers l'activité au quiz 1 (register)
                    //objet intent;gerer la communication entre les activité
                    Intent intent = new Intent(page1.this, page2.class);//byte code java
                   intent.putExtra("score",score);
                    startActivity(intent);
                }
                else if(wrong.isChecked()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Faux reponse", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent(page1.this, page2.class);//byte code java
                    startActivity(intent);
                }
            }
        });
    }
}