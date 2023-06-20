package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.model.ThongKe;

import java.util.List;

public class ThongKeAdapter extends BaseAdapter {
    private List<ThongKe> sv;
    private Context context;

    public ThongKeAdapter(List<ThongKe> sv, Context context) {
        this.sv = sv;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sv.size();
    }

    @Override
    public ThongKe getItem(int position) {
        return sv.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.thongke_holder,parent,false);
        }

        ThongKe sinhVien = sv.get(position);

        ((TextView)convertView.findViewById(R.id.ml)).setText("ML :"+sinhVien.getMl());
        ((TextView)convertView.findViewById(R.id.ssv)).setText("SSV :"+sinhVien.getSsv());





        return convertView;
    }
}
