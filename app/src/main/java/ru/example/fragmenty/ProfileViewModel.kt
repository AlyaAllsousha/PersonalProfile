package ru.example.fragmenty

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import ru.example.fragmenty.databinding.ProfileActivityBinding

class ProfileViewModel: ViewModel() {
    var activity:AppCompatActivity?= null
    var binding:ProfileActivityBinding? = null

    fun initProf(activity: AppCompatActivity,binding: ProfileActivityBinding){
        this.activity = activity
        this.binding = binding
    }
    fun ClickBack(){
        activity?.finish()
    }


}