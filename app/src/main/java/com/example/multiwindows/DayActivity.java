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

public class DayActivity extends AppCompatActivity {
    Button backButton, eveningButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_day);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MyPushNotification myPushNotification = new MyPushNotification(this,
                getSystemService(NotificationManager.class));
        myPushNotification.sendNotify("Уведомление","Скоро конец рабочего дня!", R.drawable.day);

        backButton = findViewById(R.id.BackButton);
        eveningButton = findViewById(R.id.EveningButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        eveningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayActivity.this, EveningActivity.class);
                startActivity(intent);
            }
        });
    }
}