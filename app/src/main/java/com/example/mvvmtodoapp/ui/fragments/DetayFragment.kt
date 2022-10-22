package com.example.mvvmtodoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mvvmtodoapp.R
import com.example.mvvmtodoapp.databinding.FragmentDetayBinding
import com.example.mvvmtodoapp.ui.viewmodel.DetayFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var tasarim:FragmentDetayBinding
    private lateinit var viewModel: DetayFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)
        tasarim.kisiDetayFragment = this
        tasarim.detayToolbarBaslik = "Not Detay"

        val bundle:DetayFragmentArgs by navArgs()
        val gelenKisi = bundle.not
        tasarim.notNesnesi = gelenKisi

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelleTikla(not_id:Int, yapilacak_is:String){
        viewModel.guncelle(not_id,yapilacak_is)
    }
}