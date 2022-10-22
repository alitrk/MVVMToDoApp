package com.example.mvvmtodoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmtodoapp.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor(var nrepo:NotlarRepository): ViewModel(){
    fun kayit (yapilacak_is:String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.kaydet(yapilacak_is)
        }
    }

}