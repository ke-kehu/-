package com.TheOnlyOne.coco.bean;

import java.util.Date;
import java.util.regex.Pattern;

import android.util.Log;

import com.TheOnlyOne.coco.utils.HttpUtils;

public class ChatMessage {


	private static String Tag="HttpUtilsTag";
	private String name;
	private String msg;
	private MsgType type;
	private Date date;

	// 小说
	private String novel_test;
	private String novel_name;
	private String novel_author;
	private String novel_detailurl;
	private String novel_icon;

	// 新闻
	private String news_test;
	private String news_article;
	private String news_source;
	private String news_detailurl;
	private String news_icon;
	
	//下载
	private String Download_test;
	private String Download_name;
	private String Download_count;
	private String Download_detailurl;
	private String Download_icon;
	
	//列车
	private String Train_test;
	private String Train_trainnum;
	private String Train_start;
	private String Train_terminal;
	private String Train_starttime;
	private String Train_endtime;
	private String Train_detailurl;
	private String Train_icon;
	
	//航班
	private String Flight_test;
	private String Flight_flight;
	private String Flight_route;
	private String Flight_starttime;
	private String Flight_endtime;
	private String Flight_state;
	private String Flight_detailurl;
	private String Flight_icon;
	
	//酒店
	private String Hotel_test;
	private String Hotel_name;
	private String Hotel_price;
	private String Hotel_satisfcation;
	private String Hotel_count;
	private String Hotel_detailurl;
	private String Hotel_icon;
	
	
	//电影
	private String Film_test;
	private String Film_name;
	private String Film_info;
	private String Film_detailurl;
	private String Film_icon;
	
	//餐厅
	private String Restaurant_test;
	private String Restaurant_name;
	private String Restaurant_price;
	private String Restaurant_detail;
	private String Restaurant_icon;
	
	
	//链接
	private String Link_text;
	private String Link_url;

	public enum MsgType {
		INCOMING, OUTCOMING, NOVEL, NEWS,DOWNLOAD,TRAIN,FLIGHT,HOTEL,
		FILM,RESTAURANT,LINK
	}

	public ChatMessage() {
	}

	/*
	 * 文字类
	 */
	public ChatMessage(String msg, MsgType type, Date date) {
		super();
		this.msg = msg;
		this.type = type;
		this.date = date;
	}
	
	/*
	 * 链接类
	 */
	public ChatMessage(String text,String url,Date date,MsgType type){
		super();
		this.Link_text=text;
		this.Link_url=url;
		this.type=type;
		this.date=date;
	}

	/*
	 * 小说、新闻、下载 、餐厅
	 */
	public ChatMessage(Date date,String str0, String str1, String str2, String str3,
			String str4, MsgType type) {
		super();
		switch (type) {
		//小说
		case NOVEL:
			this.novel_test = str0;
			this.novel_author = str1;
			this.novel_detailurl = str2;
			this.novel_icon = str3;
			this.novel_name = str4;
			this.type = type;
			this.date = date;
			break;
	    //新闻
		case NEWS:
			this.news_test=str0;
			this.news_article=str1;
			this.news_source=str2;
			this.news_detailurl=str3;
			this.news_icon=str4;
			this.type = type;
			this.date = date;
		//下载
		case DOWNLOAD:
			this.Download_test=str0;
			this.Download_name=str1;
			this.Download_count=str2;
			this.Download_detailurl=str3;
			this.Download_icon=str4;
			this.type = type;
			this.date = date;
			break;
		//电影
		case FILM:
			this.Film_test=str0;
			this.Film_name=str1;
			this.Film_info=str2;
			this.Film_detailurl=str3;
			this.Film_icon=str4;
			this.type=type;
			this.date = date;
			break;
		//餐厅
		case RESTAURANT:
			this.Restaurant_test=str0;
			this.Restaurant_name=str1;
			this.Restaurant_price=str2;
			this.Restaurant_detail=str3;
			this.Restaurant_icon=str4;
			this.type=type;
			this.date = date;
			break;
		default:
			break;

		}
	}
	
	
	/*
	 * 酒店
	 */
	public ChatMessage(Date date,String str0,String str1,String str2,String str3,String str4,
			String str5,String str6,MsgType type){
		super();
		switch (type) {
		//酒店
		case HOTEL:
			this.Hotel_test=str0;
			this.Hotel_name=str1;
			this.Hotel_price=str2;
			this.Hotel_satisfcation=str3;
			this.Hotel_count=str4;
			this.Hotel_detailurl=str5;
			this.Hotel_icon=str6;
			this.type=type;
			this.date = date;
			break;

		default:
			break;
		}
	}
	
	/*
	 * 列车、航班
	 */
	public ChatMessage(Date date,String str0,String str1,String str2,String str3,String str4,String str5,
			String str6,String str7,MsgType type){
		super();
		switch(type){
		//列车
		case TRAIN:
			this.Train_test=str0;
			this.Train_trainnum=str1;
			this.Train_start=str2;
			this.Train_terminal=str3;
			this.Train_starttime=str4;
			this.Train_endtime=str5;
			this.Train_detailurl=str6;
			this.Train_icon=str7;
			this.type = type;
			this.date = date;
			break;
		//航班
		case FLIGHT:
			this.Flight_test=str0;
			this.Flight_flight=str1;
			this.Flight_route=str2;
			this.Flight_starttime=str3;
			this.Flight_endtime=str4;
			this.Flight_state=str5;
			this.Flight_detailurl=str6;
			this.Flight_icon=str7;
			this.type = type;
			this.date = date;
		default:
			break;
			
		}
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MsgType getType() {
		return type;
	}

	public void setType(MsgType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNovel_test() {
		return novel_test;
	}

	public void setNovel_test(String novel_test) {
		this.novel_test = novel_test;
	}

	public String getNovel_name(int i) {
		String[] novel_names=Pattern.compile(HttpUtils.Split).split(novel_name);
		return novel_names[i];
	}

	public void setNovel_name(String novel_name) {
		this.novel_name = novel_name;
	}

	public String getNovel_author(int i) {
		String[] novel_authors=Pattern.compile(HttpUtils.Split).split(novel_author);
		return novel_authors[i];
	}

	public void setNovel_author(String novel_author) {
		this.novel_author = novel_author;
	}

	public String getNovel_detailurl(int i) {
		String[] novel_detailurls=Pattern.compile(HttpUtils.Split).split(novel_detailurl);
		return novel_detailurls[i];
	}

	public void setNovel_detailurl(String novel_detailurl) {
		this.novel_detailurl = novel_detailurl;
	}

	public String getNovel_icon(int i) {
		String[] novel_icons=Pattern.compile(HttpUtils.Split).split(novel_icon);
		return novel_icons[i];
	}

	public void setNovel_icon(String novel_icon) {
		this.novel_icon = novel_icon;
	}

	public String getNews_article(int i) {
		String[] news_articles = Pattern.compile(HttpUtils.Split).split(news_article);
		Log.i(Tag, news_articles[i]);
		return news_articles[i];
		
	}

	public void setNews_article(String news_article) {
		this.news_article = news_article;
	}

	public String getNews_test() {
		return news_test;
	}

	public void setNews_test(String news_test) {
		this.news_test = news_test;
	}

	public String getNews_source(int i) {
		String[] news_sources = Pattern.compile(HttpUtils.Split).split(news_source);
		return news_sources[i];
	}

	public void setNews_source(String news_source) {
		this.news_source = news_source;
	}

	public String getNews_detailurl(int i) {
		String[] news_detailurls = Pattern.compile(HttpUtils.Split).split(news_detailurl);
		return news_detailurls[i];
	}

	public void setNews_detailurl(String news_detailurl) {
		this.news_detailurl = news_detailurl;
	}

	public String getNews_icon() {
		return news_icon;
	}

	public void setNews_icon(String news_icon) {
		this.news_icon = news_icon;
	}

	public String getDownload_test() {
		return Download_test;
	}

	public void setDownload_test(String download_test) {
		this.Download_test = download_test;
	}

	public String getDownload_name(int i) {
		String[] Download_names = Pattern.compile(HttpUtils.Split).split(Download_name);
		return Download_names[i];
	}

	public void setDownload_name(String download_name) {
		this.Download_name = download_name;
	}

	public String getDownload_count(int i) {
		String[] Download_counts = Pattern.compile(HttpUtils.Split).split(Download_count);
		return Download_counts[i];
	}

	public void setDownload_count(String download_count) {
		Download_count = download_count;
	}

	public String getDownload_detailurl(int i) {
		String[] Download_detailurls = Pattern.compile(HttpUtils.Split).split(Download_detailurl);
		return Download_detailurls[i];
	}

	public void setDownload_detailurl(String download_detailurl) {
		this.Download_detailurl = download_detailurl;
	}

	public String getDownload_icon() {
		return Download_icon;
	}

	public void setDownload_icon(String download_icon) {
		Download_icon = download_icon;
	}

	public String getTrain_test() {
		return Train_test;
	}

	public void setTrain_test(String train_test) {
		Train_test = train_test;
	}

	public String getTrain_trainnum(int i) {
		String[] Train_trainnums = Pattern.compile(HttpUtils.Split).split(Train_trainnum);
		return Train_trainnums[i];
	}

	public void setTrain_trainnum(String train_trainnum) {
		Train_trainnum = train_trainnum;
	}

	public String getTrain_start(int i) {
		String[] Train_starts = Pattern.compile(HttpUtils.Split).split(Train_start);
		return Train_starts[i];
	}

	public void setTrain_start(String train_start) {
		Train_start = train_start;
	}

	public String getTrain_terminal(int i) {
		String[] Train_terminals = Pattern.compile(HttpUtils.Split).split(Train_terminal);
		return Train_terminals[i];
	}

	public void setTrain_terminal(String train_terminal) {
		Train_terminal = train_terminal;
	}

	public String getTrain_starttime(int i) {
		String[] Train_starttimes = Pattern.compile(HttpUtils.Split).split(Train_starttime);
		return Train_starttimes[i];
	}

	public void setTrain_starttime(String train_starttime) {
		Train_starttime = train_starttime;
	}

	public String getTrain_endtime(int i) {
		String[] Train_endtimes = Pattern.compile(HttpUtils.Split).split(Train_endtime);
		return Train_endtimes[i];
	}

	public void setTrain_endtime(String train_endtime) {
		Train_endtime = train_endtime;
	}

	public String getTrain_detailurl(int i) {
		String[] Train_detailurls = Pattern.compile(HttpUtils.Split).split(Train_detailurl);
		return Train_detailurls[i];
	}

	public void setTrain_detailurl(String train_detailurl) {
		Train_detailurl = train_detailurl;
	}

	public String getTrain_icon(int i) {
		String[] Train_icons = Pattern.compile(HttpUtils.Split).split(Train_icon);
		return Train_icons[i];
	}

	public void setTrain_icon(String train_icon) {
		Train_icon = train_icon;
	}

	public String getFlight_test() {
		return Flight_test;
	}

	public void setFlight_test(String flight_test) {
		Flight_test = flight_test;
	}

	public String getFlight_flight(int i) {
		String[] Flight_flights = Pattern.compile(HttpUtils.Split).split(Flight_flight);
		return Flight_flights[i];
	}

	public void setFlight_flight(String flight_flight) {
		Flight_flight = flight_flight;
	}

	public String getFlight_route(int i) {
		String[] Flight_routes = Pattern.compile(HttpUtils.Split).split(Flight_route);
		return Flight_routes[i];
	}

	public void setFlight_route(String flight_route) {
		Flight_route = flight_route;
	}

	public String getFlight_starttime(int i) {
		String[] Flight_starttimes = Pattern.compile(HttpUtils.Split).split(Flight_starttime);
		return Flight_starttimes[i];
	}

	public void setFlight_starttime(String flight_starttime) {
		Flight_starttime = flight_starttime;
	}

	public String getFlight_endtime(int i) {
		String[] Flight_endtimes = Pattern.compile(HttpUtils.Split).split(Flight_endtime);
		return Flight_endtimes[i];
	}

	public void setFlight_endtime(String flight_endtime) {
		Flight_endtime = flight_endtime;
	}

	public String getFlight_state() {
		return Flight_state;
	}

	public void setFlight_state(String flight_state) {
		Flight_state = flight_state;
	}

	public String getFlight_detailurl(int i) {
		String[] Flight_detailurls = Pattern.compile(HttpUtils.Split).split(Flight_detailurl);
		return Flight_detailurls[i];
	}

	public void setFlight_detailurl(String flight_detailurl) {
		Flight_detailurl = flight_detailurl;
	}

	public String getFlight_icon(int i) {
		String[] Flight_icons = Pattern.compile(HttpUtils.Split).split(Flight_icon);
		return Flight_icons[i];
	}

	public void setFlight_icon(String flight_icon) {
		Flight_icon = flight_icon;
	}

	public String getHotel_test() {
		return Hotel_test;
	}

	public void setHotel_test(String hotel_test) {
		Hotel_test = hotel_test;
	}

	public String getHotel_name(int i) {
		String[] Hotel_names = Pattern.compile(HttpUtils.Split).split(Hotel_name);
		return Hotel_names[i];
	}

	public void setHotel_name(String hotel_name) {
		this.Hotel_name = hotel_name;
	}

	public String getHotel_price(int i) {
		String[] Hotel_prices = Pattern.compile(HttpUtils.Split).split(Hotel_price);
		return Hotel_prices[i];
	}

	public void setHotel_price(String hotel_price) {
		Hotel_price = hotel_price;
	}

	public String getHotel_satisfcation(int i) {
		String[] Hotel_satisfcations = Pattern.compile(HttpUtils.Split).split(Hotel_satisfcation);
		return Hotel_satisfcations[i];
	}

	public void setHotel_satisfcation(String hotel_satisfcation) {
		Hotel_satisfcation = hotel_satisfcation;
	}

	public String getHotel_count(int i) {
		String[] Hotel_counts = Pattern.compile(HttpUtils.Split).split(Hotel_count);
		return Hotel_counts[i];
	}

	public void setHotel_count(String hotel_count) {
		Hotel_count = hotel_count;
	}

	public String getHotel_icon(int i) {
		String[] Hotel_icons = Pattern.compile(HttpUtils.Split).split(Hotel_icon);
		return Hotel_icons[i];
	}

	public void setHotel_icon(String hotel_icon) {
		Hotel_icon = hotel_icon;
	}

	public String getHotel_detailurl(int i) {
		String[] Hotel_detailurls = Pattern.compile(HttpUtils.Split).split(Hotel_detailurl);
		return Hotel_detailurls[i];
	}

	public void setHotel_detailurl(String hotel_detailurl) {
		Hotel_detailurl = hotel_detailurl;
	}	

	public String getFilm_test() {
		return Film_test;
	}

	public void setFilm_test(String film_test) {
		Film_test = film_test;
	}

	public String getFilm_name(int i) {
		String[] Film_names = Pattern.compile(HttpUtils.Split).split(Film_name);
		return Film_names[i];
	}

	public void setFilm_name(String film_name) {
		Film_name = film_name;
	}

	public String getFilm_info(int i) {
		String[] Film_infos = Pattern.compile(HttpUtils.Split).split(		Film_info);
		return Film_infos[i];
	}

	public void setFilm_info(String film_info) {
		Film_info = film_info;
	}

	public String getFilm_detailurl(int i) {
		String[] Film_detailurls = Pattern.compile(HttpUtils.Split).split(Film_detailurl);
		return Film_detailurls[i];
	}

	public void setFilm_detailurl(String film_detailurl) {
		Film_detailurl = film_detailurl;
	}

	public String getFilm_icon(int i) {
		String[] Film_icons = Pattern.compile(HttpUtils.Split).split(Film_icon);
		return Film_icons[i];
	}

	public void setFilm_icon(String film_icon) {
		Film_icon = film_icon;
	}


	public String getRestaurant_test() {
		return Restaurant_test;
	}

	public void setRestaurant_test(String restaurant_test) {
		Restaurant_test = restaurant_test;
	}

	public String getRestaurant_name(int i) {
		String[] Restaurant_names = Pattern.compile(HttpUtils.Split).split(Restaurant_name);
		return Restaurant_names[i];
	}

	public void setRestaurant_name(String restaurant_name) {
		Restaurant_name = restaurant_name;
	}

	public String getRestaurant_price(int i) {
		String[] Restaurant_prices = Pattern.compile(HttpUtils.Split).split(Restaurant_price);
		return Restaurant_prices[i];
	}

	public void setRestaurant_price(String restaurant_price) {
		Restaurant_price = restaurant_price;
	}

	public String getRestaurant_detail(int i) {
		String[] Restaurant_details = Pattern.compile(HttpUtils.Split).split(Restaurant_detail);
		return Restaurant_details[i];
	}

	public void setRestaurant_detail(String restaurant_detail) {
		Restaurant_detail = restaurant_detail;
	}

	public String getRestaurant_icon(int i) {
		String[] Restaurant_icons = Pattern.compile(HttpUtils.Split).split(Restaurant_icon);
		return Restaurant_icons[i];
	}

	public void setRestaurant_icon(String restaurant_icon) {
		Restaurant_icon = restaurant_icon;
	}

	
	public String getLink_text() {
		return Link_text;
	}

	public void setLink_text(String link_text) {
		Link_text = link_text;
	}

	public String getLink_url() {
		return Link_url;
	}

	public void setLink_url(String link_url) {
		Link_url = link_url;
	}
}
