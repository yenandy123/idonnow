package com.example.idonnow

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idonnow.databinding.ActivityMainBinding
import com.example.idonnow.databinding.ActivityNextPageBinding

class NextPage : AppCompatActivity() ,SensorEventListener{
    private lateinit var binding2: ActivityNextPageBinding
    private lateinit var sensorManger:SensorManager
    private lateinit var light:Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2=ActivityNextPageBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        sensorManger = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        light = sensorManger.getDefaultSensor(Sensor.TYPE_LIGHT)as Sensor

        binding2.button5.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        sensorManger.registerListener(this,light,SensorManager.SENSOR_DELAY_NORMAL)
        super.onResume()
    }
    override fun onPause() {
        sensorManger.unregisterListener(this)
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        when(event?.sensor?.type) {
            Sensor.TYPE_LIGHT -> {
                val x = event.values[0]
                binding2.test.text = x.toString()
                var index:Float=(x/40000)
                binding2.mylayout.setBackgroundColor(Color.rgb(0f,index,index))
                binding2.test.setTextColor(Color.rgb(1-index,0f,1-index))
            }
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }


}