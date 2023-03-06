package com.example.chatapplication.messages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.chatapplication.R
import com.example.chatapplication.databinding.ActivityChatMessageBinding

class ChatMessageActivity : AppCompatActivity() {
    lateinit var messageBinding: ActivityChatMessageBinding
    lateinit var Adapter: MessageAdapter
    lateinit var list: MutableList<MessageData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat_message)
        createlist()
        Adapter = MessageAdapter(list)
        messageBinding.chatRecycler.adapter = Adapter

    }

 fun createlist() {
        list = mutableListOf()
        for (i in 0..10) {
            list.add(MessageData("new message found" ,"10 AM"))
        }
    }
}