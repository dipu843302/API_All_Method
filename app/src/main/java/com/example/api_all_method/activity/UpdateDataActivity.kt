package com.example.api_all_method.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.api_all_method.R
import com.example.api_all_method.api.ApiInterface
import com.example.api_all_method.api.Network
import com.example.api_all_method.model.UserUpdate
import com.example.api_all_method.repository.MyRepository
import com.example.api_all_method.viewModel.MyViewModel
import com.example.api_all_method.viewModel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_updata_data.*

class UpdateDataActivity : AppCompatActivity() {

    lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updata_data)

        val intent= intent
        etName2.setText(intent.getStringExtra("name"))
        etEmail2.setText(intent.getStringExtra("email"))
        etStatus2.setText(intent.getStringExtra("status"))
        val id=intent.getIntExtra("id",0)

        val api= Network.getRetrofitInstance().create(ApiInterface::class.java)
        val repository= MyRepository(api)

        viewModel= ViewModelProvider(this, MyViewModelFactory(repository)).get(MyViewModel::class.java)

        update.setOnClickListener{
            val userUpdate=UserUpdate(etName2.text.toString(),etStatus2.text.toString(),etEmail2.text.toString())
            viewModel.userUpdate(id,userUpdate)
            Toast.makeText(this, "Updated successfully", Toast.LENGTH_SHORT).show()
            Log.d("update", id.toString())
            onBackPressed()
        }


    }
}