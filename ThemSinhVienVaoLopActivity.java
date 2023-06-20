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
import com.example.myapplication.model.SinhVienLop;

public class ThemSinhVienVaoLopActivity extends AppCompatActivity {

    private TextView msv,ml,kh,stc,nl;
    Button btn_t,btn_s;
    DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sv_l);
        db = new DatabaseHelper(this);

        msv = findViewById(R.id.msv);
        ml = findViewById(R.id.ml);
        kh = findViewById(R.id.kihoc);
        stc = findViewById(R.id.stc);
        nl = findViewById(R.id.nl);
        btn_t = findViewById(R.id.btn_sv);
        btn_s = findViewById(R.id.btn_show);

        btn_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addSinhVienToLop(new SinhVienLop(0,
                        Integer.parseInt(msv.getText().toString()),
                        Integer.parseInt(ml.getText().toString()),
                        kh.getText().toString(),
                        Integer.parseInt(stc.getText().toString())));
                Toast.makeText(ThemSinhVienVaoLopActivity.this,"Them Thanh Cong",Toast.LENGTH_SHORT).show();
            }
        });
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemSinhVienVaoLopActivity.this, ShowSVTheoLopActivity.class);
                intent.putExtra("lop",Integer.parseInt(nl.getText().toString()));
                startActivity(intent);
            }
        });


    }
}
