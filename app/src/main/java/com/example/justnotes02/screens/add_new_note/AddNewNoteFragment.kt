package com.example.justnotes02.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.ViewModelProvider
import com.example.justnotes02.R
import com.example.justnotes02.databinding.FragmentAddNewNoteBinding
import com.example.justnotes02.models.AppNote
import com.example.justnotes02.utils.APP_ACTIVITY
import com.example.justnotes02.utils.showToast

class AddNewNoteFragment : Fragment() {
    private var _binding: FragmentAddNewNoteBinding? = null
    private val binding: FragmentAddNewNoteBinding get() = _binding!!
    lateinit var viewModel: AddNewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        viewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        binding.btnAddNote.setOnClickListener {
            val name = binding.inputNameNote.text.toString()
            val text = binding.inputTextNote.text.toString()
            if (name.isEmpty()) {
                showToast(getString(R.string.enter_title))
            } else {
                viewModel.insert(AppNote(name = name, text = text)) {
                    APP_ACTIVITY.navController.navigate(
                        R.id.action_addNewNoteFragment_to_mainFragment
                    )
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}