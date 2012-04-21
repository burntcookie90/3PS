package com.object.disoriented;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class ReceiptActivity extends Activity {
	private TextView receipt;
	String receiptText;
	private String itemName;
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.receipt_view);

		receipt = (TextView)findViewById(R.id.txtReceipt);

		for(String s: ThreePSActivity.itemList.getItemSet().keySet()){
				if(Integer.parseInt(s)==66){
					itemName = "Coke";
				}
				else if(Integer.parseInt(s)==24){
					itemName = "Cookies";
				}
				else if(Integer.parseInt(s)==8){
					itemName = "BlowPops";
				}
				else if(Integer.parseInt(s)==45){
					itemName = "Sunglasses";
				}
				else if(Integer.parseInt(s)==55){
					itemName = "Laptop";
				}
				receiptText += "\n"+itemName + " " +  ": $" + ThreePSActivity.itemList.getItemSet().get(s) + "\n";
		}

		receipt.setText(receiptText);
	}
}
