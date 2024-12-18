package ru.example.fragmenty

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import ru.example.fragmenty.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel:EditViewModel = ViewModelProvider(this)[EditViewModel::class.java]
        val binding:ActivityEditBinding = DataBindingUtil.setContentView(this, R.layout.activity_edit)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        viewModel.initEdit(this, binding)
        binding.viewModel = viewModel




    }
}