package com.example.admin.albumsviewer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;

    Toolbar toolbar;
    EditText input_email;
    EditText input_password;
    Button button_login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Biblioteka muzyczna");
        setSupportActionBar(toolbar);

        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        button_login = (Button) findViewById(R.id.button_login);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                // uzytkownik jest zalogowany i przekierowujemy na drugie activity
                if (firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(MainActivity.this, AlbumsList.class));
                }
            }
        };

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Button dziala", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), input_email.getText().toString(), Toast.LENGTH_LONG).show();
                button_login.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                signIn();
                // mechanizm logowania
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        auth.addAuthStateListener(authStateListener);
    }

    public void signIn(){
        String email = input_email.getText().toString();
        String password = input_password.getText().toString();

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Podano nieprawidłowe dane logowania!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                    button_login.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logout,menu);

        return true;
    }

}
