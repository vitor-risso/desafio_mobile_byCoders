package com.vitorhr.locator.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vitorhr.locator.R
import com.vitorhr.locator.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentLoginBinding?>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        ).apply {
            viewModel = loginViewModel
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}