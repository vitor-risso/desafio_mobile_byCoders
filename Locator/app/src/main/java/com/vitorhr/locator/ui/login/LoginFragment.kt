package com.vitorhr.locator.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.vitorhr.locator.R
import com.vitorhr.locator.databinding.FragmentLoginBinding
import com.vitorhr.locator.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentLoginBinding?>(
            inflater, R.layout.fragment_login, container, false
        ).apply {
            viewModel = loginViewModel
        }
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        loginViewModel.didLoginButtonClick.observe(viewLifecycleOwner) { loginUser ->
            Log.d("TAG", "LoginFragment login")
            val logedUser = MainActivity.login(loginUser)
            logedUser?.let {}
        }
    }
}