package com.example.api_all_method.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_all_method.R
import com.example.api_all_method.adapter.ItemClick
import com.example.api_all_method.adapter.RecyclerViewAdapter
import com.example.api_all_method.api.ApiInterface
import com.example.api_all_method.api.Network
import com.example.api_all_method.model.User
import com.example.api_all_method.repository.MyRepository
import com.example.api_all_method.viewModel.MyViewModel
import com.example.api_all_method.viewModel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClick {

    lateinit var viewModel: MyViewModel
    private val dataList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreateContact.setOnClickListener {
            startActivity(Intent(this, CreateNewUser::class.java))
        }

        setUpViewModel()
        getTheData()
    }

    private fun setUpViewModel() {
       val api = Network.getRetrofitInstance().create(ApiInterface::class.java)
        val repository = MyRepository(api)
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(repository)).get(MyViewModel::class.java)
    }

    private fun getTheData() {
        viewModel.get().observe(this, Observer {
            it.let {
                dataList.clear()
                dataList.addAll(it)
                setRecyclerView()
            }
        })
    }

    private fun setRecyclerView() {
        recyclerView.adapter = RecyclerViewAdapter(dataList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun deleteData(id: Int) {
        viewModel.deleteData(id)
        viewModel.callData()
    }

    override fun updateTheData(user: User) {
        val intent = Intent(this, UpdateDataActivity::class.java)
        intent.putExtra("name", user.name)
        intent.putExtra("email", user.email)
        intent.putExtra("status", user.status)
        intent.putExtra("id", user.id)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        viewModel.callData()

    }
}