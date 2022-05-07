package com.example.oneabes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import com.example.oneabes.LoginActivity
import com.example.oneabes.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var binding: FragmentProfileBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view: View = binding!!.root
        binding!!.logout.setOnClickListener { view1: View? ->
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context, LoginActivity::class.java))
        }
        return view
    }
}