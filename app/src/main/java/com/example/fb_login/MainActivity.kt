package com.example.fb_login

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fb_login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.sw.setOnCheckedChangeListener(this)


        binding.btn1.setOnClickListener {
            val userName = binding.edtext1.text.toString()
            val password = binding.edtext2.text.toString()
            fun reset(){
                binding.edtext1.text = null
                binding.edtext2.text = null
            }
            if (userName.isEmpty() && password.isEmpty()){
                Toast.makeText(this@MainActivity, "Please enter your username/Phone and Password", Toast.LENGTH_SHORT).show()
                reset()
            }
            else if (userName.isEmpty() && password.isNotEmpty()){
                Toast.makeText(this@MainActivity, "Please enter your username/Phone", Toast.LENGTH_SHORT).show()
                reset()
            }
            else if (userName.isNotEmpty() && password.isEmpty()){
                Toast.makeText(this@MainActivity, "Please Enter your password", Toast.LENGTH_SHORT).show()
                reset()
            }
            else{
                Toast.makeText(this@MainActivity, "Log in successful", Toast.LENGTH_SHORT).show()
                reset()
            }

        }


    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when(p1){
            true -> binding.main.setBackgroundResource(R.drawable.bg2)
            else -> binding.main.setBackgroundResource(R.drawable.gradianbg)
        }
    }

}
