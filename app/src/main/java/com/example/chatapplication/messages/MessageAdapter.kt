package com.example.chatapplication.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.UserProvider
import com.example.chatapplication.database.models.MessageData
import com.example.chatapplication.databinding.ChatItemBinding
import com.example.chatapplication.databinding.ChatRecivedItemBinding

class MessageAdapter(var messagesList: List<MessageData>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    inner class MessageViewHolder(var bind: ViewDataBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(items: MessageData) {
            if (bind is ChatItemBinding ){
                (bind as ChatItemBinding).messageItem = items
            }
            else if (bind is ChatRecivedItemBinding ){
                (bind as ChatRecivedItemBinding).messageItem = items
            }
            bind.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        var binding : ViewDataBinding = ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        if (viewType == 1){
             binding = ChatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }

        else if (viewType == 2){
             binding = ChatRecivedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        var items = messagesList[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int = messagesList.size

    fun changeData(newMessageList: List<MessageData>) {
        messagesList = newMessageList
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val message = messagesList[position]
        return if (message.senderId == UserProvider.user?.id)
            1
        else
            2
    }

}