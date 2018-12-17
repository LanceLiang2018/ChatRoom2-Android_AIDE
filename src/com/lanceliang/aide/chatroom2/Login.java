package com.lanceliang.aide.chatroom2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.view.View.*;
import android.support.v4.*;
//import android.support.v13.*;
import android.support.v4.widget.*;
import org.json.*;
import android.content.*;

public class Login extends Activity
{
	private Config config = new Config(this);
	private TextView text_username;
	private TextView text_password;
	private Button btn_login;
	private Button btn_signup;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		config.load();
		setTheme(config.THEME);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		//Toast.makeText(this, "Login Activity", Toast.LENGTH_SHORT);
		
		text_username = (TextView)findViewById(R.id.loginEditText_username);
		text_password = (TextView)findViewById(R.id.loginEditText_password);
		btn_login = (Button)findViewById(R.id.loginButton_login);
		btn_signup = (Button)findViewById(R.id.loginButton_signup);
		
		btn_signup.setOnClickListener(new Button.OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					Intent intent = new Intent();
					intent.setClass(Login.this, Signup.class);
					startActivity(intent);
				}
		});
	}
}
