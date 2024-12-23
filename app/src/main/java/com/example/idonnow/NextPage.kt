package com.example.idonnow

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idonnow.databinding.ActivityMainBinding

class NextPage : AppCompatActivity() ,SensorEventListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var sensorManger:SensorManager
    private lateinit var lightsensor:Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManger = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        lightsensor = sensorManger.getDefaultSensor(Sensor.TYPE_LIGHT)as Sensor
    }

    override fun onResume() {
        sensorManger.registerListener(this,lightsensor,SensorManager.SENSOR_DELAY_NORMAL)
        super.onResume()
    }
    override fun onPause() {
        sensorManger.unregisterListener(this)
        super.onPause()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        TODO("Not yet implemented")
    when(event?.sensor?.type){

    }


    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }
}