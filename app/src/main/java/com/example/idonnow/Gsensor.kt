package com.example.idonnow

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idonnow.databinding.ActivityGsensorBinding

class Gsensor : AppCompatActivity() ,SensorEventListener {
    private lateinit var binding3: ActivityGsensorBinding
    private lateinit var sensorManger2: SensorManager
    private lateinit var mySensor: Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivityGsensorBinding.inflate(layoutInflater)
        setContentView(binding3.root)

        sensorManger2 = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mySensor = sensorManger2.getDefaultSensor(Sensor.TYPE_GYROSCOPE) as Sensor

        binding3.button4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


        override fun onResume() {
            sensorManger2.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL)
            super.onResume()
        }

        override fun onPause() {
            sensorManger2.unregisterListener(this)
            super.onPause()
        }

        override fun onSensorChanged(event: SensorEvent?) {
            //TODO("Not yet implemented")
            when (event?.sensor?.type) {
                Sensor.TYPE_ACCELEROMETER -> {}
                Sensor.TYPE_GYROSCOPE -> {
                    val x = event.values[0]
                    val y = event.values[1]
                    val z = event.values[2]

                    binding3.a.text = x.toString()
                    binding3.b.text = y.toString()
                    binding3.c.text = z.toString()
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            //TODO("Not yet implemented")
        }
    }
