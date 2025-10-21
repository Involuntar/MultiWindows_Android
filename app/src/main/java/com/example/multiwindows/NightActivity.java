package com.example.multiwindows;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NightActivity extends AppCompatActivity {
    Button pollButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_night);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pollButton = findViewById(R.id.PollButton);
        pollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(NightActivity.this)
                        .setIcon(R.drawable.night)
                        .setTitle("Вопрос")
                        .setMessage("Спишь?")
                        .setPositiveButton("Да", ((dialog, which) -> {
                            System.exit(0);
                        }))
                        .setNegativeButton("Нет", ((dialog, which) -> {
                            Intent intent = new Intent(NightActivity.this, MainActivity.class);
                            startActivity(intent);
                        }))
                        .show();
            }
        });
    }
}