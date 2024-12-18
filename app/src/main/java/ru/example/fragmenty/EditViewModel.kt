package ru.example.fragmenty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ru.example.fragmenty.databinding.ActivityEditBinding

class EditViewModel:ViewModel() {
var activity:AppCompatActivity? = null
var binding:ActivityEditBinding? = null
fun initEdit(activity:AppCompatActivity, binding: ActivityEditBinding){
    this.activity = activity
    this.binding = binding
}
fun onSubmit(){
    val intent = Intent()
    intent.putExtra("New name", binding?.edit?.text.toString())
    activity?.setResult(0, intent)
    activity?.finish()
}
}
