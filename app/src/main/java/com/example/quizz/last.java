package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static com.example.quizz.page1.score;

import com.google.android.material.color.utilities.Score;
import com.google.firebase.auth.FirebaseAuth;

public class last extends AppCompatActivity {

    Button out;
    Button trg;
    TextView textView;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last);
        textView=findViewById(R.id.textView5);
        out=findViewById(R.id.button7);
        trg=findViewById(R.id.button6);
        auth=FirebaseAuth.getInstance();

        textView.setText(String.valueOf(score));
        out.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                auth.signOut();

                Toast toast=Toast.makeText(getApplicationContext(),"LogOut",Toast.LENGTH_LONG);
                toast.show();
                score=0;
                //redirection vers l'activité au quiz 1 (register)
                //objet intent;gerer la communication entre les activité
                Intent intent=new Intent(last.this,MainActivity.class);//byte code java
                startActivity(intent);


            }
        });


        trg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getApplicationContext(),"again",Toast.LENGTH_LONG);
                toast.show();
                score=0;
                //redirection vers l'activité au quiz 1 (register)
                //objet intent;gerer la communication entre les activité
                Intent intent1=new Intent(last.this,page1.class);//byte code java
                startActivity(intent1);
            }
        });
    }
}
