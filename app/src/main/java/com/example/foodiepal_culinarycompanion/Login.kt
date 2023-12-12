package com.example.foodiepal_culinarycompanion

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.foodiepal_culinarycompanion.databinding.ActivityLoginBinding

class Login  : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val authManager = AuthManager(this)

        if(authManager.isAuthenticated()){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            return
        }
        binding.signInBtn.setOnClickListener{
            authManager.authenticateUser(this,binding.email.text.toString(),binding.password.text.toString())
        }

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { res ->
            if(res.resultCode== Activity.RESULT_OK){
                var user = res.data?.getSerializableExtra("new_user") as? User
                authManager.addNewUser(user)
            }
        }

        binding.registerBtn.setOnClickListener{
            val intent = Intent(this,Register::class.java)
            resultLauncher.launch(intent)
        }

        binding.forgotPasswordBtn.setOnClickListener{
            authManager.handleForgetPassword(this,binding.email.text.toString())

        }
    }}