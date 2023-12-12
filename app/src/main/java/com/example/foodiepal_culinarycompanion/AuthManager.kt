package com.example.foodiepal_culinarycompanion

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import android.content.Intent

class AuthManager(private val context:Context) {
    private val STORE = "UserAuth"
    private val USER_NAME = "username"
    private val PASSWORD = "password"
    private var userList = mutableListOf(User("user1","one","user1@gmail.com","password"),
        User("user2","two","user2@gmail.com","password"),
        User("user3","three","user3@gmail.com","password"),
        User("user4","four","user4@gmail.com","password"),
        User("user5","five","user5@gmail.com","password"))

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(STORE, Context.MODE_PRIVATE)

    fun isAuthenticated(): Boolean {
        return sharedPreferences.contains(USER_NAME) && sharedPreferences.contains(PASSWORD)
    }

    fun authenticateUser(context:Context,email: String, password: String): Boolean {
        for(user in userList){
            if(user.userName==email && user.password ==password){
                val editor = sharedPreferences.edit()
                editor.putString(USER_NAME, email)
                editor.putString(PASSWORD, password)
                editor.apply()

                val intent = Intent(context,MainActivity::class.java)
                context.startActivity(intent)
                return true
            }
        }
        Toast.makeText(context,"Invalid User Credential", Toast.LENGTH_LONG).show()
        return false

    }

    fun addNewUser(user:User?){
        if (user!=null) {
            userList.add(user)
        }
    }

    fun handleForgetPassword(context: Context,email:String){
        val user =  userList.find{it.userName==email}
        if(user!=null){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type ="text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL,user.password)
            context.startActivity(Intent.createChooser(intent,"Send Email"))
        }else{
            Toast.makeText(context,"Email not found", Toast.LENGTH_LONG).show()
        }
    }

    fun getAuthenticatedUsername(): String {
        return sharedPreferences.getString(USER_NAME, "") ?: ""
    }

    fun clearAuthentication() {
        val editor = sharedPreferences.edit()
        editor.remove(USER_NAME)
        editor.remove(PASSWORD)
        editor.apply()

        val intent = Intent(context,Login::class.java)
        context.startActivity(intent)


    }
}
