/**
 * 
 */
package com.object.disoriented;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.item_purchased_menu, menu);
	        return true;
	    }	
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle item selection
	    	Intent intent = new Intent(Intent.ACTION_MAIN);
	    	intent.addCategory(Intent.CATEGORY_HOME);
	    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    	startActivity(intent);
	    	return true;
	    }
}
