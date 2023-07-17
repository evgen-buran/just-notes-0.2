package com.example.justnotes02.screens.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.justnotes02.R
import com.example.justnotes02.databinding.FragmentNoteBinding
import com.example.justnotes02.models.AppNote
import com.example.justnotes02.utils.APP_ACTIVITY
import com.example.justnotes02.utils.showToast

class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding get() = _binding!!
    lateinit var viewModel: NoteFragmentViewModel
    lateinit var currentNote: AppNote
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        currentNote = arguments?.getSerializable("note") as AppNote
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    fun initialization() {
        viewModel = ViewModelProvider(this).get(NoteFragmentViewModel::class.java)
        setHasOptionsMenu(true)
        binding.tvNameNote.text = currentNote.name
        binding.tvTextNote.text = currentNote.text

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btnDeletw -> {
                viewModel.delete(currentNote
                ) { APP_ACTIVITY.navController.navigate(R.id.action_noteFragment_to_mainFragment) }

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}