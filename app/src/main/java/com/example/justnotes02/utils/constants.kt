package com.example.justnotes02.utils

import com.example.justnotes02.MainActivity
import com.example.justnotes02.database.DatabaseRepository
import com.example.justnotes02.database.room.AppRoomRepository

lateinit var APP_ACTIVITY: MainActivity
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
lateinit var REPOSITORY:DatabaseRepository
