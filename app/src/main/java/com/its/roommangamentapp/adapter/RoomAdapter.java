package com.its.roommangamentapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.its.roommangamentapp.R;
import com.its.roommangamentapp.model.Room;
import com.its.roommangamentapp.view_holder.RoomViewHolder;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomViewHolder> {
    private Context context;
    private ArrayList<Room> rooms;

    public  RoomAdapter(Context context, ArrayList<Room> rooms){
        this.context = context;
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_room,parent,false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        holder.init(rooms.get(position));
    }

    @Override
    public int getItemCount() {
        if(rooms.size() != 0) return rooms.size();
        return 0;
    }
}
