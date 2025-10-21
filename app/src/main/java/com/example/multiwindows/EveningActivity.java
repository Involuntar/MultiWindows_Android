package com.example.multiwindows;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EveningActivity extends AppCompatActivity {
    Button backButton, nightButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_evening);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MyPushNotification myPushNotification = new MyPushNotification(this,
                getSystemService(NotificationManager.class));
        myPushNotification.sendNotify("СПАТЬ!!!", "БЫСТРО СПАТЬ!!!", R.drawable.evening);

        backButton = findViewById(R.id.BackButton);
        nightButton = findViewById(R.id.NightButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EveningActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        nightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EveningActivity.this, NightActivity.class);
                startActivity(intent);
            }
        });
    }
}