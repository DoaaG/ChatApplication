package com.example.chatapplication.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.database.models.RoomData
import com.example.chatapplication.databinding.RoomItemBinding
import com.example.chatapplication.messages.ChatMessageActivity


class RoomAdapter(var context: Context, var roomList: List<RoomData>) :
    RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {
    inner class RoomViewHolder(var bind: RoomItemBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(items: RoomData) {
            bind.roomItem = items
            bind.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = RoomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        var items = roomList[position]
        holder.bind(items)
        holder.bind.roomCardView.setOnClickListener {
            moveToMessages(items)
        }
    }

    private fun moveToMessages(roomPosition: RoomData) {
        var intent = Intent(context, ChatMessageActivity::class.java)
        intent.putExtra("roomPosition",roomPosition)  // need to use Serializable at RoomData
        context.startActivity(intent)
    }

    fun changeData(newRoomList: List<RoomData>) {
        roomList = newRoomList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = roomList.size
}