package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.SinhVienAdapter;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.SinhVien;

import java.util.List;

public class ShowSVTheoLopActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    SinhVienAdapter sinhVienAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sv);
        Intent intent = getIntent();

        int lop = intent.getIntExtra("lop",0);
        db = new DatabaseHelper(this);
        List<SinhVien> sv = db.getSinhVienLops(lop);
        sinhVienAdapter = new SinhVienAdapter(sv,this);
        ((TextView) findViewById(R.id.title)).setText("DANH SACH SINH VIEN LOP "+lop);
        Log.d("tag","so sv "+sv.size());
        listView = findViewById(R.id.list_sv);

        listView.setAdapter(sinhVienAdapter);

    }
}
