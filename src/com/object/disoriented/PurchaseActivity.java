package com.object.disoriented;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
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
	private String sessID;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.purchase_screen);
		
		Intent intent = getIntent();
		qrContents = new ArrayList<String>();
		for(int i = 0; i<intent.getStringArrayListExtra("qr_contents").size();i++){
			qrContents.add(intent.getStringArrayListExtra("qr_contents").get(i));
		}
		
		sessID = intent.getStringExtra("sess_id");
		
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
				try{
					Log.v(TAG, "gets to purchase BTN");
                	String url = "http://128.61.105.48/session.php";
                	String charset = "UTF-8";
                	String param1 = sessID;
                	String query = "sess_id=" + param1;
                	String users = "";
                	String[] usersArr = new String[2];
                	URLConnection con = new URL(url +"?" + query).openConnection();
                	Log.v(TAG,url +"?" + query);
                	con.setRequestProperty("Accept-Charset", charset);
                	
                	InputStream retStream = con.getInputStream();
                	int d = 0;
                	while (d != -1){
                		d = retStream.read();
                		if(d != -1){
                			users += (char)d;
                		}
                	}
                	usersArr = users.split(";");
                	Log.v(TAG,users);
                	
                	param1 = usersArr[0];
                	String param2 = usersArr[1];
                	query = "buyer=" + param1 + "&seller=" + param2;
                	con = new URL(url +"?" + query).openConnection();
                	con.setRequestProperty("Accept-Charset", charset);
				} catch (SQLException e) {
                	e.printStackTrace();
                } catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
