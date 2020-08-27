package com.example.thingstodoapp.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.thingstodoapp.R
import com.example.thingstodoapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var fragmentLoginBinding: FragmentLoginBinding? = null
    var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val binding = FragmentLoginBinding.bind(view)
        fragmentLoginBinding = binding
        fragmentLoginBinding!!.logintofacebook.setOnClickListener {
            navController?.navigate(R.id.action_splashFragment_to_homePageActivity)
        }
    }
}