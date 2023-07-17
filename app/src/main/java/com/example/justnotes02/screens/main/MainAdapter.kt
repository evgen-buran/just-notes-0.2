package com.example.justnotes02.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justnotes02.R
import com.example.justnotes02.models.AppNote

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>(){
    private var notesList: List<AppNote> = emptyList()

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameNote: TextView = view.findViewById(R.id.tvItemNameNote)
        val textNote: TextView = view.findViewById(R.id.tvItemTextNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.nameNote.text = notesList.get(position).name
        holder.textNote.text = notesList.get(position).text

    }
    fun setList(list: List<AppNote>) {
        notesList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{MainFragment.click(notesList.get(holder.adapterPosition))}
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)

    }
}