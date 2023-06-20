package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.model.Lop;

import java.util.List;


public class LopAdapter extends BaseAdapter {
    private List<Lop> sv;
    private Context context;

    public LopAdapter(List<Lop> sv, Context context) {
        this.sv = sv;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sv.size();
    }

    @Override
    public Lop getItem(int position) {
        return sv.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.l_holder,parent,false);
        }

        Lop sinhVien = sv.get(position);

        ((TextView)convertView.findViewById(R.id.id)).setText("MSV :"+sinhVien.getId());
        ((TextView)convertView.findViewById(R.id.ten)).setText("Ten :"+sinhVien.getTenLop());
        ((TextView)convertView.findViewById(R.id.mota)).setText("Mo Ta :"+sinhVien.getMoTa());




        return convertView;
    }
}
