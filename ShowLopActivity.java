package com.example.myapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.LopAdapter;
import com.example.myapplication.R;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.Lop;

import java.util.List;

public class ShowLopActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    LopAdapter lopAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lop);
        db = new DatabaseHelper(this);
        List<Lop> sv = db.getLops();
        lopAdapter = new LopAdapter(sv,this);
//
        Log.d("tag","so lopp "+sv.size());
        listView = findViewById(R.id.list_sv);
//
        listView.setAdapter(lopAdapter);





    }
}
