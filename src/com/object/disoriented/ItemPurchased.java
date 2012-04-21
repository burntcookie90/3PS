/**
 * 
 */
package com.object.disoriented;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

/**
 * @author vishnu
 *
 */
public class ItemPurchased extends Activity {
	private ImageButton imgBtnPurchase;
	
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_purchased);
		
		imgBtnPurchase = (ImageButton)findViewById(R.id.imgBtnPurchased);
		imgBtnPurchase.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ItemPurchased.this,ThreePSActivity.class);
				startActivity(i);
			}
		});
	}
}
