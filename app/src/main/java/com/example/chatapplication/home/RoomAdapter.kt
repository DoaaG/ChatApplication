package com.example.chatapplication.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.databinding.RoomItemBinding
import com.example.chatapplication.database.models.RoomData


class RoomAdapter(var roomList : List<RoomData>): RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {
    inner class RoomViewHolder(var bind: RoomItemBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(items: RoomData) {
            bind.roomItem = items
            bind.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = RoomItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        var items = roomList[position]
        holder.bind(items)
    }

    fun changeData(newRoomList : List<RoomData>){
        roomList = newRoomList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = roomList.size
}