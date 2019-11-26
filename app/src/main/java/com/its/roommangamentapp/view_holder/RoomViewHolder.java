package com.its.roommangamentapp.view_holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.its.roommangamentapp.R;
import com.its.roommangamentapp.model.Room;

public class RoomViewHolder  extends RecyclerView.ViewHolder {
    private TextView tvRoomName;
    private TextView tvRoomPrice;
    public ImageButton btnDeleteRoom;
    public RoomViewHolder(@NonNull View itemView) {
        super(itemView);

        tvRoomName = itemView.findViewById(R.id.vh_room_tv_name);
        tvRoomPrice = itemView.findViewById(R.id.vh_room_tv_price);
        btnDeleteRoom = itemView.findViewById(R.id.vh_room_btn_delete);


    }

    public void init(Room room){
        tvRoomName.setText(room.getName());
        tvRoomPrice.setText(room.getPrice()+" $");
    }


}
