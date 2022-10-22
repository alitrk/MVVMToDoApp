package com.example.mvvmtodoapp.room

import androidx.room.*
import com.example.mvvmtodoapp.data.entity.Notlar

@Dao
interface NotlarDao {

    @Query("SELECT * FROM notlar")
    suspend fun tumNotlar() : List<Notlar>

    @Insert
    suspend fun notEkle(not:Notlar)

    @Update
    suspend fun notGuncelle(not:Notlar)

    @Delete
    suspend fun notSil(not:Notlar)

    @Query("SELECT * FROM notlar WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun notArama(aramaKelimesi:String) : List<Notlar>
}