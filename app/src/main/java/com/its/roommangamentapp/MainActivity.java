package com.its.roommangamentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.its.roommangamentapp.adapter.RoomAdapter;
import com.its.roommangamentapp.helper.DBHelper;
import com.its.roommangamentapp.model.Room;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fbtnAddRoom;
    private RoomAdapter roomAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fbtnAddRoom = findViewById(R.id.fbtn_add_room);
        fbtnAddRoom.setOnClickListener(this);

        recyclerView = findViewById(R.id.rcv_room_list);
        dbHelper = new DBHelper(this);
//      get All Room
        ArrayList<Room> rooms = dbHelper.getAllRoom();
        Log.d("Room", "onCreate: "+rooms.size());
        roomAdapter = new RoomAdapter(getApplicationContext(),rooms);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(roomAdapter);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();


        if(id == fbtnAddRoom.getId()){
            Intent intent = new Intent(MainActivity.this,AddRoomActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        ArrayList<Room> rooms = dbHelper.getAllRoom();
        roomAdapter.updateRoomList(rooms);
        super.onResume();
    }
}
