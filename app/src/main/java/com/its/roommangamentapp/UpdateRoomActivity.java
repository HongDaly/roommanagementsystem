package com.its.roommangamentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.its.roommangamentapp.helper.DBHelper;
import com.its.roommangamentapp.model.Room;

public class UpdateRoomActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtRoomName;
    private EditText edtPrice;
    private EditText edtSize;
    private EditText edtDes;
    private Room room = new Room();
    private Button btnUpdate;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_room);

        edtDes = findViewById(R.id.ur_edt_room_des);
        edtPrice = findViewById(R.id.ur_edt_room_price);
        edtRoomName = findViewById(R.id.ur_edt_room_name);
        edtSize = findViewById(R.id.ur_edt_room_size);
        btnUpdate = findViewById(R.id.ur_btn_update);

        room = (Room) getIntent().getSerializableExtra("room");

        init();
        dbHelper = new DBHelper(this);


        btnUpdate.setOnClickListener(this);

    }
    private void  init(){
        edtRoomName.setText(room.getName());
        edtPrice.setText(room.getPrice());
        edtSize.setText(room.getSize());
        edtDes.setText(room.getDes());
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == btnUpdate.getId()){
//

            room.setName(edtRoomName.getText().toString());
            room.setPrice(edtPrice.getText().toString());
            room.setDes(edtDes.getText().toString());
            room.setSize(edtSize.getText().toString());

//          update room
            dbHelper.updateRoom(room);

            finish();

        }
    }
}
