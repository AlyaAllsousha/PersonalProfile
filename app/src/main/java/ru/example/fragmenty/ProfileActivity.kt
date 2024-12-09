package ru.example.fragmenty

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.example.fragmenty.databinding.ProfileActivityBinding

class ProfileActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  bind:ProfileActivityBinding = DataBindingUtil.setContentView(this, R.layout.profile_activity)
        val viewModel:ProfileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        viewModel.initProf(this, bind)
        bind.vm = viewModel
        bind.lifecycleOwner = this
        setContentView(bind.root)
        var states = resources.getStringArray(R.array.states)
        val adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,states)
        bind.Sp.adapter = adapter
        bind.Sp.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                bind.state.text = states[p2].toString()
                when(p2){
                    0 -> {
                        bind.circle.setBackgroundResource(R.drawable.circle_yellow)
                    }
                    1->{
                        bind.circle.setBackgroundResource(R.drawable.circle_red)
                    }
                    2->{
                        bind.circle.setBackgroundResource(R.drawable.circle_green)

                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }
}