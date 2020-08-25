package com.example.thingstodoapp.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.thingstodoapp.R
import kotlinx.android.synthetic.main.fragment_login.*

class SplashFragment : Fragment() {

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        logo.animate().apply {
            duration = 1000
            rotationYBy(360f)
        }.withEndAction {
            logo.animate().apply {
                duration = 1000
                rotationYBy(0f)
            }.start()
        }
        Handler().postDelayed({
            navController?.navigate(R.id.action_splashFragment_to_loginFragment)
        }, 2000)


    }
}