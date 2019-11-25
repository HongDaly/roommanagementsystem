package com.its.roommangamentapp.view_holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.its.roommangamentapp.R;
import com.its.roommangamentapp.model.Room;

public class RoomViewHolder  extends RecyclerView.ViewHolder{
    private TextView tvRoomName;
    public RoomViewHolder(@NonNull View itemView) {
        super(itemView);

        tvRoomName = itemView.findViewById(R.id.vh_room_tv_name);
    }

    public void init(Room room){
        tvRoomName.setText(room.getName());
    }
}
