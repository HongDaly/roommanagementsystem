package com.its.roommangamentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.its.roommangamentapp.helper.DBHelper;
import com.its.roommangamentapp.model.Room;

public class AddRoomActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName;
    private EditText edtPrice;
    private EditText edtSize;
    private EditText edtDescription;
    private Button btnSave;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);


        edtName = findViewById(R.id.edt_room_name);
        edtPrice = findViewById(R.id.edt_room_price);
        edtSize = findViewById(R.id.edt_room_size);
        edtDescription = findViewById(R.id.edt_room_des);
        btnSave = findViewById(R.id.btnSave);

        dbHelper = new DBHelper(this);


        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == btnSave.getId()){

//          get data from edit text to room object
            Room room = new Room();
            room.setName(edtName.getText().toString());
            room.setPrice(edtPrice.getText().toString());
            room.setDes(edtDescription.getText().toString());
            room.setSize(edtSize.getText().toString());
//          save room to database
            dbHelper.addRoom(room);
//          back to main activity
            finish();

        }
    }
}
