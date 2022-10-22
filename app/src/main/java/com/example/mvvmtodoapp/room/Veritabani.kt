package com.example.mvvmtodoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmtodoapp.data.entity.Notlar

@Database(entities = [Notlar::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getNotlarDao() : NotlarDao
}