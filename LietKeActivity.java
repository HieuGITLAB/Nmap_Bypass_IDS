package com.example.myapplication.activity;

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

public class LietKeActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    SinhVienAdapter sinhVienAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sv);
        db = new DatabaseHelper(this);
        List<SinhVien> sv = db.getSinhVienByTen();
        sinhVienAdapter = new SinhVienAdapter(sv,this);
        ((TextView) findViewById(R.id.title)).setText("Danh Sach Sv Ten Nam Hoc Nam 2");


        Log.d("tag","so sv "+sv.size());
        listView = findViewById(R.id.list_sv);

        listView.setAdapter(sinhVienAdapter);

    }
}
