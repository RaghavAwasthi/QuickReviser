package com.app.easyreviser.home.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.easyreviser.databinding.ItemCardBinding
import com.app.easyreviser.repository.entities.DayModel

class CardListAdapter(mcardlist: List<DayModel>) :
    RecyclerView.Adapter<CardListAdapter.CardViewHolder>() {


    var cardList = mcardlist
    lateinit var listener: OnClickListener

    inner class CardViewHolder(itemView: ItemCardBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(ItemCardBinding.inflate(parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        if (cardList.get(position).flag) {
            holder.binding.startButton.setColorFilter(Color.GRAY)
        } else {
            holder.binding.startButton.setColorFilter(Color.GREEN)

        }

        holder.binding.tvDesc.setText(cardList.get(position).job.shortdesctiption)

        holder.binding.imageItem.setOnClickListener {
            listener?.onCardItemClicked(cardList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    interface OnClickListener {
        fun onCardItemClicked(card: DayModel);
    }
}
