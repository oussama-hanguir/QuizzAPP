package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.quizz.page1.score;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class page2 extends AppCompatActivity {
    Button next;
    RadioButton correct;
    RadioButton wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);
        next=findViewById(R.id.button2);

        wrong=findViewById(R.id.non);
        correct=findViewById(R.id.oui);
        Intent i = getIntent();
         int S = i.getIntExtra("score",0);
        Toast t = Toast.makeText(getApplicationContext(), String.valueOf(S), Toast.LENGTH_LONG);
        t.show();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correct.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Reponse Vrai", Toast.LENGTH_LONG);
                    toast.show();
                    score=score+1;
                    //redirection vers l'activité au quiz 1 (register)
                    //objet intent;gerer la communication entre les activité
                    Intent intent = new Intent(page2.this, page3.class);//byte code java
                    startActivity(intent);
                }
                else if(wrong.isChecked()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Faux reponse", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent(page2.this, page3.class);//byte code java
                    startActivity(intent);
                }
            }
        });
    }
}