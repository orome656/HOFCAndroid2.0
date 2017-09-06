package com.hofc.hofc.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hofc.hofc.databinding.ActuItemBinding
import com.hofc.hofc.models.Actu
import com.hofc.hofc.R
import com.hofc.hofc.callbacks.ActuClickCallback

/**
 * Created by maladota on 01/09/2017.
 */
class ActuAdapter(val actuClickCallback: ActuClickCallback): RecyclerView.Adapter<ActuAdapter.ActuViewHolder>() {
    var _actusList: List<Actu>? = null

    var actusList: List<Actu>?
        get() = _actusList
        set(value) {
            if(_actusList == null) {
                _actusList = value
                notifyItemRangeInserted(0, value!!.size)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ActuViewHolder {
        var binding: ActuItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.actu_item,
                parent,
                false)

        binding.callback = actuClickCallback

        return ActuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActuViewHolder?, position: Int) {
        holder!!.binding.actu = _actusList!!.get(position)
        holder.binding.executePendingBindings();
    }

    override fun getItemCount(): Int {
        return if(actusList != null) actusList!!.size else 0
    }

    class ActuViewHolder(val binding: ActuItemBinding): RecyclerView.ViewHolder(binding.root)
}