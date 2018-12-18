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

public class Chat extends Activity
{
	private Config config = new Config(this);
	private EditText text_message;
	private Button btn_send, btn_more;
	private ListView list_message;
	private ArrayAdapter adp;
	private List<String> data = new ArrayList<>();
	private SwipeRefreshLayout srl;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		config.load();
		setTheme(config.THEME);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		
		for (int i=1; i<100; i++)
			data.add(String.valueOf(i));
		
		text_message = (EditText)findViewById(R.id.chatEditText);
		btn_send = (Button)findViewById(R.id.chatButton_send);
		btn_more = (Button)findViewById(R.id.chatButton_more);
		list_message = (ListView)findViewById(R.id.chatListView);
		srl = (SwipeRefreshLayout)findViewById(R.id.chatSwipeRefreshLayout);
		
		adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		adp.addAll(data);
		
		list_message.setAdapter(adp);
		
		srl.setColorSchemeResources(android.R.color.holo_blue_dark);
		srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
				@Override
				public void onRefresh()
				{
					Toast.makeText(Chat.this, "Refreshing...", Toast.LENGTH_SHORT).show();
					
					srl.setRefreshing(false);
				}
			});
	}
}
