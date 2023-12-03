package com.yt.retrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        findViewById<Button>(R.id.btnGet).setOnClickListener {
            getUserById()
        }
        findViewById<Button>(R.id.btnAll).setOnClickListener {
            getAllUsers()
        }
        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            updateUser()
        }
        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            deleteUser()
        }
        findViewById<Button>(R.id.btnPost).setOnClickListener {
            createUser()
        }
    }

    private fun getUserById() {
        lifecycleScope.launch {
            showLoadingDialog("Loading...Please wait...")
            val result = apiService.getUserById("2")
            if (result.isSuccessful) {
                Log.d("oooo", "getUserById Success: ${result.body()}")
            }else {
                Log.d("oooo", "getUserById Fail: ${result.message()}")
            }
            progressDialog.dismiss()
        }
    }

    private fun getAllUsers() {
        lifecycleScope.launch {
            showLoadingDialog("Loading...Please wait...")
            val result = apiService.getUsers()
            if (result.isSuccessful) {
                Log.d("oooo", "getAllUsers Success: ${result.body()}")
            }else {
                Log.d("oooo", "getAllUsers Fail: ${result.message()}")
            }
            progressDialog.dismiss()
        }
    }

    private fun updateUser() {
        lifecycleScope.launch {
            showLoadingDialog("Loading...Please wait...")
            val body = JsonObject().apply {
                addProperty("name", "Ye Thway")
                addProperty("job", "Android Developer")
            }
            val result = apiService.updateUser("2", body)
            if (result.isSuccessful) {
                Log.d("oooo", "updateUser Success: ${result.body()}")
            }else {
                Log.d("oooo", "updateUser Fail: ${result.message()}")
            }
            progressDialog.dismiss()
        }
    }

    private fun deleteUser() {
        lifecycleScope.launch {
            showLoadingDialog("Loading...Please wait...")
            val result = apiService.deleteUser("2")
            if (result.isSuccessful) {
                Log.d("oooo", "deleteUser Success: ${result.body()}")
            }else {
                Log.d("oooo", "deleteUser Fail: ${result.message()}")
            }
            progressDialog.dismiss()
        }
    }

    private fun createUser() {
        lifecycleScope.launch {
            showLoadingDialog("Loading...Please wait...")
            val body = JsonObject().apply {
                addProperty("name", "Ye Thway")
                addProperty("job", "Android Developer")
            }
            val result = apiService.createUser(body)
            if (result.isSuccessful) {
                Log.d("oooo", "createUser Success: ${result.body()}")
            }else {
                Log.d("oooo", "createUser Fail: ${result.message()}")
            }
            progressDialog.dismiss()
        }
    }

    private fun showLoadingDialog(message: String) {
        progressDialog = ProgressDialog.show(this, null, message, true)
    }
}