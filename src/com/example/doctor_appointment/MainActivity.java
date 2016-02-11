package com.example.doctor_appointment;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button doctor,patient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doctor=(Button)findViewById(R.id.button1);
		doctor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(MainActivity.this,page8.class);
				startActivity(i);
				
			}
		});
	patient= (Button)findViewById(R.id.button2);
	patient.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i1= new Intent(MainActivity.this,page1.class);
			startActivity(i1);
			
		}
	});
		
	

}
}

		

