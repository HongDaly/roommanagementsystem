package com.its.roommangamentapp.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.its.roommangamentapp.model.Room;
import com.its.roommangamentapp.tool.DBConstant;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DBConstant.DATABASE_NAME, null, DBConstant.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        Create table room
        sqLiteDatabase.execSQL(DBConstant.CREATE_ROOM_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        delete table room
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DBConstant.ROOM_TABLE);
//        create new database table
        onCreate(sqLiteDatabase);
    }

    public void addRoom(Room room){

        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBConstant.ROOM_NAME,room.getName());
        values.put(DBConstant.ROOM_PRICE,room.getPrice());
        values.put(DBConstant.ROOM_SIZE,room.getSize());
        values.put(DBConstant.ROOM_DESCRIPTION,room.getDes());

        database.insert(DBConstant.ROOM_TABLE,null,values);
        database.close();

    }
    public ArrayList<Room> getAllRoom(){
        ArrayList<Room> rooms = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();

        Cursor c = database.rawQuery("Select * From "+DBConstant.ROOM_TABLE,null);
        if(c.moveToFirst()){
            while (c.moveToNext()){
                Room room = new Room();
                room.setName(c.getString(c.getColumnIndex(DBConstant.ROOM_NAME)));
                room.setPrice(c.getString(c.getColumnIndex(DBConstant.ROOM_PRICE)));
                room.setSize(c.getString(c.getColumnIndex(DBConstant.ROOM_SIZE)));
                room.setDes(c.getString(c.getColumnIndex(DBConstant.ROOM_DESCRIPTION)));

                rooms.add(room);
            }
        }
        c.close();
        database.close();


        return  rooms;
    }

}
