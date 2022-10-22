package com.example.mvvmtodoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "notlar")
data class Notlar(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "not_id") @NotNull var not_id:Int,
                  @ColumnInfo(name = "yapilacak_is") @NotNull var yapilacak_is:String) : Serializable {
}