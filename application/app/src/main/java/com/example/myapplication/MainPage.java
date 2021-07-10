package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainPage extends AppCompatActivity {

    private Button btTest;
    private Button btLogOut;
    private Button btProfile;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Hellonadsfbakdbfl");

        btTest = findViewById(R.id.btTest);
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchTestPage();
            }
        });

        btLogOut = findViewById(R.id.btLogOut);
        btLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance()
                        .signOut(getApplicationContext())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                launchAuthPage();
                            }
                        });
            }
        });

        btProfile = findViewById(R.id.btProfile);
        btProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchProfilePage();
            }
        });
    }

    private void launchTestPage() {
        Intent intent = new Intent(MainPage.this, TestPage.class);
        startActivity(intent);
    }

    private void launchAuthPage() {
        Intent intent = new Intent(MainPage.this, AuthPage.class);
        startActivity(intent);
    }

    private void launchProfilePage() {
        Intent intent = new Intent(MainPage.this, ProfilePage.class);
        startActivity(intent);
    }
}