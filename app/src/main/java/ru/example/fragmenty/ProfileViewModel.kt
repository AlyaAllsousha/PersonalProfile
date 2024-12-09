package ru.example.fragmenty

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.example.fragmenty.databinding.ProfileActivityBinding

class ProfileViewModel: ViewModel() {
    var activity:AppCompatActivity?= null
    var binding:ProfileActivityBinding? = null
    var launcher2:ActivityResultLauncher<PickVisualMediaRequest>? = null
    val imgUriMutable = MutableLiveData<Uri>()
    val achi = AchievArray()
    val achievArray = MutableLiveData<ArrayList<Achievments>>(achi.gelList())
    val adapter = achievArray.value?.let { AchievmentsAdapter(it) }

    fun initProf(activity: AppCompatActivity,binding: ProfileActivityBinding){
        this.activity = activity
        this.binding = binding
        binding.RV.adapter = adapter
        binding.imgProf.setImageURI(imgUriMutable.value)
        launcher2 = activity.registerForActivityResult(
                ActivityResultContracts.PickVisualMedia(),
                ActivityResultCallback {
                    var uriImg = it
                    imgUriMutable.value = it
                    binding.imgProf.setImageURI(uriImg)
                }

            )



    }

    fun ClickBack(){
        activity?.finish()
    }
    fun clickImg(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        launcher2?.launch(
            PickVisualMediaRequest(
                ActivityResultContracts.PickVisualMedia.ImageOnly
            )
        )

    }
    fun clickNum(){
        val uri = Uri.parse("tel:89196431223")
        val intent = Intent(Intent.ACTION_DIAL, uri)
        activity?.startActivity(intent)
    }
    fun clickMail(){
        val uri = Uri.parse("mailto:")
        val address = arrayOf("arnold@mail.ru")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra(Intent.EXTRA_EMAIL, address)
        intent.putExtra(Intent.EXTRA_SUBJECT, "реклама протеиновых батончиков")
        intent.putExtra(Intent.EXTRA_TEXT, "бла бла бла")
        activity?.startActivity(intent)
    }


}