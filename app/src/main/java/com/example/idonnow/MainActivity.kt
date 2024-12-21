package com.example.idonnow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.idonnow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val dataViewModel:DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)









        supportFragmentManager.commit {
            replace(R.id.showfragment,BlankFragment())
        }
        binding.button2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.showfragment,light())
                .commit()

        }
    }
}