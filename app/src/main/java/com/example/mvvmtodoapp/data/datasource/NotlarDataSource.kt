package com.example.mvvmtodoapp.data.datasource

import androidx.lifecycle.MutableLiveData
import com.example.mvvmtodoapp.data.entity.Notlar
import com.example.mvvmtodoapp.room.NotlarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotlarDataSource(var ndao:NotlarDao) {
    var notlarListesi = ArrayList<Notlar>()


    suspend fun notlariYukle() : List<Notlar> =
        withContext(Dispatchers.IO){
        ndao.tumNotlar()
    }

    suspend fun notKayit(yapilacak_is:String){
        val yeniNot = Notlar(0,yapilacak_is)
        ndao.notEkle(yeniNot)

    }

    suspend fun notGuncelle(not_id:Int,yapilacak_is:String){
        val guncellenenNot = Notlar(not_id, yapilacak_is)
        ndao.notGuncelle(guncellenenNot)

    }

    suspend fun notAra(aramaKelimesi:String): List<Notlar> =
        withContext(Dispatchers.IO){
            ndao.notArama(aramaKelimesi)
        }


    suspend fun notSil(not_id:Int){
        val silinenNot = Notlar(not_id,"")
        ndao.notSil(silinenNot)

    }

    suspend fun tumNotlariAl() : List<Notlar> =
        withContext(Dispatchers.IO){
            ndao.tumNotlar()
        }


}