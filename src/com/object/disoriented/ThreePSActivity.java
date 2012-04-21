package com.object.disoriented;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class ThreePSActivity extends Activity {
	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	/** Called when the activity is first created. */
	private Button btnBuy;
	private Button btnReceipt;
	private String user = "1";
	private String sess_id;
	private String TAG = "3PS Buyer Screen";
	private ArrayList<String> qrContents;
	
	@Override

	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buyer_start);

		qrContents = new ArrayList<String>();
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
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
            	Log.v(TAG, "gets here");
                String contents = intent.getStringExtra("SCAN_RESULT");
                String[] QRvals = contents.split(";");
                String sess_id = "";
                StringTokenizer st = new StringTokenizer(contents,";");
                
                Log.v(TAG, "gets here2");
                
                while(st.hasMoreTokens()){
                	qrContents.add(st.nextToken());
                }
                
                try{
                	String url = "http://128.61.105.48/session.php";
                	String charset = "UTF-8";
                	String param1 = contents;
                	String param2 = user;
                	String query = "QRinput=" + param1 + "&user_id=" + param2;
                	URLConnection con = new URL(url +"?" + query).openConnection();
                	con.setRequestProperty("Accept-Charset", charset);

                	
                	InputStream sessionStream = con.getInputStream();
                	int d = 0;
                	while (d != -1){
                		d = sessionStream.read();
                		if(d != -1){
                			sess_id += (char)d;
                		}
                	}
                	Log.v(TAG, sess_id);
                	Log.v(TAG, url + "?" + query);
                	

                } catch (SQLException e) {
                	e.printStackTrace();
                } catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
                Log.v(TAG,contents);
                // Handle successful scan
                
                Intent i = new Intent(this,PurchaseActivity.class);
                i.putStringArrayListExtra("qr_contents", qrContents);
                i.putExtra("sess_id", sess_id);
                startActivity(i);
                
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