package com.example.chatapplication.messages

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.R
import com.example.chatapplication.UserProvider
import com.example.chatapplication.base.BaseActivity
import com.example.chatapplication.database.models.MessageData
import com.example.chatapplication.database.models.RoomData
import com.example.chatapplication.databinding.ActivityChatMessageBinding
import java.util.*

class ChatMessageActivity : BaseActivity<ChatViewModel, ActivityChatMessageBinding>(),
    ChatNavigator {
    private lateinit var Adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.chat = viewModel
        viewModel.chatNavigator = this
        viewModel.roomPosition = intent.getSerializableExtra("roomPosition") as RoomData
        Adapter = MessageAdapter(listOf())
        binding.chatRecycler.adapter = Adapter
        viewModel.loadMessages()
        observeMessagesLiveData()

    }

    override fun getLayoutActivity(): Int = R.layout.activity_chat_message

    override fun getClassViewModel(): ChatViewModel =
        ViewModelProvider(this)[ChatViewModel::class.java]

    private fun observeMessagesLiveData(){
        viewModel.messagesLiveData.observe(this){
                Adapter.changeData(it)
            binding.typeMessageTextView.text.clear()
        }
    }

    override fun back() {
        finish()
    }
}