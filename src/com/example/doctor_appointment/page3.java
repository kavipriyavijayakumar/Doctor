package com.example.doctor_appointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class page3 extends Activity 
{
	Button Next;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page3);
		
		Next=(Button)findViewById(R.id.button1);
		Next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1= new Intent(page3.this,page5.class);
				startActivity(i1);
			}
		});
	}


	
}