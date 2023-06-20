package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.activity.LietKeActivity;
import com.example.myapplication.activity.ThemLopActivity;
import com.example.myapplication.activity.ThemSinhVienActivity;
import com.example.myapplication.activity.ThemSinhVienVaoLopActivity;
import com.example.myapplication.activity.ThongKeActivity;

public class Main extends AppCompatActivity {
   private Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        b1 = findViewById(R.id.tsv);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, ThemSinhVienActivity.class);
                startActivity(intent);
            }
        });
        b2 = findViewById(R.id.tl);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, ThemLopActivity.class);
                startActivity(intent);
            }
        });
        b3 = findViewById(R.id.sv_l);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, ThemSinhVienVaoLopActivity.class);
                startActivity(intent);
            }
        });
        b4 = findViewById(R.id.lk);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, LietKeActivity.class);
                startActivity(intent);
            }
        });
        b5 = findViewById(R.id.tk);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this, ThongKeActivity.class);
                startActivity(intent);
            }
        });
    }
}
