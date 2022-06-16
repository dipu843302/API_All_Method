package com.example.api_all_method.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.api_all_method.R
import com.example.api_all_method.api.ApiInterface
import com.example.api_all_method.api.Network
import com.example.api_all_method.model.User
import com.example.api_all_method.repository.MyRepository
import com.example.api_all_method.viewModel.MyViewModel
import com.example.api_all_method.viewModel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_create_new_user.*

class CreateNewUser : AppCompatActivity() {

    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)

        val api = Network.getRetrofitInstance().create(ApiInterface::class.java)
        val repository = MyRepository(api)

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(repository)).get(MyViewModel::class.java)

        btnSubmit.setOnClickListener {
            val gender = etGender.text.toString()
            val status = etStatus.text.toString()
            if ((gender == "male" || gender == "female") && (status == "active" || status == "inactive")) {
                val user = User(
                    email = etEmail.text.toString(),
                    gender = gender,
                    name = etName.text.toString(),
                    status = status

                )
                viewModel.createUser(user)
                Toast.makeText(this, "Created successfully", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Invalid details", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.getResult().observe(this) {
            val data = it.id
            Log.d("created", data.toString())
            onBackPressed()
        }
    }


}