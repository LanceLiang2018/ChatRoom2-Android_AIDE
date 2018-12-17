package com.lanceliang.aide.chatroom2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Signup extends Activity
{
	private Config config = new Config(this);
	private Button btn;
	private EditText text_username;
	private EditText text_password;
	private EditText text_email;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		config.load();
		setTheme(config.THEME);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		btn = (Button)findViewById(R.id.signupButton_signup);
		text_username = (EditText)findViewById(R.id.signupEditText_username);
		text_password = (EditText)findViewById(R.id.signupEditText_password);
		text_email = (EditText)findViewById(R.id.signupEditText_email);
		
		btn.setOnClickListener(new Button.OnClickListener(){
				@Override
				public void onClick(View p1){
					Toast.makeText(Signup.this, "TODO: Sign up " + String.valueOf(text_username.getText()), Toast.LENGTH_SHORT).show();
				}
		});
	}
	
}

