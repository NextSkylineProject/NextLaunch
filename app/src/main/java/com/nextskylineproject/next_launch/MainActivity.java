package com.nextskylineproject.next_launch;

import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";
	private Controller controller;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		controller = Controller.New();
		controller.init((SensorManager) getSystemService(SENSOR_SERVICE));
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		controller.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		controller.onPause();
	}
	
	
}