package com.nextskylineproject.next_launch;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;


public class Controller implements SensorEventListener {
	private static final String TAG = "Controller";
	private static volatile Controller instance;
	private SensorManager sensorManager;
	private Sensor accelSensor;
	
	
	private Controller() {
	}
	
	public static Controller New() {
		Controller localInstance = instance;
		if (localInstance == null) {
			synchronized (Controller.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new Controller();
					Log.d(TAG, "New: Create instance");
				}
			}
		}
		return localInstance;
	}
	
	public void init(SensorManager sm) {
		Log.d(TAG, "init: Initialize instance");
		sensorManager = sm;
		accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}
	
	protected void onResume() {
		Log.d(TAG, "onResume: resume");
		sensorManager.registerListener(this, accelSensor, SensorManager.SENSOR_DELAY_NORMAL);
		
	}
	
	protected void onPause() {
		Log.d(TAG, "onPause: pause");
		sensorManager.unregisterListener(this);
	}
	
	@Override
	public void onSensorChanged(SensorEvent sensorEvent) {
	
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {
	
	}
}
