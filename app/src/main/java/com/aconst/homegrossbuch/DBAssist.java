package com.aconst.homegrossbuch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Const on 17.03.2017.
 */

public class DBAssist extends SQLiteOpenHelper {
    public DBAssist(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(MainActivity.TAG, "--- onCreate database ---");

        // Действия
        Log.d(MainActivity.TAG, "--- create table actions ---");
        db.execSQL("create table actions ("
                + "act_id integer primary key autoincrement,"
                + "act_date date,"
                + "act_account int,"
                + "act_operation integer,"
                + "act_value float,"
                + "act_value_cur float,"
                + "act_commission float,"
                + "act_comment text"
                + ");");

        // Переводы между счетами
        Log.d(MainActivity.TAG, "--- create table transfer ---");
        db.execSQL("create table transfer ("
                + "tr_id integer primary key autoincrement,"
                + "tr_date date,"
                + "tr_src_acc int,"
                + "tr_dest_acc int,"
                + "tr_src_amount float,"
                + "tr_dest_amount float,"
                + "tr_comment text"
                + ");");

        // Счета - справочник
        Log.d(MainActivity.TAG, "--- create table ref_accounts ---");
        db.execSQL("create table ref_accounts ("
                + "acc_id integer primary key autoincrement,"
                + "acc_name text,"
                + "acc_cashe boolean,"
                + "acc_currency int,"
                + "acc_comment text"
                + ");");

        // Операции - справочник
        Log.d(MainActivity.TAG, "--- create table ref_operations ---");
        db.execSQL("create table ref_operations ("
                + "op_id integer primary key autoincrement,"
                + "op_name text,"
                + "op_group int,"
                + "op_income boolean,"
                + "op_comment text"
                + ");");

        // Валюты - справочник
        Log.d(MainActivity.TAG, "--- create table ref_currency ---");
        db.execSQL("create table ref_currency ("
                + "cur_id integer primary key autoincrement,"
                + "cur_code text,"
                + "cur_name text,"
                + "cur_short text"
                + ");");

        // Счетчики - справочник
        Log.d(MainActivity.TAG, "--- create table ref_counters ---");
        db.execSQL("create table ref_counters ("
                + "cnt_id integer primary key autoincrement,"
                + "cnt_name text,"
                + "cnt_type int,"
                + "cnt_number text,"
                + "cnt_short text"
                + ");");

        // Тарифы
        Log.d(MainActivity.TAG, "--- create table tariffs ---");
        db.execSQL("create table tariffs ("
                + "ta_id integer primary key autoincrement,"
                + "ta_date date,"
                + "ta_counter int,"
                + "ta_tariff int,"
                + "ta_price float"
                + ");");

        // Расход ресурсов
        Log.d(MainActivity.TAG, "--- create table resources ---");
        db.execSQL("create table resources ("
                + "res_id integer primary key autoincrement,"
                + "res_date date,"
                + "res_counter int,"
                + "res_tariff int,"
                + "res_value float"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
