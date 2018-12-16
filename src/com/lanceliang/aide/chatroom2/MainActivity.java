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


public class MainActivity extends Activity
{
	private List<String> data = new ArrayList<>();
	private SwipeRefreshLayout srl;
	private ListView list;
	private ArrayAdapter adp;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		setTheme(android.R.style.Theme_Material);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		list = (ListView)findViewById(R.id.list_rooms);
		
		for (int i=1; i <= 100; i++)
			data.add(String.valueOf(i));

		adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
		list.setAdapter(adp);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					//startActivity(R);
					//Toast.makeText(MainActivity.this, data.get(p3), Toast.LENGTH_SHORT).show();
				}
			});
		
		srl = (SwipeRefreshLayout)findViewById(R.id.slr);
		srl.setEnabled(true);
		//srl.setRefreshing(true);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.option_exit:
				this.finish();
				break;
			case R.id.option_about:
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("关于");
				builder.setMessage(R.string.about);
				builder.show();
				break;
			case R.id.option_login:
				//this.startActivity();
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Login.class);
				/*
				Bundle bundle=new Bundle();
				bundle.putString("data", "data");
				intent.putExtras(bundle);*/
				startActivityForResult(intent, 0);
				break;
			default:
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
/*
private ListView.OnClickListener ListListener = new ListView.OnClickListener()
{
	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
		Toast.makeText(this, "EEE", Toast.LENGTH_SHORT).show();
	}
}
*/
