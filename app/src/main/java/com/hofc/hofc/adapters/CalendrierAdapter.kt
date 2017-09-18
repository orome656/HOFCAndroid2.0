package com.hofc.hofc.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hofc.hofc.databinding.MatchItemBinding
import com.hofc.hofc.models.Match

/**
 * Created by maladota on 18/09/2017.
 */
class CalendrierAdapter: RecyclerView.Adapter<CalendrierAdapter.CalendrierViewHolder>() {

    var matchList: List<Match>? = null

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CalendrierViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CalendrierViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CalendrierViewHolder(val binding: MatchItemBinding): RecyclerView.ViewHolder(binding.root)
}