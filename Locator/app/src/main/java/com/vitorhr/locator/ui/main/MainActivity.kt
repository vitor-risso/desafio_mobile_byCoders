package com.vitorhr.locator.ui.main

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.vitorhr.locator.R
import com.vitorhr.locator.databinding.ActivityMainBinding
import com.vitorhr.locator.model.LoginUser
import com.vitorhr.locator.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        MainActivity.context = this

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
    }

    companion object {
        var context: Activity? = null
        var auth: FirebaseAuth? = null
        fun login(loginUser: LoginUser): User? {

            var logedUser: User? = null

            auth!!.signInWithEmailAndPassword(loginUser.email, loginUser.pwd)
                .addOnCompleteListener(context!!) { task ->
                    if (task.isSuccessful) {
                        Log.d("TAG", "signInWithEmail:success")
                        val user = auth!!.currentUser

                        logedUser = User(user!!.email!!, user.uid)
                    }
                }
            return logedUser
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_graph)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}