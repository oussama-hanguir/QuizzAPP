package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class register extends AppCompatActivity {
    Button register;
    EditText email,password,password_c;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        register=findViewById(R.id.register_button);
        email=findViewById(R.id.register_email);
        password=findViewById(R.id.register_password1);
        password_c=findViewById(R.id.register_password2);
        auth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail,Password,Password_c;
                mail=email.getText().toString();
                Password=password.getText().toString();
                Password_c=password_c.getText().toString();
                if(Password.equals(Password_c)) {

                    auth.createUserWithEmailAndPassword(mail, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            /*
                        OnCompleteListener<AuthResult>, qui définit la logique à exécuter une fois que l'opération est complétée
                         C'est la méthode onComplete() de l'interface OnCompleteListener<AuthResult>,
                         qui est appelée lorsque l'opération d'authentification est complétée, avec le résultat de
                         l'opération encapsulé dans l'objet Task<AuthResult> task
                         */
                            if (task.isSuccessful()) {
                                Toast.makeText(register.this, "Account Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, MainActivity.class));
                            } else {
                                Toast.makeText(register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(register.this, "Password Confirmation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}