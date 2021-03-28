package com.chifamobile.medilista.medicament

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chifamobile.medilista.R

class MedicamentListFragment : Fragment() {

    companion object {
        fun newInstance() = MedicamentListFragment()
    }

    private lateinit var viewModel: MedicamentListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.medicament_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MedicamentListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}