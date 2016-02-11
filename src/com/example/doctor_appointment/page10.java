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
import android.widget.Toast;


public class page10 extends Activity {
	Button confirm,cancel;
	
		EditText a, b, c, d, e, f, g,h;
		String doctor_name;
		String username;
		String password;
		String confirm_pwd;
		String ph_no;
		String email;
		String experience;
		String specialist;
		

		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.page4);
			a = (EditText) findViewById(R.id.editText1);
			b = (EditText) findViewById(R.id.editText2);
			c = (EditText) findViewById(R.id.editText3);
			d = (EditText) findViewById(R.id.editText4);
			e = (EditText) findViewById(R.id.editText5);
			f = (EditText) findViewById(R.id.editText6);
			
			g = (EditText) findViewById(R.id.editText7);
			h = (EditText) findViewById(R.id.editText8);
			   final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

			cancel = (Button) findViewById(R.id.button2);
			cancel.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i2 = new Intent(page10.this, page8.class);
					startActivity(i2);
				}
			});
			
			 confirm=(Button) findViewById(R.id.button1);
		        confirm.setOnClickListener(new View.OnClickListener() {
		        	

					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						doctor_name=a.getText().toString();
					    username=b.getText().toString();
					    password = c.getText().toString();
						confirm_pwd = d.getText().toString();
						email=e.getText().toString();
						ph_no=f.getText().toString();
						experience=g.getText().toString();
						specialist=h.getText().toString();
						
						
						if(password.equals(confirm_pwd))
						{	
							if("".equalsIgnoreCase(doctor_name) 
								 
								   || "".equalsIgnoreCase(username)
								   || "".equalsIgnoreCase(password)
								   || "".equalsIgnoreCase(confirm_pwd)
								   || "".equalsIgnoreCase(email)
								   || "".equalsIgnoreCase(ph_no)
								   || "".equalsIgnoreCase(experience)
								   || "".equalsIgnoreCase(specialist))
								  
								{
								    Toast.makeText(page10.this, "All Fields Required.", 
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
							doctor_name = URLEncoder.encode(doctor_name, "UTF-8");
							username = URLEncoder.encode(username, "UTF-8");
							password = URLEncoder.encode(password, "UTF-8");
							confirm_pwd = URLEncoder.encode(confirm_pwd, "UTF-8");
							ph_no= URLEncoder.encode(ph_no, "UTF-8");
							specialist = URLEncoder.encode(specialist, "UTF-8");
							experience = URLEncoder.encode(experience, "UTF-8");
							email = URLEncoder.encode(email, "UTF-8");
							
							
							
							String url = "http://10.100.9.191/doctorregister.php?DOCTOR_NAME="+ doctor_name.trim() + "&USERNAME=" + username.trim()+ "&PASSWORD="+ password.trim()+ "&CONFIRM_PASSWORD="+ confirm_pwd.trim()+ "&PHONE_NUMBER="+ ph_no.trim()+ "&EMAILID="+ email.trim()+ "&SPECIALIST="+ specialist.trim()+ "&EXPERIENCE="+ experience.trim();
							System.out.println(url);
							pass_value_to_db get = new pass_value_to_db();
							get.execute(new String[] { url });

						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						Intent i1 = new Intent(page10.this, page9.class);
						startActivity(i1);

					}
				});

			}

			private class pass_value_to_db extends AsyncTask<String, Void, String> {

				ProgressDialog dialog;

				@Override
				protected void onPreExecute() { // TODO Auto-generated method stub
					dialog = new ProgressDialog(page10.this);
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
