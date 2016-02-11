package com.example.doctor_appointment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class page5 extends Activity {
    Spinner spnr;
    
    String[] specialists = {
"Allergist",
"Cardiologist",
"Dermatologist",
"Nephrologist",
"Neurologist",
"Gynecologist",
"Pediatrician",
"Urologis"
    };
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page5);
 
        spnr = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, specialists);
 
        spnr.setAdapter(adapter);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
 
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                            int arg2, long arg3) {
 
                        int position = spnr.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(),"You have selected "+specialists[+position],Toast.LENGTH_LONG).show();
                        // TODO Auto-generated method stub
                    }
 
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub
 
                    }
 
                }
            );
        Button submit;
        submit=(Button)findViewById(R.id.button1);
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i1= new Intent(page5.this,page6.class);
				startActivity(i1);
			}
		});
    }
 
}
	
	

