package ru.example.fragmenty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.example.fragmenty.databinding.ActivityMainBinding

class BaseViewModel:ViewModel() {
    var activity:AppCompatActivity? = null
    var binding:ActivityMainBinding? = null
fun initBase(activity: AppCompatActivity, binding: ActivityMainBinding){
    this.activity = activity
    this.binding = binding
}
    fun onProfileclick(){
        val intent = Intent(activity,ProfileActivity::class.java )
        activity?.startActivity(intent)

    }
}