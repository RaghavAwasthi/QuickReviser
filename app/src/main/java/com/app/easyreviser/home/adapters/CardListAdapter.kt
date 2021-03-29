package com.app.easyreviser.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.easyreviser.databinding.ItemCardBinding
import com.app.easyreviser.repository.entities.DayModel

class CardListAdapter(mcardlist: List<DayModel>) :
        RecyclerView.Adapter<CardListAdapter.CardViewHolder>() {


    var cardList = mcardlist

    inner class CardViewHolder(itemView: ItemCardBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(ItemCardBinding.inflate(parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        holder.binding.tvDesc.setText(cardList.get(position).job.shortdesctiption)


    }

    override fun getItemCount(): Int {
        return cardList.size
    }
}
