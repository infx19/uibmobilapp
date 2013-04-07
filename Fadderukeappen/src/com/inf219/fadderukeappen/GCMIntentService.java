package com.inf219.fadderukeappen;

import android.content.Context;
import android.content.Intent;

public class GCMIntentService extends com.google.android.gcm.GCMBaseIntentService {
	
	private static final String senderId = "123456789abc";
	
	public GCMIntentService() {
		super(senderId);
	}

	@Override
	protected void onError(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMessage(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onRegistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
