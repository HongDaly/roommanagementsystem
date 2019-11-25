package com.its.roommangamentapp.tool;

public class DBConstant {

    public static final String DATABASE_NAME = "db_room";
    public static final int DATABASE_VERSION = 1;

    ////Entity
    public static final String ROOM_TABLE = "room";
    public static final String ROOM_ID = "id";
    public static final String ROOM_NAME = "name";
    public static final String ROOM_PRICE = "price";
    public static final String ROOM_SIZE = "size";
    public static final String ROOM_DESCRIPTION = "description";

    public static final String CREATE_ROOM_TABLE =
            "CREATE TABLE "+
            ROOM_TABLE + " ( "+
            ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ROOM_NAME + " TEXT NOT NULL, " +
            ROOM_SIZE + " TEXT NOT NULL, " +
            ROOM_PRICE + " TEXT NOT NULL, " +
            ROOM_DESCRIPTION + " TEXT NOT NULL )";

}
