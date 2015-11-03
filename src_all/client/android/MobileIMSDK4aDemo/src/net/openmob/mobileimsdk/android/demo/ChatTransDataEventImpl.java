/*
 * Copyright (C) 2015 Jack Jiang The MobileIMSDK Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/MobileIMSDK
 *  
 * openmob.net PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * ChatTransDataEventImpl.java at 2015-10-7 22:01:48, code by Jack Jiang.
 * You can contact author with jack.jiang@openmob.net or jb2011@163.com.
 */
package net.openmob.mobileimsdk.android.demo;

import net.openmob.mobileimsdk.android.event.ChatTransDataEvent;
import android.util.Log;
import android.widget.Toast;

public class ChatTransDataEventImpl implements ChatTransDataEvent
{
	private final static String TAG = ChatTransDataEventImpl.class.getSimpleName();
	
	private DemoMain ____temp = null; 
	
	@Override
	public void onTransBuffer(String fingerPrintOfProtocal, int dwUserid, String dataContent)
	{
		Log.d(TAG, "【DEBUG_UI】收到来自用户"+dwUserid+"的消息:"+dataContent);
		
		//！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
		if(____temp != null)
		{
			Toast.makeText(____temp, dwUserid+"说："+dataContent, Toast.LENGTH_SHORT).show();
			this.____temp.showIMInfo_black(dwUserid+"说："+dataContent);
		}
	}
	
	public ChatTransDataEventImpl set____temp(DemoMain ____temp)
	{
		this.____temp = ____temp;
		return this;
	}

	public DemoMain get____temp()
	{
		return ____temp;
	}

	@Override
	public void onErrorResponse(int errorCode, String errorMsg)
	{
		Log.d(TAG, "【DEBUG_UI】收到服务端错误消息，errorCode="+errorCode+", errorMsg="+errorMsg);
		this.____temp.showIMInfo_red("Server反馈错误码："+errorCode+",errorMsg="+errorMsg);
	}
}
