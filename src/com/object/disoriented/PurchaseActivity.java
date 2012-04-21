package com.object.disoriented;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PurchaseActivity extends Activity {
	private ArrayList<String> qrContents;
	private final String TAG = "purchase-activity";
	private TextView txtPrice;
	private TextView txtItemName;
	private TextView txtStoreName;
	private Button btnPurchase;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.purchase_screen);
		
		Intent intent = getIntent();
		qrContents = new ArrayList<String>();
		for(int i = 0; i<intent.getStringArrayListExtra("qr_contents").size();i++){
			qrContents.add(intent.getStringArrayListExtra("qr_contents").get(i));
		}
		
		Log.v(TAG,""+qrContents.size());
		for(int i = 0; i<qrContents.size();i++){
			String out = qrContents.get(i);
			Log.v(TAG,out);
		}
		
//		Log.v(TAG,qrContents.get(1));
		
		txtPrice = (TextView)findViewById(R.id.txtPrice);
		txtItemName = (TextView)findViewById(R.id.txtItemName);
		txtStoreName = (TextView)findViewById(R.id.txtStoreName);
		
		txtPrice.setText("$"+qrContents.get(1));
		Log.v(TAG,qrContents.get(1));
		txtItemName.setText("Item: "+qrContents.get(2));
		Log.v(TAG,qrContents.get(2));
		txtStoreName.setText("From Store: " + qrContents.get(0));
		Log.v(TAG,qrContents.get(0));
		
		btnPurchase = (Button)findViewById(R.id.btnPurchase);
		btnPurchase.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
