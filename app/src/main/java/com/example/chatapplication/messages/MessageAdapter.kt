package com.example.chatapplication.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.databinding.ChatItemBinding

class MessageAdapter(var messagesList : List<MessageData>): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    inner class MessageViewHolder(var bind: ChatItemBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(items: MessageData) {
            bind.messageItem = items
            bind.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ChatItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        var items = messagesList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int = messagesList.size
}