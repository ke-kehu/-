package com.TheOnlyOne.coco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;

import com.TheOnlyOne.coco.bean.ChatMessage;
import com.TheOnlyOne.coco.bean.ChatMessage.MsgType;
import com.TheOnlyOne.coco.utils.CopyPopupWindow;
import com.TheOnlyOne.coco.utils.HttpUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String MainActivityTAG = "MainActivity";
	private ListView mMsgs;
	private ChatMessageAdapter mAdapter;
	private List<ChatMessage> mDatas;

	private EditText mInputMsg;
	private Button mSendMsg;
	private PopupWindow pop;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			// 等待接收，子线程完成数据的返回
			ChatMessage fromMessge = (ChatMessage) msg.obj;
			mDatas.add(fromMessge);
			mAdapter.notifyDataSetChanged();
			mMsgs.setSelection(mDatas.size() - 1);
		};

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initDatas();
		// 初始化事件
		initListener();
	}

	private void initListener() {
		mSendMsg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final String toMsg = mInputMsg.getText().toString();
				if (TextUtils.isEmpty(toMsg)) {
					Toast.makeText(MainActivity.this, "发送消息不能为空！",
							Toast.LENGTH_SHORT).show();
					return;
				}
				Date date = new Date();
				ChatMessage toMessage = new ChatMessage(toMsg,
						MsgType.OUTCOMING, date);
				mDatas.add(toMessage);
				mAdapter.notifyDataSetChanged();
				mMsgs.setSelection(mDatas.size() - 1);

				mInputMsg.setText("");

				new Thread() {
					public void run() {
						ChatMessage fromMessage;
						try {
							fromMessage = HttpUtils.sendMessage(toMsg);
							Message m = Message.obtain();
							m.obj = fromMessage;
							mHandler.sendMessage(m);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					};
				}.start();

			}
		});
	}

	private void initDatas() {
		mDatas = new ArrayList<ChatMessage>();
		mDatas.add(new ChatMessage("您好，coco为您服务", MsgType.INCOMING, new Date()));
		mAdapter = new ChatMessageAdapter(this, mDatas);
		mMsgs.setAdapter(mAdapter);
	}

	private void initView() {
		mMsgs = (ListView) findViewById(R.id.id_listview_msgs);
		mInputMsg = (EditText) findViewById(R.id.id_input_msg);
		mSendMsg = (Button) findViewById(R.id.id_send_msg);
	}

}
