package com.example.doctor_appointment;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class page4 extends Activity {
	EditText a, b, d, e, f, g, h,i;
	RadioGroup c;
	String patient_name;
	String age;
	String gender;
	String confirm_pwd;
	String ph_no;
	String email;
	String address;
	String pwd;
	String username;
	Button confirm, cancel;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page4);
		a = (EditText) findViewById(R.id.editText1);
		b = (EditText) findViewById(R.id.editText8);
		c = (RadioGroup) findViewById(R.id.radioSex);
		d = (EditText) findViewById(R.id.editText3);
		e = (EditText) findViewById(R.id.editText2);
		f = (EditText) findViewById(R.id.editText4);
		g = (EditText) findViewById(R.id.editText5);
		
		h = (EditText) findViewById(R.id.editText6);
		i = (EditText) findViewById(R.id.editText7);
		   final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

		cancel = (Button) findViewById(R.id.button2);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2 = new Intent(page4.this, MainActivity.class);
				startActivity(i2);
			}
		});
		
		 confirm=(Button) findViewById(R.id.button1);
	        confirm.setOnClickListener(new View.OnClickListener() {
	        	

				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					patient_name=a.getText().toString();
				    age=b.getText().toString();
				    gender = c.getContext().toString();
					pwd = d.getText().toString();
					username=e.getText().toString();
					confirm_pwd=f.getText().toString();
					ph_no=g.getText().toString();
					email=h.getText().toString();
					address=i.getText().toString();
					
					if(pwd.equals(confirm_pwd))
					{	
						if("".equalsIgnoreCase(patient_name) 
							 
							   || "".equalsIgnoreCase(age)
							   || "".equalsIgnoreCase(gender)
							   || "".equalsIgnoreCase(username)
							   || "".equalsIgnoreCase(pwd)
							   || "".equalsIgnoreCase(confirm_pwd)
							   || "".equalsIgnoreCase(ph_no)
							   || "".equalsIgnoreCase(email)
							   || "".equalsIgnoreCase(address))
							  
							{
							    Toast.makeText(page4.this, "All Fields Required.", 
							         Toast.LENGTH_SHORT).show();
							}
						else
						{
							Toast.makeText(getApplicationContext(),"Registered successfully. . .",Toast.LENGTH_SHORT).show();
						}
					}
						else
						{
							Toast.makeText(getApplicationContext(), "Passwords donot match", Toast.LENGTH_SHORT).show();
						}
				
					h .addTextChangedListener(new TextWatcher() { 
					    public void afterTextChanged(Editable s) { 

					    if (email.matches(emailPattern) && s.length() > 0)
					        { 
					            Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
					          
					        }
					        else
					        {
					             Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
					          
					        }
					    } 
					    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
					    // other stuffs 
					    } 
					    public void onTextChanged(CharSequence s, int start, int before, int count) {
					    // other stuffs 
					    } 
					}); 
					
				
					try {
						patient_name = URLEncoder.encode(patient_name, "UTF-8");
						age = URLEncoder.encode(age, "UTF-8");
						gender = URLEncoder.encode(gender, "UTF-8");
						username = URLEncoder.encode(username, "UTF-8");
						pwd= URLEncoder.encode(pwd, "UTF-8");
						confirm_pwd = URLEncoder.encode(confirm_pwd, "UTF-8");
						ph_no = URLEncoder.encode(ph_no, "UTF-8");
						email = URLEncoder.encode(email, "UTF-8");
						address = URLEncoder.encode(address, "UTF-8");
						
						
						String url = "http://10.100.9.191/patientregister.php?PATIENT_NAME="+ patient_name.trim() + "&AGE="+ age.trim() + "&GENDER=" + gender.trim() + "&USERNAME=" + username.trim()+ "&PASSWORD="+ pwd.trim()+ "&CONFIRM_PWD="+ confirm_pwd.trim()+ "&PHONE_NO="+ ph_no.trim()+ "&EMAILID="+ email.trim()+ "&ADDRESS="+ address.trim();
						System.out.println(url);
						pass_value_to_db get = new pass_value_to_db();
						get.execute(new String[] { url });

					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Intent i1 = new Intent(page4.this, page2.class);
					startActivity(i1);

				}
			});

		}

		private class pass_value_to_db extends AsyncTask<String, Void, String> {

			ProgressDialog dialog;

			@Override
			protected void onPreExecute() { // TODO Auto-generated method stub
				dialog = new ProgressDialog(page4.this);
				dialog.setTitle("Processing...");
				dialog.setMessage("Please wait.");
				dialog.setCancelable(false);
				dialog.show();
			}

			@Override
			protected String doInBackground(String... urls) {
				String result = "";
				for (String url : urls) {
					InputStream is = null;
					try {

						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httppost = new HttpPost(url);
						HttpResponse response = httpclient.execute(httppost);
						int status = response.getStatusLine().getStatusCode();
						Log.d("KG", "status=" + status);

						if (status == 200) {
							HttpEntity entity = response.getEntity();
							is = entity.getContent();
							BufferedReader reader = new BufferedReader(
									new InputStreamReader(is, "iso-8859-1"), 8);
							String line = "";
							while ((line = reader.readLine()) != null) {
								result += line;
							}
							is.close();

							Log.v("KG", result);

						}
					} catch (Exception ex) {
						Log.e("Error", ex.toString());
					}
					
					//Toast.makeText(getApplicationContext(),"Registered successfully", Toast.LENGTH_LONG).show();
					//Intent i=new Intent(SubActivity.this,MainActivity.class);
					//startActivity(i);
				}
				return result;
			}

			protected void onPostExecute(String result) {
				Log.v("KG", "output=" + result);
				result = result.trim(); //
				// Toast.makeText(getApplicationContext(), result, //
				// Toast.LENGTH_LONG).show();
				if (result.equals("false")) {

					// *******************************************************

					Toast.makeText(getApplicationContext(),
							" Please try again later...", Toast.LENGTH_SHORT).show();
				} else {
					System.out.println(result);

				}

				if (dialog != null)
					dialog.dismiss();

			}
		}
@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	    }
