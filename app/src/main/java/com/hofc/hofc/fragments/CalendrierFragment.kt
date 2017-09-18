package com.hofc.hofc.fragments

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hofc.hofc.R
import com.hofc.hofc.adapters.ActuAdapter
import com.hofc.hofc.callbacks.ActuClickCallback
import com.hofc.hofc.databinding.ActusListBinding
import com.hofc.hofc.databinding.CalendarFragmentBinding
import com.hofc.hofc.models.Actu
import com.hofc.hofc.models.Match
import com.hofc.hofc.utils.Constantes
import com.hofc.hofc.viewmodels.CalendrierViewModel

/**
 * Created by maladota on 06/09/2017.
 */
class CalendrierFragment : LifecycleFragment() {

    private var calendrierViewModel: CalendrierViewModel? = null

    private var mBinding: CalendarFragmentBinding? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        calendrierViewModel = ViewModelProviders.of(this).get(CalendrierViewModel::class.java)

        subscribeUi(calendrierViewModel!!)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.calendar_fragment, container, false)

        mBinding!!.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                calendrierViewModel?.getMatchsForTeam(Constantes.TEAM_LIST[tab!!.position])
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })

        return mBinding!!.getRoot();
    }

    fun subscribeUi(viewModel: CalendrierViewModel) {
        viewModel.matchs.observe(this, Observer<List<Match>> {
            if(it != null) {
                mBinding?.isLoading = false
            } else {
                mBinding?.isLoading = true
            }
        })
    }
}