package com.vitorhr.locator.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vitorhr.locator.R
import com.vitorhr.locator.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

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
            viewModel = LoginViewModel()
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}