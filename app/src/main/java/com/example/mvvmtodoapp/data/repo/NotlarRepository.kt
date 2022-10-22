package com.example.mvvmtodoapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.mvvmtodoapp.data.datasource.NotlarDataSource
import com.example.mvvmtodoapp.data.entity.Notlar
import com.example.mvvmtodoapp.room.NotlarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotlarRepository (var nds: NotlarDataSource){

    suspend fun kaydet(yapilacak_is: String) = nds.notKayit(yapilacak_is)

    suspend fun guncelle(not_id:Int, yapilacak_is: String) = nds.notGuncelle(not_id, yapilacak_is)

    suspend fun notlariYukle(): List<Notlar> = nds.notlariYukle()

    suspend fun ara(aramaKelimesi:String): List<Notlar> = nds.notAra(aramaKelimesi)

    suspend fun sil(not_id: Int) = nds.notSil(not_id)
}