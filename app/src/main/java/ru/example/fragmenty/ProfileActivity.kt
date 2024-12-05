package ru.example.fragmenty

import android.os.Bundle
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
        setContentView(bind.root)
        bind.imgProf.setBackgroundResource(R.drawable.shape)
    }
}