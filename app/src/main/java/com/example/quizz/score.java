package com.example.quizz;

import static com.example.quizz.page1.score;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class score extends AppCompatActivity {

    Button signout;
    Button restart;
    TextView textView;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        textView=findViewById(R.id.textView5);
        signout=findViewById(R.id.button7);
        restart=findViewById(R.id.button6);
        auth=FirebaseAuth.getInstance();

        textView.setText(String.valueOf(score));
        signout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                auth.signOut();

                Toast toast=Toast.makeText(getApplicationContext(),"LogOut",Toast.LENGTH_LONG);
                toast.show();
                score=0;
                //redirection vers l'activité au quiz 1 (register)
                //objet intent gerer la communication entre les activité
                Intent intent2=new Intent(score.this,MainActivity.class);//byte code java
                startActivity(intent2);


            }
        });


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getApplicationContext(),"again",Toast.LENGTH_LONG);
                toast.show();
                score=0;
                //redirection vers l'activité au quiz 1 (register)
                //objet intent;gerer la communication entre les activité
                Intent intent1=new Intent(score.this,page1.class);//byte code java
                startActivity(intent1);
            }
        });
    }
}
