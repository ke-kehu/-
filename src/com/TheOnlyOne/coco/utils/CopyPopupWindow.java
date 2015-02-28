package com.TheOnlyOne.coco.utils;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.TheOnlyOne.coco.R;


public class CopyPopupWindow extends PopupWindow implements OnClickListener {

	private View mMenuView;
	private Context context;
	private TextView tv_copy_text;
	private static String mCopy;
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		int id = view.getId();
		switch(id){
		case R.id.copy_text:
			dismiss();
			ClipboardManager clip= (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
			ClipData clipdata = ClipData.newPlainText("text",mCopy);
			clip.setPrimaryClip(clipdata);
			Toast.makeText(context, "已经复制到粘贴板", Toast.LENGTH_SHORT).show();
		}
	}
	

	public CopyPopupWindow(final Activity context,String sCopy){
		super(context);
		this.context = context;
		this.mCopy=sCopy;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.pop_layout, null);
		tv_copy_text= (TextView) mMenuView.findViewById(R.id.copy_text);
		tv_copy_text.setOnClickListener(this);
		initWindow();
	}

	private void initWindow() {
		// TODO Auto-generated method stub
		int w = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
		// 设置按钮监听
		// 设置SelectPicPopupWindow的View
		this.setContentView(mMenuView);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(w/2);

		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		// 实例化一个ColorDrawable颜色为半透明
	    ColorDrawable dw = new ColorDrawable(0000000000);
		// 设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);	
	}

}
