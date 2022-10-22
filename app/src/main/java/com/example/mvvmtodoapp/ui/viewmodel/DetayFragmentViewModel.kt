package com.example.mvvmtodoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmtodoapp.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel  @Inject constructor(var nrepo: NotlarRepository): ViewModel(){
    fun guncelle (not_id:Int, yapilacak_is:String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.guncelle(not_id, yapilacak_is)
        }
    }
}