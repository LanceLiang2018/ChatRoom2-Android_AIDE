package com.lanceliang.aide.chatroom2;
import android.net.*;
import android.app.*;
import android.content.*;
import java.net.*;
import java.io.*;
import java.util.*;
import android.widget.*;

public class CommunicationService
{
	public String SERVER = "http://0.0.0.0:5000";
	public int TIMEOUT = 20000;
	public int CommVer = 1;
	public String MAIN = "",
	ABOUT = "about",
	BEAT = "beat",
	LOGIN = "login",
	SIGNUP = "signup",
	GET_MESSAGE = "get_message",
	SEND_MESSAGE = "send_messsage",
	CLEAR_ALL = "clear_all",

	SET_USER = "set_user",
	JOIN_IN = "join_in",

	CREATE_ROOM = "create_room",
	SET_ROOM = "set_room",
	GET_ROOMS = "get_room_all",
	GET_ROOM_INFO = "get_room_info",
	SET_ROOM_INFO = "set_room_info",
	GET_MEMBERS = "get_room_members";

	CommunicationService(String url)
	{
		this.SERVER = url;
	}

	CommunicationService()
	{}

	public static boolean isOnline(Activity act)
	{
		ConnectivityManager conn = (ConnectivityManager)act.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = conn.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnected())
			return true;
		else return false;
	}

	public boolean post(HashMap<String, String> postParameters) throws Exception
	{
		android.util.Log.d("posting", "started");
		String str = "ver=" + URLEncoder.encode(String.valueOf(CommVer), "UTF-8");
		for (String key : postParameters.keySet())
		{
			str += "&" + key + "=" + URLEncoder.encode(postParameters.get(key), "UTF-8");
		}

		URL url = new URL(SERVER);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(TIMEOUT);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setFixedLengthStreamingMode(str.getBytes().length);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		PrintWriter out = new PrintWriter(conn.getOutputStream());
		out.print(str);
		out.close();
		return true;
	}
	public void test() throws Exception
	{
		HashMap<String, String> argc = null;
		argc.put("tt", "tt");
		post(argc);
	}
}
