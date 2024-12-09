package ru.example.fragmenty

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.example.fragmenty.databinding.CardachievmentsBinding

class AchievmentsAdapter(val AchArray:ArrayList<Achievments>):RecyclerView.Adapter<AchievmentsAdapter.AchHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
       val binding = DataBindingUtil.inflate<CardachievmentsBinding>(layoutInflater, R.layout.cardachievments, parent, false)
        return AchHolder(binding)
    }

    override fun getItemCount(): Int {
        return AchArray.size
    }

    override fun onBindViewHolder(holder: AchHolder, position: Int) {
        val achiv  =AchArray[position]
        holder.name?.text = achiv.name
        holder.data?.text = achiv.date
    }
    inner class AchHolder(binding:CardachievmentsBinding):RecyclerView.ViewHolder(binding.root){
        var name:TextView? =null
        var data:TextView? = null
        init{
            name = binding.AchName
            data = binding.AchDate
        }
    }
}