package com.example.methodchanneldemo_sample1

import io.flutter.plugins.batteryinfoApi

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.util.Log
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.getSystemService
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.batteryinfoApi.BatteryInfo
import io.flutter.plugins.batteryinfoApi.BatteryInfoApi

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        batteryinfoApi.BatteryInfoApi.setup(flutterEngine.dartExecutor.binaryMessenger, MyDeviceInformation(applicationContext))
    }
}

class MyDeviceInformation(private val context: Context) : BatteryInfoApi {

    override fun getbatteryInformation(): BatteryInfo {
        val batteryLevel: Int
        val batteryInfo = BatteryInfo()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
            batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            Log.e("getBatteryLevel: ", batteryLevel.toString())
            batteryInfo.batteryPercentage = batteryLevel.toString()
        } else {
            val intent = ContextWrapper(context.applicationContext).registerReceiver(
                null,
                IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            )
            batteryLevel =
                intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) * 100 / intent.getIntExtra(
                    BatteryManager.EXTRA_SCALE,
                    -1
                )
            batteryInfo.batteryPercentage = batteryLevel.toString()
        }

        return batteryInfo
    }
}
