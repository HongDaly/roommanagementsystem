package com.its.roommangamentapp.view_holder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.its.roommangamentapp.R;
import com.its.roommangamentapp.UpdateRoomActivity;
import com.its.roommangamentapp.model.Room;

public class RoomViewHolder  extends RecyclerView.ViewHolder {
    private TextView tvRoomName;
    private TextView tvRoomPrice;
    public ImageButton btnDeleteRoom;
    private ImageButton btnUpdateRoom;
    Room room = new Room();
    public RoomViewHolder(@NonNull final View itemView) {
        super(itemView);

        tvRoomName = itemView.findViewById(R.id.vh_room_tv_name);
        tvRoomPrice = itemView.findViewById(R.id.vh_room_tv_price);
        btnDeleteRoom = itemView.findViewById(R.id.vh_room_btn_delete);
        btnUpdateRoom = itemView.findViewById(R.id.vh_room_btn_update);

        btnUpdateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), UpdateRoomActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("room",room);
                itemView.getContext().startActivity(intent);
            }
        });

    }

    public void init(Room room){
        this.room = room;
        tvRoomName.setText(room.getName());
        tvRoomPrice.setText(room.getPrice()+" $");
    }


}
