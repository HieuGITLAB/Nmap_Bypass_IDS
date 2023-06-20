package com.example.myapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.ThongKeAdapter;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.ThongKe;

import java.util.List;

public class ThongKeActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    ThongKeAdapter sinhVienAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongke);
        db = new DatabaseHelper(this);
        List<ThongKe> sv = db.thongKes();
        sinhVienAdapter = new ThongKeAdapter(sv,this);


        Log.d("tag","so sv "+sv.size());
        listView = findViewById(R.id.list_sv);

        listView.setAdapter(sinhVienAdapter);

    }
}
