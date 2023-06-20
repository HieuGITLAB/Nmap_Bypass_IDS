package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Lop;
import com.example.myapplication.model.SinhVien;
import com.example.myapplication.model.SinhVienLop;
import com.example.myapplication.model.ThongKe;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "QLSV",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSV = "CREATE TABLE SinhVien " +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "ten TEXT," +
                "que TEXT ," +
                "namSinh TEXT," +
                "namHoc TEXT) ";
        db.execSQL(tableSV);

        String tableL = "CREATE TABLE LOP " +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ten TEXT," +
                "mota TEXT)";
        db.execSQL(tableL);

        String tableLSV = "CREATE TABLE SinhVien_Lop" +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "msv INTEGER," +
                "ml INTEGER," +
                "kiHoc TEXT ," +
                "stc INTEGER)";
        db.execSQL(tableLSV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addSinhVien(SinhVien sv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten",sv.getName());
        values.put("que",sv.getQueQuan());
        values.put("namSinh", sv.getNamSinh());
        values.put("namHoc",sv.getNamHoc());
        db.insert("SinhVien","id",values);
        db.close();

    }
    public void addSinhVienToLop(SinhVienLop sv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("msv",sv.getMsv());
        values.put("ml",sv.getMl());
        values.put("kiHoc", sv.getKiHoc());
        values.put("stc",sv.getStc());
        db.insert("SinhVien_Lop","id",values);
        db.close();

    }
    public void addLop(Lop sv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ten",sv.getTenLop());
        values.put("mota",sv.getMoTa());
        db.insert("LOP","id",values);
        db.close();

    }

    public List<SinhVien> getSinhViens(){
        String query = " SELECT * FROM  SinhVien";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cs = db.rawQuery(query,null);
        List<SinhVien> sv = new ArrayList<>();

        while(cs.moveToNext()){
            sv.add(new SinhVien(
                    cs.getInt(0),
                    cs.getString(1),
                    cs.getString(2),
                    cs.getString(3),
                    cs.getString(4)

            ));
        }
        return sv;

    }
    public List<Lop> getLops(){
        String query = " SELECT * FROM  LOP";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cs = db.rawQuery(query,null);
        List<Lop> sv = new ArrayList<>();

        while(cs.moveToNext()){
            sv.add(new Lop(
                    cs.getInt(0),
                    cs.getString(1),
                    cs.getString(2)

            ));
        }
        return sv;

    }
    public List<SinhVien> getSinhVienLops(int ml){
        String query = " SELECT * FROM  SinhVien " +
                "JOIN SinhVien_Lop ON SinhVien.id = SinhVien_Lop.msv" +
                " WHERE SinhVien_Lop.ml = "+ml;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cs = db.rawQuery(query,null);
        List<SinhVien> sv = new ArrayList<>();

        while(cs.moveToNext()){
            sv.add(new SinhVien(
                    cs.getInt(0),
                    cs.getString(1),
                    cs.getString(2),
                    cs.getString(3),
                    cs.getString(4)

            ));
        }
        return sv;

    }

    public List<SinhVien> getSinhVienByTen(){
        String query = " SELECT * FROM  SinhVien " +
                " WHERE ten = 'Nam' AND namHoc = '2'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cs = db.rawQuery(query,null);
        List<SinhVien> sv = new ArrayList<>();

        while(cs.moveToNext()){
            sv.add(new SinhVien(
                    cs.getInt(0),
                    cs.getString(1),
                    cs.getString(2),
                    cs.getString(3),
                    cs.getString(4)

            ));
        }
        return sv;

    }

    public List<ThongKe> thongKes(){
        String query = " SELECT LOP.id,COUNT(SinhVien.id) AS SSV " +
                "FROM  LOP " +
                "JOIN SinhVien_Lop ON SinhVien_Lop.ml = LOP.id " +
                "JOIN SinhVien ON SinhVien.id = SinhVien_Lop.msv " +
                "GROUP BY LOP.id " +
                "ORDER BY SSV DESC";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cs = db.rawQuery(query,null);
        List<ThongKe> sv = new ArrayList<>();

        while(cs.moveToNext()){
            sv.add(new ThongKe(
                    cs.getInt(0),
                    cs.getInt(1)

            ));
        }
        return sv;

    }




}
