package ru.example.fragmenty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.example.fragmenty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel:BaseViewModel = ViewModelProvider(this)[BaseViewModel::class.java]
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        viewModel.initBase(this, binding)
        binding.viewModel=  viewModel
    }
}