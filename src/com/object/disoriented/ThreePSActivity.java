package com.object.disoriented;

import java.util.Random;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ThreePSActivity extends Activity {
	/** Called when the activity is first created. */
	private Button btnBuy;
	private Button btnReceipt;
	private String user = "1";
	private String TAG = "3PS Buyer Screen";
	
	@Override

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buyer_start);

		btnBuy = (Button) findViewById(R.id.btnBuy);
		btnBuy.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v(TAG,"Buy button pressed");
				Toast.makeText(ThreePSActivity.this, "Buy Button clicked!", Toast.LENGTH_SHORT).show();

				Intent intent = new Intent("com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);
				//tryrtutr
			}
		});

		btnReceipt = (Button) findViewById(R.id.btnReceipt);
		btnReceipt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


				Log.v(TAG,"Receipt button pressed");
				Toast.makeText(ThreePSActivity.this, "Receipt Button clicked!", Toast.LENGTH_SHORT).show();		
			}
		});
        
    }
	DB newConnection = new DB();
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
            	Log.v(TAG, "gets here");
                String contents = intent.getStringExtra("SCAN_RESULT");
                
                Log.v(TAG, "gets here2");
                try{
                	String url = "http://128.61.105.48/session.php";
                	String charset = "UTF-8";
                	String param1 = contents;
                	String param2 = user;
                	
                	String query = "QRinput=" + param1 + "&user_id=" + param2;
                	URLConnection con = new URL(url +"?" + query).openConnection();
                	con.setRequestProperty("Accept-Charset", charset);

                	Log.v(TAG, url + "?" + query);
                	

                } catch (SQLException e) {
                	e.printStackTrace();
                } catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                Log.v(TAG,contents);
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }
    public String genSessId(){
    	String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	Random rnd = new Random();

   	   	StringBuilder sb = new StringBuilder( 40 );
   	   	for( int i = 0; i < 40; i++)
   	   		sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
   	   	return sb.toString();

    }
	

}