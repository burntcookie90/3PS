package com.object.disoriented;

import android.app.Activity;
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
}