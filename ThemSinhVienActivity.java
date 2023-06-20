package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.SinhVien;

public class ThemSinhVienActivity extends AppCompatActivity {
    private TextView ten,que,nh,ns;
    Button btn_t,btn_s;
    DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_sv);
        db = new DatabaseHelper(this);

        ten = findViewById(R.id.ten);
        que = findViewById(R.id.que);
        nh = findViewById(R.id.namHoc);
        ns = findViewById(R.id.namSinh);
        btn_t = findViewById(R.id.btn_sv);
        btn_s = findViewById(R.id.btn_show);

        btn_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSinhVien(new SinhVien(0,ten.getText().toString(),que.getText().toString(),ns.getText().toString(),nh.getText().toString()));
                Toast.makeText(ThemSinhVienActivity.this,"Them Thanh Cong",Toast.LENGTH_SHORT).show();
            }
        });
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemSinhVienActivity.this, ShowSinhVienActivity.class);
                startActivity(intent);
            }
        });


    }
}
