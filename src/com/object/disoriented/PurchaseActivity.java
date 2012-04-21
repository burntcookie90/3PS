package com.object.disoriented;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class PurchaseActivity extends Activity {
	private ArrayList<String> qrContents;
	private final String TAG = "purchase-activity";
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.purchase_screen);
		
		Intent intent = getIntent();
		qrContents = intent.getStringArrayListExtra("qr_contents");
		
		for(int i = 0; i<qrContents.size();i++){
			Log.v(TAG,qrContents.get(i));
		}
	}
}
