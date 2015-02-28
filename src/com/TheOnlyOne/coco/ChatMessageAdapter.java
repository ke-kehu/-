package com.TheOnlyOne.coco;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.TheOnlyOne.coco.bean.ChatMessage;
import com.TheOnlyOne.coco.bean.ChatMessage.MsgType;
import com.TheOnlyOne.coco.utils.CopyPopupWindow;

public class ChatMessageAdapter extends BaseAdapter {
	private static String AdapterTag = "AdapterTags";
	private LayoutInflater mInflater;
	private List<ChatMessage> mDatas;
	private Context mcontext;
	private PopupWindow pop;
	private static boolean mFlag = false;

	// 定义消息类型
	final int INDEX_INCOMING = 0;
	final int INDEX_OUTCOMING = 1;
	final int INDEX_HOTEL = 2;
	final int INDEX_NOVEL = 3;
	final int INDEX_NEWS = 4;
	final int INDEX_DOWNLOAD = 5;
	final int INDEX_TRAIN = 6;
	final int INDEX_FLIGHT = 7;
	final int INDEX_FILM = 8;
	final int INDEX_RESTAURANT = 9;
	final int INDEX_LINK = 10;

	public ChatMessageAdapter(Context context, List<ChatMessage> mDatas) {
		this.mcontext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = mDatas;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		ChatMessage chatMessage = mDatas.get(position);
		MsgType type = chatMessage.getType();
		if (type == MsgType.INCOMING)
			return INDEX_INCOMING;
		else if (type == MsgType.OUTCOMING)
			return INDEX_OUTCOMING;
		else if (type == MsgType.NOVEL)
			return INDEX_NOVEL;
		else if (type == MsgType.NEWS)
			return INDEX_NEWS;
		else if (type == MsgType.DOWNLOAD)
			return INDEX_DOWNLOAD;
		else if (type == MsgType.TRAIN)
			return INDEX_TRAIN;
		else if (type == MsgType.FLIGHT)
			return INDEX_FLIGHT;
		else if (type == MsgType.FILM)
			return INDEX_FILM;
		else if (type == MsgType.RESTAURANT)
			return INDEX_RESTAURANT;
		else if (type == MsgType.LINK)
			return INDEX_LINK;
		else
			return INDEX_HOTEL;

	}

	@Override
	public int getViewTypeCount() {
		return 11;
	}

	@SuppressWarnings("null")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ChatMessage chatMessage = mDatas.get(position);
		IncomingViewHolder inViewHolder = null;
		OutViewHolder outViewHolder = null;
		FilmViewHolder filmViewHolder = null;
		NovelViewHolder novelViewHolder = null;
		NewsViewHolder newsViewHolder = null;
		AppViewHolder appViewHolder = null;
		TrainViewHolder trainViewHolder = null;
		FlightViewHolder flightViewHolder = null;
		HotelViewHolder hotelViewHolder = null;
		RestaurantViewHolder restaurantViewHolder = null;
		LinkViewHolder linkViewHolder = null;
		int type = getItemViewType(position);
		if (convertView == null) {
			switch (type) {
			case INDEX_INCOMING:
				convertView = mInflater.inflate(R.layout.item_from_msg, parent,
						false);
				inViewHolder = new IncomingViewHolder();
				inViewHolder.mInDate = (TextView) convertView
						.findViewById(R.id.id_form_msg_date);
				inViewHolder.mInMsg = (TextView) convertView
						.findViewById(R.id.id_from_msg_info);
				convertView.setTag(inViewHolder);
				break;
			case INDEX_OUTCOMING:
				convertView = mInflater.inflate(R.layout.item_to_msg, parent,
						false);
				outViewHolder = new OutViewHolder();
				outViewHolder.mOutDate = (TextView) convertView
						.findViewById(R.id.id_to_msg_date);
				outViewHolder.mOutMsg = (TextView) convertView
						.findViewById(R.id.id_to_msg_info);
				convertView.setTag(outViewHolder);
				break;
			case INDEX_HOTEL:
				convertView = mInflater.inflate(R.layout.hotel, parent, false);
				hotelViewHolder = new HotelViewHolder();
				hotelViewHolder.mHotel_date = (TextView) convertView
						.findViewById(R.id.id_hotel_msg_date);
				hotelViewHolder.mHotel_text = (TextView) convertView
						.findViewById(R.id.tv_hotel_text);
				hotelViewHolder.mHotel_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_hotel1);
				hotelViewHolder.mHotel_name1 = (TextView) convertView
						.findViewById(R.id.tv_hotel_name1);
				hotelViewHolder.mHotel_price1 = (TextView) convertView
						.findViewById(R.id.tv_hotel_price1);
				hotelViewHolder.mHotel_satisfcation1 = (TextView) convertView
						.findViewById(R.id.tv_hotel_satisfaction1);
				hotelViewHolder.mHotel_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_hotel2);
				hotelViewHolder.mHotel_name2 = (TextView) convertView
						.findViewById(R.id.tv_hotel_name2);
				hotelViewHolder.mHotel_price2 = (TextView) convertView
						.findViewById(R.id.tv_hotel_price2);
				hotelViewHolder.mHotel_satisfcation2 = (TextView) convertView
						.findViewById(R.id.tv_hotel_satisfaction2);
				convertView.setTag(hotelViewHolder);
				break;
			case INDEX_NOVEL:
				convertView = mInflater.inflate(R.layout.novel_msg, parent,
						false);
				novelViewHolder = new NovelViewHolder();
				novelViewHolder.mNovel_date = (TextView) convertView
						.findViewById(R.id.id_novel_msg_date);
				novelViewHolder.mNovel_text = (TextView) convertView
						.findViewById(R.id.tv_novel_text);
				novelViewHolder.mNovel_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_novel1);
				novelViewHolder.mNovel_name1 = (TextView) convertView
						.findViewById(R.id.tv_novel_name1);
				novelViewHolder.mNovel_author1 = (TextView) convertView
						.findViewById(R.id.tv_novel_author1);
				novelViewHolder.mNovel_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_novel2);
				novelViewHolder.mNovel_name2 = (TextView) convertView
						.findViewById(R.id.tv_novel_name2);
				novelViewHolder.mNovel_author2 = (TextView) convertView
						.findViewById(R.id.tv_novel_author2);
				convertView.setTag(novelViewHolder);
				break;
			case INDEX_NEWS:
				convertView = mInflater.inflate(R.layout.news_msg, parent,
						false);
				newsViewHolder = new NewsViewHolder();
				newsViewHolder.mNews_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_news1);
				newsViewHolder.mNews_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_news2);
				newsViewHolder.mNews_date = (TextView) convertView
						.findViewById(R.id.id_news_msg_date);
				newsViewHolder.mNews_text = (TextView) convertView
						.findViewById(R.id.tv_news_text);
				newsViewHolder.mNews_article1 = (TextView) convertView
						.findViewById(R.id.tv_news_article1);
				newsViewHolder.mNews_source1 = (TextView) convertView
						.findViewById(R.id.tv_news_source1);
				newsViewHolder.mNews_article2 = (TextView) convertView
						.findViewById(R.id.tv_news_article2);
				newsViewHolder.mNews_source2 = (TextView) convertView
						.findViewById(R.id.tv_news_source2);
				convertView.setTag(newsViewHolder);
				break;
			case INDEX_DOWNLOAD:
				convertView = mInflater
						.inflate(R.layout.app_msg, parent, false);
				appViewHolder = new AppViewHolder();
				appViewHolder.mApp_date = (TextView) convertView
						.findViewById(R.id.id_app_msg_date);
				appViewHolder.mApp_text = (TextView) convertView
						.findViewById(R.id.tv_app_text);
				appViewHolder.mApp_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_app1);
				appViewHolder.mApp_name1 = (TextView) convertView
						.findViewById(R.id.tv_app_name1);
				appViewHolder.mApp_count1 = (TextView) convertView
						.findViewById(R.id.tv_app_count1);
				appViewHolder.mApp_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_app2);
				appViewHolder.mApp_name2 = (TextView) convertView
						.findViewById(R.id.tv_app_name2);
				appViewHolder.mApp_count2 = (TextView) convertView
						.findViewById(R.id.tv_app_count2);
				convertView.setTag(appViewHolder);
				break;
			case INDEX_TRAIN:
				convertView = mInflater.inflate(R.layout.train_msg, parent,
						false);
				trainViewHolder = new TrainViewHolder();
				trainViewHolder.mTrain_date = (TextView) convertView
						.findViewById(R.id.id_train_msg_date);
				trainViewHolder.mTrain_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_train1);
				trainViewHolder.mTrain_text = (TextView) convertView
						.findViewById(R.id.tv_train_text);
				trainViewHolder.mTrain_start1 = (TextView) convertView
						.findViewById(R.id.tv_train_start1);
				trainViewHolder.mTrain_terminal1 = (TextView) convertView
						.findViewById(R.id.tv_train_terminal1);
				trainViewHolder.mTrain_trainnum1 = (TextView) convertView
						.findViewById(R.id.tv_train_trainnum1);
				trainViewHolder.mTrain_starttime1 = (TextView) convertView
						.findViewById(R.id.tv_train_starttime1);
				trainViewHolder.mTrain_endtime1 = (TextView) convertView
						.findViewById(R.id.tv_train_endtime1);
				trainViewHolder.mTrain_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_train2);
				trainViewHolder.mTrain_start2 = (TextView) convertView
						.findViewById(R.id.tv_train_start2);
				trainViewHolder.mTrain_terminal2 = (TextView) convertView
						.findViewById(R.id.tv_train_terminal2);
				trainViewHolder.mTrain_trainnum2 = (TextView) convertView
						.findViewById(R.id.tv_train_trainnum2);
				trainViewHolder.mTrain_starttime2 = (TextView) convertView
						.findViewById(R.id.tv_train_starttime2);
				trainViewHolder.mTrain_endtime2 = (TextView) convertView
						.findViewById(R.id.tv_train_endtime2);
				convertView.setTag(trainViewHolder);
				break;
			case INDEX_FLIGHT:
				convertView = mInflater.inflate(R.layout.flight, parent, false);
				flightViewHolder = new FlightViewHolder();
				flightViewHolder.mFlight_date = (TextView) convertView
						.findViewById(R.id.id_flight_msg_date);
				flightViewHolder.mFlight_text = (TextView) convertView
						.findViewById(R.id.tv_flight_text);
				flightViewHolder.mFlight_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_flight1);
				flightViewHolder.mFlight_flight1 = (TextView) convertView
						.findViewById(R.id.tv_flight_flight1);
				flightViewHolder.mFlight_rount1 = (TextView) convertView
						.findViewById(R.id.tv_flight_route1);
				flightViewHolder.mFlight_starttime1 = (TextView) convertView
						.findViewById(R.id.tv_flight_starttime1);
				flightViewHolder.mFlight_endtime1 = (TextView) convertView
						.findViewById(R.id.tv_flight_endtime1);
				flightViewHolder.mFlight_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_flight2);
				flightViewHolder.mFlight_flight2 = (TextView) convertView
						.findViewById(R.id.tv_flight_flight2);
				flightViewHolder.mFlight_rount2 = (TextView) convertView
						.findViewById(R.id.tv_flight_route2);
				flightViewHolder.mFlight_starttime2 = (TextView) convertView
						.findViewById(R.id.tv_flight_starttime2);
				flightViewHolder.mFlight_endtime2 = (TextView) convertView
						.findViewById(R.id.tv_flight_endtime2);
				convertView.setTag(flightViewHolder);
				break;
			case INDEX_FILM:
				convertView = mInflater.inflate(R.layout.film_msg, parent,
						false);
				filmViewHolder = new FilmViewHolder();
				filmViewHolder.mFlim_date = (TextView) convertView
						.findViewById(R.id.id_film_msg_date);
				filmViewHolder.mFlim_text = (TextView) convertView
						.findViewById(R.id.tv_film_text);
				filmViewHolder.mFilm_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_film1);
				filmViewHolder.mFlim_name1 = (TextView) convertView
						.findViewById(R.id.tv_film_name1);
				filmViewHolder.mFlim_info1 = (TextView) convertView
						.findViewById(R.id.tv_film_info1);
				filmViewHolder.mFilm_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_film2);
				filmViewHolder.mFlim_name2 = (TextView) convertView
						.findViewById(R.id.tv_film_name2);
				filmViewHolder.mFlim_info2 = (TextView) convertView
						.findViewById(R.id.tv_film_info2);
				convertView.setTag(filmViewHolder);
				break;
			case INDEX_RESTAURANT:
				convertView = mInflater.inflate(R.layout.restaurant, parent,
						false);
				restaurantViewHolder = new RestaurantViewHolder();
				restaurantViewHolder.mRestaurant_date = (TextView) convertView
						.findViewById(R.id.id_restaurant_msg_date);
				restaurantViewHolder.mRestaurant_text = (TextView) convertView
						.findViewById(R.id.tv_restaurant_text);
				restaurantViewHolder.mRestaurant_RLayout1 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_restaurant1);
				restaurantViewHolder.mRestaurant_name1 = (TextView) convertView
						.findViewById(R.id.tv_restaurant_name1);
				restaurantViewHolder.mRestaurant_price1 = (TextView) convertView
						.findViewById(R.id.tv_restaurant_price1);
				restaurantViewHolder.mRestaurant_RLayout2 = (RelativeLayout) convertView
						.findViewById(R.id.rLayout_restaurant2);
				restaurantViewHolder.mRestaurant_name2 = (TextView) convertView
						.findViewById(R.id.tv_restaurant_name2);
				restaurantViewHolder.mRestaurant_price2 = (TextView) convertView
						.findViewById(R.id.tv_restaurant_price2);
				convertView.setTag(restaurantViewHolder);
				break;
			case INDEX_LINK:
				convertView = mInflater.inflate(R.layout.link_msg, parent,
						false);
				linkViewHolder = new LinkViewHolder();
				linkViewHolder.mLink_date = (TextView) convertView
						.findViewById(R.id.id_link_msg_date);
				linkViewHolder.mLink_text = (TextView) convertView
						.findViewById(R.id.id_link_msg_info);
				linkViewHolder.mLink_url = (TextView) convertView
						.findViewById(R.id.id_link_msg_url);
				linkViewHolder.mLink_date = (TextView) convertView
						.findViewById(R.id.id_link_msg_date);
				convertView.setTag(linkViewHolder);
				break;
			default:
				break;

			}
		} else {
			switch (type) {
			case INDEX_INCOMING:
				inViewHolder = (IncomingViewHolder) convertView.getTag();
				break;
			case INDEX_OUTCOMING:
				outViewHolder = (OutViewHolder) convertView.getTag();
				break;
			case INDEX_HOTEL:
				hotelViewHolder = (HotelViewHolder) convertView.getTag();
				break;
			case INDEX_NOVEL:
				novelViewHolder = (NovelViewHolder) convertView.getTag();
				break;
			case INDEX_NEWS:
				newsViewHolder = (NewsViewHolder) convertView.getTag();
				break;
			case INDEX_DOWNLOAD:
				appViewHolder = (AppViewHolder) convertView.getTag();
				break;
			case INDEX_TRAIN:
				trainViewHolder = (TrainViewHolder) convertView.getTag();
				break;
			case INDEX_FLIGHT:
				flightViewHolder = (FlightViewHolder) convertView.getTag();
				break;
			case INDEX_FILM:
				filmViewHolder = (FilmViewHolder) convertView.getTag();
				break;
			case INDEX_RESTAURANT:
				restaurantViewHolder = (RestaurantViewHolder) convertView
						.getTag();
				break;
			case INDEX_LINK:
				linkViewHolder = (LinkViewHolder) convertView.getTag();
				break;
			}
		}

		// 设置数据
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		switch (type) {

		case INDEX_INCOMING:
			inViewHolder.mInDate.setText(df.format(chatMessage.getDate()));
			inViewHolder.mInMsg.setText(chatMessage.getMsg());
			Log.i(AdapterTag, "INDEX_INCOMING" + chatMessage.getMsg());
			JudgeDate(inViewHolder.mInDate, position);
			inViewHolder.mInMsg
					.setOnLongClickListener(new View.OnLongClickListener() {

						@Override
						public boolean onLongClick(View arg0) {
							// TODO Auto-generated method stub
							pop = new CopyPopupWindow((Activity) mcontext,
									chatMessage.getMsg());
							WindowManager.LayoutParams lp = ((Activity) mcontext)
									.getWindow().getAttributes();
							lp.alpha = 0.7f;
							((Activity) mcontext).getWindow().setAttributes(lp);
							pop.showAsDropDown(arg0, 0, 0);
							pop.setOnDismissListener(new OnDismissListener() {

								@Override
								public void onDismiss() {
									// TODO Auto-generated method stub
									WindowManager.LayoutParams lp = ((Activity) mcontext)
											.getWindow().getAttributes();
									lp.alpha = 1.0f;
									((Activity) mcontext).getWindow()
											.setAttributes(lp);
								}
							});
							return false;
						}
					});
			break;

		case INDEX_OUTCOMING:
			outViewHolder.mOutDate.setText(df.format(chatMessage.getDate()));
			outViewHolder.mOutMsg.setText(chatMessage.getMsg());
			Log.i(AdapterTag, "" + chatMessage.getMsg());
			JudgeDate(outViewHolder.mOutDate, position);
			outViewHolder.mOutMsg
					.setOnLongClickListener(new View.OnLongClickListener() {

						@Override
						public boolean onLongClick(View arg0) {
							// TODO Auto-generated method stub
							pop = new CopyPopupWindow((Activity) mcontext,
									chatMessage.getMsg());
							WindowManager.LayoutParams lp = ((Activity) mcontext)
									.getWindow().getAttributes();
							lp.alpha = 0.7f;
							((Activity) mcontext).getWindow().setAttributes(lp);
							pop.showAsDropDown(arg0, 0, 0);
							pop.setOnDismissListener(new OnDismissListener() {

								@Override
								public void onDismiss() {
									// TODO Auto-generated method stub
									WindowManager.LayoutParams lp = ((Activity) mcontext)
											.getWindow().getAttributes();
									lp.alpha = 1.0f;
									((Activity) mcontext).getWindow()
											.setAttributes(lp);
								}
							});
							return false;
						}
					});
			break;

		case INDEX_HOTEL:
			hotelViewHolder.mHotel_date
					.setText(df.format(chatMessage.getDate()));
			hotelViewHolder.mHotel_text.setText(chatMessage.getHotel_test());
			hotelViewHolder.mHotel_name1.setText(chatMessage.getHotel_name(0));
			hotelViewHolder.mHotel_price1
					.setText(chatMessage.getHotel_price(0));
			hotelViewHolder.mHotel_satisfcation1.setText(chatMessage
					.getHotel_satisfcation(0));
			hotelViewHolder.mHotel_name2.setText(chatMessage.getHotel_name(1));
			hotelViewHolder.mHotel_price2
					.setText(chatMessage.getHotel_price(1));
			hotelViewHolder.mHotel_satisfcation2.setText(chatMessage
					.getHotel_satisfcation(1));
			Log.i("getHotel_detailurl0", chatMessage.getHotel_detailurl(0));
			Log.i("getHotel_detailurl1", chatMessage.getHotel_detailurl(1));
			ClickListener(hotelViewHolder.mHotel_RLayout1,
					chatMessage.getHotel_detailurl(0));
			ClickListener(hotelViewHolder.mHotel_RLayout2,
					chatMessage.getHotel_detailurl(1));
			JudgeDate(hotelViewHolder.mHotel_date, position);
			break;

		case INDEX_NOVEL:
			novelViewHolder.mNovel_date
					.setText(df.format(chatMessage.getDate()));
			novelViewHolder.mNovel_text.setText(chatMessage.getNovel_test());
			novelViewHolder.mNovel_name1.setText(chatMessage.getNovel_name(0));
			novelViewHolder.mNovel_author1.setText(chatMessage
					.getNovel_author(0));
			novelViewHolder.mNovel_name2.setText(chatMessage.getNovel_name(1));
			novelViewHolder.mNovel_author2.setText(chatMessage
					.getNovel_author(1));
			ClickListener(novelViewHolder.mNovel_RLayout1,
					chatMessage.getDownload_detailurl(0));
			ClickListener(novelViewHolder.mNovel_RLayout2,
					chatMessage.getDownload_detailurl(1));
			JudgeDate(novelViewHolder.mNovel_date, position);
			break;

		case INDEX_NEWS:
			newsViewHolder.mNews_date.setText(df.format(chatMessage.getDate()));
			newsViewHolder.mNews_text.setText(chatMessage.getNews_test());
			newsViewHolder.mNews_article1.setText(chatMessage
					.getNews_article(0));
			newsViewHolder.mNews_source1.setText(chatMessage.getNews_source(0));
			newsViewHolder.mNews_article2.setText(chatMessage
					.getNews_article(1));
			newsViewHolder.mNews_source2.setText(chatMessage.getNews_source(1));
			ClickListener(newsViewHolder.mNews_RLayout1,
					chatMessage.getNews_detailurl(0));
			ClickListener(newsViewHolder.mNews_RLayout2,
					chatMessage.getNews_detailurl(1));
			JudgeDate(newsViewHolder.mNews_date, position);
			break;

		case INDEX_DOWNLOAD:
			Log.i("chatMessage.getDate()", df.format(chatMessage.getDate()));
			appViewHolder.mApp_date.setText(df.format(chatMessage.getDate()));
			appViewHolder.mApp_text.setText(chatMessage.getDownload_test());
			appViewHolder.mApp_count1.setText(chatMessage.getDownload_count(0));
			appViewHolder.mApp_name1.setText(chatMessage.getDownload_name(0));
			appViewHolder.mApp_count2.setText(chatMessage.getDownload_count(1));
			appViewHolder.mApp_name2.setText(chatMessage.getDownload_name(1));
			ClickListener(appViewHolder.mApp_RLayout1,
					chatMessage.getDownload_detailurl(0));
			ClickListener(appViewHolder.mApp_RLayout2,
					chatMessage.getDownload_detailurl(1));
			JudgeDate(appViewHolder.mApp_date, position);
			break;

		case INDEX_TRAIN:
			trainViewHolder.mTrain_date
					.setText(df.format(chatMessage.getDate()));
			trainViewHolder.mTrain_text.setText(chatMessage.getTrain_test());
			trainViewHolder.mTrain_start1
					.setText(chatMessage.getTrain_start(0));
			trainViewHolder.mTrain_terminal1.setText(chatMessage
					.getTrain_terminal(0));
			trainViewHolder.mTrain_trainnum1.setText(chatMessage
					.getTrain_trainnum(0));
			trainViewHolder.mTrain_starttime1.setText(chatMessage
					.getTrain_starttime(0));
			trainViewHolder.mTrain_endtime1.setText(chatMessage
					.getTrain_endtime(0));
			trainViewHolder.mTrain_start2
					.setText(chatMessage.getTrain_start(1));
			trainViewHolder.mTrain_terminal2.setText(chatMessage
					.getTrain_terminal(1));
			trainViewHolder.mTrain_trainnum2.setText(chatMessage
					.getTrain_trainnum(1));
			trainViewHolder.mTrain_starttime2.setText(chatMessage
					.getTrain_starttime(1));
			trainViewHolder.mTrain_endtime2.setText(chatMessage
					.getTrain_endtime(1));
			ClickListener(trainViewHolder.mTrain_RLayout1,
					chatMessage.getTrain_detailurl(0));
			ClickListener(trainViewHolder.mTrain_RLayout2,
					chatMessage.getTrain_detailurl(1));
			JudgeDate(trainViewHolder.mTrain_date, position);
			break;
		case INDEX_FLIGHT:
			flightViewHolder.mFlight_date.setText(df.format(chatMessage
					.getDate()));
			flightViewHolder.mFlight_text.setText(chatMessage.getFlight_test());
			flightViewHolder.mFlight_flight1.setText(chatMessage
					.getFlight_flight(0));
			flightViewHolder.mFlight_rount1.setText(chatMessage
					.getFlight_route(0));
			flightViewHolder.mFlight_starttime1.setText(chatMessage
					.getFlight_starttime(0));
			flightViewHolder.mFlight_endtime1.setText(chatMessage
					.getFlight_endtime(0));
			flightViewHolder.mFlight_flight2.setText(chatMessage
					.getFlight_flight(1));
			flightViewHolder.mFlight_rount2.setText(chatMessage
					.getFlight_route(1));
			flightViewHolder.mFlight_starttime2.setText(chatMessage
					.getFlight_starttime(1));
			flightViewHolder.mFlight_endtime2.setText(chatMessage
					.getFlight_endtime(1));
			ClickListener(flightViewHolder.mFlight_RLayout1,
					chatMessage.getFlight_detailurl(0));
			ClickListener(flightViewHolder.mFlight_RLayout2,
					chatMessage.getFlight_detailurl(1));
			JudgeDate(flightViewHolder.mFlight_date, position);
			break;
		case INDEX_FILM:
			filmViewHolder.mFlim_date.setText(df.format(chatMessage.getDate()));
			filmViewHolder.mFlim_text.setText(chatMessage.getFilm_test());
			filmViewHolder.mFlim_info1.setText(chatMessage.getFilm_info(0));
			filmViewHolder.mFlim_name1.setText(chatMessage.getFilm_name(0));
			filmViewHolder.mFlim_info2.setText(chatMessage.getFilm_info(1));
			filmViewHolder.mFlim_name2.setText(chatMessage.getFilm_name(1));
			ClickListener(filmViewHolder.mFilm_RLayout1,
					chatMessage.getFilm_detailurl(0));
			ClickListener(filmViewHolder.mFilm_RLayout2,
					chatMessage.getFilm_detailurl(1));
			JudgeDate(filmViewHolder.mFlim_date, position);
			break;
		case INDEX_RESTAURANT:
			restaurantViewHolder.mRestaurant_date.setText(df.format(chatMessage
					.getDate()));
			restaurantViewHolder.mRestaurant_text.setText(chatMessage
					.getRestaurant_test());
			restaurantViewHolder.mRestaurant_name1.setText(chatMessage
					.getRestaurant_name(0));
			restaurantViewHolder.mRestaurant_price1.setText(chatMessage
					.getRestaurant_price(0));
			restaurantViewHolder.mRestaurant_name2.setText(chatMessage
					.getRestaurant_name(1));
			restaurantViewHolder.mRestaurant_price2.setText(chatMessage
					.getRestaurant_price(1));
			ClickListener(restaurantViewHolder.mRestaurant_RLayout1,
					chatMessage.getRestaurant_detail(0));
			ClickListener(restaurantViewHolder.mRestaurant_RLayout2,
					chatMessage.getRestaurant_detail(1));
			JudgeDate(restaurantViewHolder.mRestaurant_date, position);
			break;
		case INDEX_LINK:
			linkViewHolder.mLink_text.setText(chatMessage.getLink_text());
			linkViewHolder.mLink_date.setText(df.format(chatMessage.getDate()));
			JudgeDate(linkViewHolder.mLink_date, position);
			linkViewHolder.mLink_url
					.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Uri uri = Uri.parse(chatMessage.getLink_url());
							Intent intent = new Intent(Intent.ACTION_VIEW, uri);
							mcontext.startActivity(intent);
						}
					});
			break;
		}
		return convertView;
	}

	private void JudgeDate(TextView date, int position) {
		// TODO Auto-generated method stub
		mFlag = JudgeTime(position);
		if (!mFlag) {
			date.setVisibility(View.INVISIBLE);
		} else {
			date.setVisibility(View.VISIBLE);
		}
	}

	private void ClickListener(ViewGroup layout, final String sUri) {
		// TODO Auto-generated method stub
		layout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (sUri.equals("empty")) {

					Toast.makeText(mcontext, "地址不存在，不能跳转", Toast.LENGTH_SHORT)
							.show();
				} else {
					Uri uri = Uri.parse(sUri);
					Intent intent = new Intent(Intent.ACTION_VIEW, uri);
					mcontext.startActivity(intent);

				}
			}
		});
	}

	private boolean JudgeTime(int position) {
		// TODO Auto-generated method stub
		if (position > 0) {
			ChatMessage Message = mDatas.get(position);
			Date d1 = Message.getDate();
			ChatMessage upperMessage = mDatas.get(position - 1);
			Date d2 = upperMessage.getDate();
			if ((d1.getTime() - d2.getTime()) > (60000 * 3)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	private final class IncomingViewHolder {
		TextView mInDate;
		TextView mInMsg;
	}

	private final class OutViewHolder {
		TextView mOutDate;
		TextView mOutMsg;
	}

	private final class NovelViewHolder {
		TextView mNovel_date;
		TextView mNovel_text;
		TextView mNovel_name1;
		TextView mNovel_author1;
		RelativeLayout mNovel_RLayout1;
		TextView mNovel_name2;
		TextView mNovel_author2;
		RelativeLayout mNovel_RLayout2;
	}

	private final class NewsViewHolder {
		TextView mNews_text;
		TextView mNews_date;
		TextView mNews_article1;
		TextView mNews_source1;
		TextView mNews_article2;
		TextView mNews_source2;
		RelativeLayout mNews_RLayout1;
		RelativeLayout mNews_RLayout2;

	}

	private final class AppViewHolder {
		TextView mApp_text;
		TextView mApp_date;
		TextView mApp_name1;
		TextView mApp_count1;
		TextView mApp_name2;
		TextView mApp_count2;
		RelativeLayout mApp_RLayout1;
		RelativeLayout mApp_RLayout2;
	}

	private final class TrainViewHolder {
		TextView mTrain_text;
		TextView mTrain_date;
		TextView mTrain_trainnum1;
		TextView mTrain_start1;
		TextView mTrain_terminal1;
		TextView mTrain_starttime1;
		TextView mTrain_endtime1;
		TextView mTrain_trainnum2;
		TextView mTrain_start2;
		TextView mTrain_terminal2;
		TextView mTrain_starttime2;
		TextView mTrain_endtime2;
		RelativeLayout mTrain_RLayout1;
		RelativeLayout mTrain_RLayout2;

	}

	private final class FlightViewHolder {
		TextView mFlight_text;
		TextView mFlight_date;
		TextView mFlight_flight1;
		TextView mFlight_rount1;
		TextView mFlight_starttime1;
		TextView mFlight_endtime1;
		TextView mFlight_flight2;
		TextView mFlight_rount2;
		TextView mFlight_starttime2;
		TextView mFlight_endtime2;
		RelativeLayout mFlight_RLayout1;
		RelativeLayout mFlight_RLayout2;
	}

	private final class FilmViewHolder {
		TextView mFlim_text;
		TextView mFlim_date;
		TextView mFlim_name1;
		TextView mFlim_info1;
		TextView mFlim_name2;
		TextView mFlim_info2;
		RelativeLayout mFilm_RLayout1;
		RelativeLayout mFilm_RLayout2;
	}

	private final class HotelViewHolder {
		TextView mHotel_text;
		TextView mHotel_name1;
		TextView mHotel_price1;
		TextView mHotel_satisfcation1;
		RelativeLayout mHotel_RLayout1;
		RelativeLayout mHotel_RLayout2;
		TextView mHotel_name2;
		TextView mHotel_price2;
		TextView mHotel_satisfcation2;
		TextView mHotel_date;
	}

	private final class RestaurantViewHolder {
		TextView mRestaurant_text;
		TextView mRestaurant_date;
		TextView mRestaurant_name1;
		TextView mRestaurant_price1;
		TextView mRestaurant_name2;
		TextView mRestaurant_price2;
		RelativeLayout mRestaurant_RLayout1;
		RelativeLayout mRestaurant_RLayout2;

	}

	private final class LinkViewHolder {
		TextView mLink_text;
		TextView mLink_url;
		TextView mLink_date;
	}

}
