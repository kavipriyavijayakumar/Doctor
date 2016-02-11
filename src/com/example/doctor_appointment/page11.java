package com.example.doctor_appointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page11 extends Activity {
	Button Canelappointment,Viewscedule,Updatedetails;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page11);
		Canelappointment=(Button)findViewById(R.id.button1);
		Canelappointment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1= new Intent(page11.this,page12.class);
				startActivity(i1);
			}
		});
		Viewscedule=(Button)findViewById(R.id.button2);
		Viewscedule.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2= new Intent(page11.this,page13.class);
				startActivity(i2);
			}
		});


	}


}
