package com.gencer.movieapp.Fragment.LoginFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gencer.movieapp.R
import com.gencer.movieapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private  var userName:EditText?=null
    private  var password:EditText?=null
    private  var loginBtn:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userName= binding.editTextUser
        password=binding.editTexPassword
        loginBtn=binding.loginBtn

        loginBtn?.setOnClickListener {

            if(userName?.text.toString().isEmpty() || password?.text.toString().isEmpty()) {
                Toast.makeText(context, "Lütfen Kullanıcı Adı ve Şifrenizi Giriniz",Toast.LENGTH_LONG).show()
            }else if(userName?.text.toString().equals("test") && password?.text.toString().equals("test")){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
            }else{
                Toast.makeText(context,"Kullanıcı Adı veya Şifre Yanlış",Toast.LENGTH_LONG).show()
            }
        }

    }

}