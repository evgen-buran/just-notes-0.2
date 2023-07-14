package com.example.justnotes02.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class AppNote(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val name: String = "",
    @ColumnInfo val text: String = ""
)
