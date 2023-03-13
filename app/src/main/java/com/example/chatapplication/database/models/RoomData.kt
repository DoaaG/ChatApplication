package com.example.chatapplication.database.models

import com.example.chatapplication.R
import java.io.Serializable

data class RoomData(
    var id : String? = null,
    var roomName : String? = null,
    var description : String? = null,
    var categoryName : String? = null
):Serializable
{
    fun getImage(): Int{
        if(categoryName == "Movies") return R.drawable.movies
        else if (categoryName == "Music") return R.drawable.music
        else
            return R.drawable.sports
    }
}
