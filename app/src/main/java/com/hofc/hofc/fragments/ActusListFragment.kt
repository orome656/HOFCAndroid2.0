package com.hofc.hofc.fragments

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hofc.hofc.viewmodels.ActusListViewModel
import com.hofc.hofc.R
import com.hofc.hofc.adapters.ActuAdapter
import com.hofc.hofc.databinding.ActusListBinding
import com.hofc.hofc.models.Actu

/**
 * Created by maladota on 31/08/2017.
 */
class ActusListFragment: LifecycleFragment() {

    private var actusListViewModel: ActusListViewModel? = null

    private var mBinding: ActusListBinding? = null
    private var mActuAdapter: ActuAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        actusListViewModel = ViewModelProviders.of(this).get(ActusListViewModel::class.java)

        subscribeUi(actusListViewModel!!)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.actus_list, container, false)

        mActuAdapter = ActuAdapter()
        mBinding!!.actusList.adapter = mActuAdapter

        return mBinding!!.getRoot();
    }

    fun subscribeUi(viewModel: ActusListViewModel) {
        viewModel.getActus()!!.observe(this, Observer<List<Actu>> {
            it?.let {
                mBinding?.isLoading = false
                mActuAdapter?.actusList = it
            }
        }
        )
    }
}