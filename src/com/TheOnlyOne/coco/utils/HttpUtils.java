package com.TheOnlyOne.coco.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.util.Log;

import com.TheOnlyOne.coco.bean.ChatMessage;
import com.TheOnlyOne.coco.bean.ChatMessage.MsgType;

public class HttpUtils {

	private static final String URL = "http://www.tuling123.com/openapi/api";
	private static final String API_KEY = "ee9e3eb8469dc32c05d20fafe252c8c2";
	private static final String HTTPUTIL_TAG="httputil_tag";
	public static final String Split="######";

	private static final String JSONNODE_LIST="list";
	
	//文字类
	private static final String JSONNODE_TEXT_TEXT="text";
	
	private static final String JSONNODE_FILM_NAME="name";
	private static final String JSONNODE_FILM_INFO="info";
	private static final String JSONNODE_FILM_DETAILURL="detailurl";
	private static final String JSONNODE_FILM_ICON="icon";
		
	//链接类
	private static final String JSONNODE_LINK_TEXT="text";
	private static final String JSONNODE_LINK_DETAILURL="url";
	
	//小说类
	private static final String JSONNODE_NOVEL_TEXT="text";
	private static final String JSONNODE_NOVEL_NAME="name";
	private static final String JSONNODE_NOVEL_AUTHOR="author";
	private static final String JSONNODE_NOVEL_DETAILURL="detailurl";
	private static final String JSONNODE_NOVEL_ICON="icon";
	
	//新闻类
	private static final String JSONNODE_NEWS_TEXT="text";
	private static final String JSONNODE_NEWS_ARTICLE="article";
	private static final String JSONNODE_NEWS_SOURCE="source";
	private static final String JSONNODE_NEWS_DETAILURL="detailurl";
	private static final String JSONNODE_NEWS_ICON="icon";
	
	//下载类
	private static final String JSONNODE_DOWNLOAD_TEXT="text";
	private static final String JSONNODE_DOWNLOAD_NAME="name";
	private static final String JSONNODE_DOWNLOAD_COUNT="count";
	private static final String JSONNODE_DOWNLOAD_DETAILURL="detailurl";
	private static final String JSONNODE_DOWNLOAD_ICON="icon";
	
	//列车类
	private static final String JSONNODE_TRAIN_TEXT="text";
	private static final String JSONNODE_TRAIN_TRAINNUM="trainnum";
	private static final String JSONNODE_TRAIN_START="start";
	private static final String JSONNODE_TRAIN_TERMINAL="terminal";
	private static final String JSONNODE_TRAIN_STARTTIME="starttime";
	private static final String JSONNODE_TRAIN_EMDTIME="endtime";
	private static final String JSONNODE_TRAIN_DETAILURL="detailurl";
	private static final String JSONNODE_TRAIN_ICON="icon";
	
	//航班类
	private static final String JSONNODE_FLIGHT_TEXT="text";
	private static final String JSONNODE_FLIGHT_FLIGHT="flight";
	private static final String JSONNODE_FLIGHT_ROUTE="route";
	private static final String JSONNODE_FLIGHT_STARTTIME="starttime";
	private static final String JSONNODE_FLIGHT_EMDTIME="endtime";
	private static final String JSONNODE_FLIGHT_STATE="state";
	private static final String JSONNODE_FLIGHT_DETAILURL="detailurl";
	private static final String JSONNODE_FLIGHT_ICON="icon";
	
	//酒店类
	private static final String JSONNODE_HOTEL_TEXT="text";
	private static final String JSONNODE_HOTEL_NAME="name";
	private static final String JSONNODE_HOTEL_PRICE="price";
	private static final String JSONNODE_HOTEL_SATISFACTION="satisfaction";
	private static final String JSONNODE_HOTEL_COUNT="count";
	private static final String JSONNODE_HOTEL_DETAILURL="detailurl";
	private static final String JSONNODE_HOTEL_ICON="icon";
	
	//餐厅类
	private static final String JSONNODE_RESTAURANT_TEXT="text";
	private static final String JSONNODE_RESTAURANT_NAME="name";
	private static final String JSONNODE_RESTAURANT_PRICE="price";
	private static final String JSONNODE_RESTAURANT_ICON="icon";
	private static final String JSONNODE_RESTAURANT_DETAILURL="detailurl";
	
	
	
	private static final int CODE_TEXT=100000;
	private static final int CODE_LINK=200000;
	private static final int CODE_NOVEL=301000;
	private static final int CODE_NEWS=302000;
	private static final int CODE_DOWNLOAD=304000;
	private static final int CODE_TRAIN=305000;
	private static final int CODE_FLIGHT=306000;
	private static final int CODE_RESTAURANT=312000;
	private static final int CODE_HOTEL=309000;
	private static final int CODE_FILM=308000;
	private static final int CODE_Exception1=40001;
	private static final int CODE_Exception2=40002;
	private static final int CODE_Exception3=40003;
	private static final int CODE_Exception4=40004;
	private static final int CODE_Exception5=40005;
	private static final int CODE_Exception6=40006;
	private static final int CODE_Exception7=40007;
	
	/**
	 * 发送一个消息，得到返回的消息
	 * @param msg
	 * @return
	 * @throws JSONException 
	 */
	public static ChatMessage sendMessage(String msg) 
			throws JSONException{
		String jsonRes = doGet(msg);
		Log.i(HTTPUTIL_TAG, jsonRes);
		JSONObject jsonObj =new JSONObject(jsonRes);
		int code_index=jsonObj.getInt("code");
		return getChatMessage(code_index,msg);
	}
	
	private static ChatMessage getChatMessage(int code_index,String msg) throws JSONException{
		Date date =new Date();
		switch(code_index){

		case CODE_Exception1:
			String CODE_Exception1_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage CODE_Exception1_chatMessage=new ChatMessage(CODE_Exception1_text, 
					MsgType.INCOMING, date);
			return CODE_Exception1_chatMessage;

		case CODE_Exception2:
			String CODE_Exception2_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage CODE_Exception2_chatMessage=new ChatMessage(CODE_Exception2_text, 
					MsgType.INCOMING, date);
			return CODE_Exception2_chatMessage;

		case CODE_Exception3:
			String CODE_Exception3_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage CODE_Exception3_chatMessage=new ChatMessage(CODE_Exception3_text, 
					MsgType.INCOMING, date);
			return CODE_Exception3_chatMessage;

		case CODE_Exception4:
			String CODE_Exception4_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage CODE_Exception4_chatMessage=new ChatMessage(CODE_Exception4_text, 
					MsgType.INCOMING, date);
			return CODE_Exception4_chatMessage;

		case CODE_Exception5:
			String CODE_Exception5_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage CODE_Exception5_chatMessage=new ChatMessage(CODE_Exception5_text, 
					MsgType.INCOMING, date);
			return CODE_Exception5_chatMessage;

		case CODE_Exception6:
			String CODE_Exception6_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage CODE_Exception6_chatMessage=new ChatMessage(CODE_Exception6_text, 
					MsgType.INCOMING, date);
			return CODE_Exception6_chatMessage;

		case CODE_Exception7:
			String CODE_Exception7_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage CODE_Exception7_chatMessage=new ChatMessage(CODE_Exception7_text, 
					MsgType.INCOMING, date);
			return CODE_Exception7_chatMessage;
			
		case CODE_TEXT:
			String text_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			ChatMessage text_chatMessage=new ChatMessage(text_text, 
					MsgType.INCOMING, date);
			return text_chatMessage;
		case CODE_FILM:
			String film_text=getStringFromJson(JSONNODE_TEXT_TEXT,msg);
			String film_name=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_NAME, msg, 0)+Split+
					getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_NAME, msg, 1);
			String film_info=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_INFO, msg, 0)+Split+
					getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_INFO, msg, 1);
			String film_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_DETAILURL, msg, 0)+Split+
					getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_DETAILURL, msg, 1);
			String film_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_ICON, msg, 0)+Split+
					getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FILM_ICON, msg, 1);
			ChatMessage film_chatMessage=new ChatMessage(date, film_text, film_name, film_info, 
					film_detailurl, film_icon, MsgType.FILM);
			return film_chatMessage;
		case CODE_LINK:
			String link_text=getStringFromJson(JSONNODE_LINK_TEXT, msg);
			String link_url=getStringFromJson(JSONNODE_LINK_DETAILURL, msg);
			ChatMessage link_chatMessage=new ChatMessage(link_text, link_url, date, MsgType.LINK);
			return link_chatMessage;
		case CODE_NOVEL:
			String novel_text=getStringFromJson(JSONNODE_NOVEL_TEXT, msg);
			String novel_name=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NOVEL_NAME, msg, 0)+Split+
					getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NOVEL_NAME, msg, 1);
			String novel_author=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NOVEL_AUTHOR, msg, 0)+Split+
					getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NOVEL_AUTHOR, msg, 1);
			String novel_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NOVEL_DETAILURL, msg, 0)+Split+
					getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NOVEL_DETAILURL, msg, 1);
			String novel_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NOVEL_ICON, msg, 0);
			ChatMessage novel_chatMessage=new ChatMessage(date, novel_text, novel_author,
					novel_detailurl, novel_icon, novel_name, MsgType.NOVEL);
			return novel_chatMessage;
		case CODE_NEWS:
			String news_text=getStringFromJson(JSONNODE_NEWS_TEXT, msg);
			String news_article=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_ARTICLE,
					msg, 0)+Split+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_ARTICLE,
							msg, 1);
			String news_source=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_SOURCE,
					msg, 0)+Split+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_SOURCE,
							msg, 1);
			String news_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_DETAILURL,
					msg, 0)+Split+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_DETAILURL,
							msg, 1);
			Log.i("news_detailurl", news_detailurl);
			String news_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_ICON,
					msg, 0)+Split+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_NEWS_ICON,
							msg, 1);
			ChatMessage news_chatMessage=new ChatMessage(date, news_text, news_article, news_source, 
					news_detailurl, news_icon, MsgType.NEWS);
			return news_chatMessage;
		case CODE_DOWNLOAD:
			String download_text=getStringFromJson(JSONNODE_DOWNLOAD_TEXT, msg);
			String download_name=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_DOWNLOAD_NAME, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_DOWNLOAD_NAME, msg, 1);
			String download_count=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_DOWNLOAD_COUNT, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_DOWNLOAD_COUNT, msg, 1);
			String download_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_DOWNLOAD_DETAILURL, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_DOWNLOAD_DETAILURL, msg, 1);
			String download_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_DOWNLOAD_ICON, msg, 0);
			Log.i("DownLoad", download_text+download_name+download_count+download_detailurl+download_icon);
			ChatMessage download_chatMessage=new ChatMessage(date, download_text, download_name, download_count, 
					download_detailurl, download_icon, MsgType.DOWNLOAD);
			return download_chatMessage;
		case CODE_TRAIN:
			String train_text=getStringFromJson(JSONNODE_TRAIN_TEXT, msg);
			String train_trainnum=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_TRAINNUM, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_TRAINNUM, msg, 1);
			String train_start=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_START, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_START, msg, 1);
			String train_terminal=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_TERMINAL, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_TERMINAL, msg, 1);
			String train_strattime=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_STARTTIME, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_STARTTIME, msg, 1);
			String train_endtime=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_EMDTIME, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_EMDTIME, msg, 1);
			String train_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_DETAILURL, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_DETAILURL, msg, 1);
			String train_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_ICON, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_TRAIN_ICON, msg, 1);
			ChatMessage train_chatMessage=new ChatMessage(date, train_text,train_trainnum, train_start, train_terminal, train_strattime, train_endtime, 
					train_detailurl, train_icon,  MsgType.TRAIN); 
			return train_chatMessage;
		case CODE_FLIGHT:
			String flight_text=getStringFromJson(JSONNODE_FLIGHT_TEXT, msg);
			String flight_flight=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_FLIGHT, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_FLIGHT, msg, 1);
			String flight_route=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_ROUTE, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_ROUTE, msg, 1);
			String flight_starttime=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_STARTTIME, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_STARTTIME, msg, 1);
			String flight_endtime=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_EMDTIME, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_EMDTIME, msg, 1);
			String flight_state=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_STATE, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_STATE, msg, 1);
			String flight_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_DETAILURL, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_DETAILURL, msg, 1);
			String flight_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_ICON, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_FLIGHT_ICON, msg, 1);
			ChatMessage flight_chatMessage=new ChatMessage(date, flight_text, flight_flight, flight_route, flight_starttime,
					flight_endtime, flight_state, flight_detailurl, flight_icon, MsgType.FLIGHT);
			return flight_chatMessage;
			
		case CODE_HOTEL:
			String hotel_text=getStringFromJson(JSONNODE_HOTEL_TEXT, msg);
			Log.i(HTTPUTIL_TAG, hotel_text);
			String hotel_name=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_NAME, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_NAME, msg, 1);
			String hotel_price=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_PRICE, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_PRICE, msg, 1);
			String hotel_satisfaction=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_SATISFACTION, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_SATISFACTION, msg, 1);
			String hotel_count=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_COUNT, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_COUNT, msg, 1);
			String hotel_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_DETAILURL, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_DETAILURL, msg, 1);
			String hotel_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_ICON, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_HOTEL_ICON, msg, 1);
			ChatMessage hotel_chatMessage=new ChatMessage(date, hotel_text, hotel_name, hotel_price, 
					hotel_satisfaction, hotel_count, hotel_detailurl, hotel_icon, MsgType.HOTEL);
			return hotel_chatMessage;
			
		case CODE_RESTAURANT:
			String restaurant_text=getStringFromJson(JSONNODE_RESTAURANT_TEXT, msg);
			String restaurant_name=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_NAME, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_NAME, msg, 1);
			String restaurant_price=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_PRICE, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_PRICE, msg, 1);
			String restaurant_icon=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_ICON, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_ICON, msg, 1);
			String restaurant_detailurl=getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_DETAILURL, msg, 0)+Split
					+getStringFromJsonArray(JSONNODE_LIST, JSONNODE_RESTAURANT_DETAILURL, msg, 1);
			ChatMessage restaurant_chatMessage=new ChatMessage(date, restaurant_text, restaurant_name, 
					restaurant_price, restaurant_detailurl, restaurant_icon, MsgType.RESTAURANT);
			return restaurant_chatMessage;
		default:
			return null;
		}
	}

	/*
	 * 获取JSON中的数据
	 */

	private static String getStringFromJson(String sNode,String msg)
			throws JSONException {
		// TODO Auto-generated method stub
		String jsonRes = doGet(msg);
		JSONObject jsonObj =new JSONObject(jsonRes);
		String JsonResult=jsonObj.getString(sNode);
		return JsonResult;
	}
	
	/*
	 * 获取返回数据中list中的内容
	 */
	@SuppressWarnings("finally")
	private static String getStringFromJsonArray(String sNodeList,String sNode,String msg,int i) 
			throws JSONException{
		String jsonRes = doGet(msg);
		JSONObject jsonObj =new JSONObject(jsonRes);
		String result = "";
		try {
			JSONArray ja = jsonObj.getJSONArray(sNodeList);
				result = ja.getJSONObject(i).getString(sNode);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		finally{
			if(result.equals("")||result==null){
			result="empty";
		}
			Log.i("###"+sNode+i, result);
			return result;
		}
		
	}
	

	/*
	 * 获取服务器返回过来的字符串
	 * @author eke
	 */
	public static String doGet(String msg)
	{
		String result = "";
		String url = setParams(msg);
		ByteArrayOutputStream baos = null;
		InputStream is = null;
		try
		{
			java.net.URL urlNet = new java.net.URL(url);
			HttpURLConnection conn = (HttpURLConnection) urlNet
					.openConnection();
			conn.setReadTimeout(5* 1000);
			conn.setConnectTimeout(5* 1000);
			conn.setRequestMethod("GET");
			is = conn.getInputStream();
			int len = -1;
			byte[] buf = new byte[128];
			baos = new ByteArrayOutputStream();

			while ((len = is.read(buf)) != -1)
			{
				baos.write(buf, 0, len);
			}
			baos.flush();
			result = new String(baos.toByteArray());
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (baos != null)
					baos.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}

			try
			{
				if (is != null)
				{
					is.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private static String setParams(String msg)
	{
		String url = "";
		try
		{
			url = URL + "?key=" + API_KEY + "&info="
					+ URLEncoder.encode(msg, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return url;
	}
}
