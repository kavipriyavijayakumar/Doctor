package com.example.doctor_appointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class page13 extends Activity  {

	Button Back;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page13);
		Back=(Button)findViewById(R.id.button1);
		Back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1= new Intent(page13.this,page11.class);
				startActivity(i1);
			}
		});
	

}
}
