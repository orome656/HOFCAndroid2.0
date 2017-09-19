package com.hofc.hofc.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hofc.hofc.databinding.MatchItemBinding
import com.hofc.hofc.models.Match
import com.hofc.hofc.R

/**
 * Created by maladota on 18/09/2017.
 */
class CalendrierAdapter: RecyclerView.Adapter<CalendrierAdapter.CalendrierViewHolder>() {

    var matchList: List<Match>? = null

    override fun getItemCount(): Int {
        return if(matchList != null) matchList!!.size else 0
    }

    override fun onBindViewHolder(holder: CalendrierViewHolder?, position: Int) {
        holder!!.binding.match = matchList!!.get(position)
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CalendrierViewHolder {
        var binding: MatchItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.match_item,
                parent,
                false)

        return CalendrierViewHolder(binding)
    }

    class CalendrierViewHolder(val binding: MatchItemBinding): RecyclerView.ViewHolder(binding.root)
}