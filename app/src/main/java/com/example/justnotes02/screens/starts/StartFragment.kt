package com.example.justnotes02.screens.starts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.justnotes02.R
import com.example.justnotes02.databinding.FragmentMainBinding
import com.example.justnotes02.databinding.FragmentStartBinding
import com.example.justnotes02.utils.APP_ACTIVITY
import com.example.justnotes02.utils.TYPE_ROOM


class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding: FragmentStartBinding get() = _binding!!
    private lateinit var viewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initialization() {
        viewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        binding.btnRoom.setOnClickListener {
            viewModel.initDatabase(TYPE_ROOM) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
    }


}
