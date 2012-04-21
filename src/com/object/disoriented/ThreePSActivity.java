package com.object.disoriented;

import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import android.app.Activity;
import android.content.Intent;
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
	private String sess_id;
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
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                String sess_id = genSessId();
                String[] QRvals = contents.split(";");
                String sq1 = "INSERT INTO session (SessionId, buyer, seller) VALUES ('"+sess_id+"','"+QRvals[0]+"','"+user+"')";
                /*try{
                	Statement stmt = con.createStatement();
                	System.err.println(sql);
                	ResultSet rs = stmt.executeQuery(sql);
                } catch (SQLException e) {
                	e.printStackTrace();
                }*/
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