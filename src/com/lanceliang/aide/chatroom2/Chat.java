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
import android.util.*;
import android.content.res.Resources.*;
import android.graphics.*;
import android.graphics.drawable.*;

public class Chat extends Activity
{
	private Config config = new Config(this);
	private EditText text_message;
	private Button btn_send, btn_more;
	private ListView list_message;
	private ArrayAdapter adp;
	private List<String> data = new ArrayList<>();
	private SwipeRefreshLayout srl;
	private String gid = "0";
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		config.load();
		setTheme(config.THEME);
		//getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		

		super.onCreate(savedInstanceState);
		
		Bundle bundle = getIntent().getExtras();
		gid = bundle.getString("gid");
		
		try {
			setContentView(R.layout.chat);
			
			ActionBar bar = getActionBar();
			bar.setDisplayHomeAsUpEnabled(true);
			bar.setTitle((CharSequence)bundle.getString("name"));
			
			int color = Color.parseColor("#FFC03546");
			ColorDrawable drawable = new ColorDrawable(color);
			bar.setBackgroundDrawable(drawable);
		}
		catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}

		text_message = (EditText)findViewById(R.id.chatEditText);
		btn_send = (Button)findViewById(R.id.chatButton_send);
		btn_more = (Button)findViewById(R.id.chatButton_more);
		list_message = (ListView)findViewById(R.id.chatListView);
		srl = (SwipeRefreshLayout)findViewById(R.id.chatSwipeRefreshLayout);
		
		adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		
		for (int i=1; i<100; i++)
			data.add(String.valueOf(i));
		
		Collections.reverse(data);
		
		adp.addAll(data);
		
		list_message.setAdapter(adp);
		
		srl.setColorSchemeResources(android.R.color.holo_blue_dark);
		srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
				@Override
				public void onRefresh()
				{
					Toast.makeText(Chat.this, "Refreshing...", Toast.LENGTH_SHORT).show();
					adp.insert("ReFresh", 0);
					//adp.add("Ref...");
					adp.notifyDataSetChanged();
					//adp.notifyDataSetInvalidated();
					srl.setRefreshing(false);
				}
			});
	}
}
