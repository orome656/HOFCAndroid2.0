package com.hofc.hofc.fragments

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hofc.hofc.R
import com.hofc.hofc.adapters.ActuAdapter
import com.hofc.hofc.callbacks.ActuClickCallback
import com.hofc.hofc.databinding.ActusListBinding
import com.hofc.hofc.models.Actu
import com.hofc.hofc.models.Match
import com.hofc.hofc.viewmodels.CalendrierViewModel

/**
 * Created by maladota on 06/09/2017.
 */
class CalendrierFragment : LifecycleFragment() {

    private var calendrierViewModel: CalendrierViewModel? = null

    private var mBinding: ActusListBinding? = null
    private var mActuAdapter: ActuAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        calendrierViewModel = ViewModelProviders.of(this).get(CalendrierViewModel::class.java)

        subscribeUi(calendrierViewModel!!)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.actus_list, container, false)

        mActuAdapter = ActuAdapter(actuClickCallback)
        mBinding!!.actusList.adapter = mActuAdapter

        return mBinding!!.getRoot();
    }

    fun subscribeUi(viewModel: CalendrierViewModel) {
        viewModel.getTeams()!!.observe(this, Observer<List<String>> {
            if(it != null) {
                viewModel.getMatchsForTeam(it.get(0))!!.observe(this, Observer<List<Match>> {
                    it?.let {
                        mBinding?.isLoading = false
                        //mActuAdapter?.actusList = it
                    }
                })
            }
        })
    }

    val actuClickCallback = object : ActuClickCallback {
        override fun onClick(actu: Actu) {
            Log.d("test", "On va vers le détail de l'actu")
        }
    }
}