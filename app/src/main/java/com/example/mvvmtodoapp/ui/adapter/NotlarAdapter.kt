package com.example.mvvmtodoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtodoapp.R
import com.example.mvvmtodoapp.data.entity.Notlar
import com.example.mvvmtodoapp.databinding.CardTasarimBinding
import com.example.mvvmtodoapp.ui.fragments.AnasayfaFragmentDirections
import com.example.mvvmtodoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.mvvmtodoapp.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class NotlarAdapter (var mContext: Context,
                     var notlarListesi:List<Notlar>,
                     var viewModel: AnasayfaFragmentViewModel
)
    : RecyclerView.Adapter<NotlarAdapter.CardViewHolder>() {

    inner class CardViewHolder(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim//Shadowing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim: CardTasarimBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.card_tasarim, parent, false
        )
        return CardViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val not = notlarListesi.get(position)
        val t = holder.tasarim
        t.notlarNesnesi = not

        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it, "Not silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET") {
                    viewModel.sil(not.not_id)
                }.show()
        }

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(not = not )
            Navigation.gecisYap(it, gecis)
        }
    }

    override fun getItemCount(): Int {
        return notlarListesi.size
    }
}