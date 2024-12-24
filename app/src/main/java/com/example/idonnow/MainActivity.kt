package com.example.idonnow

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.idonnow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val dataViewModel:DataViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(R.id.showfragment, BlankFragment())
        }
        binding.button3.setOnClickListener {
            val p = Person()
            p.name = binding.editName.text.toString()
            p.pwd = binding.editpwd.text.toString()
            dataViewModel.setPerson(p)
        }
        binding.button.setOnClickListener {
            val intent = Intent(this, Gsensor::class.java)
            startActivity(intent)

            binding.button2.setOnClickListener {
                val intent = Intent(this, NextPage::class.java)
                startActivity(intent)
            }
        }


    }
}
