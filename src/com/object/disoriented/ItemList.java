/**
 * 
 */
package com.object.disoriented;

import java.util.HashMap;

/**
 * @author vishnu
 *
 */
public class ItemList {
	private HashMap<String,String> itemSet;
	
	public ItemList(){
		itemSet = new HashMap<String,String>();
	}

	public void addItem(String itemID, String itemValue){
		itemSet.put(itemID,itemValue);
	}
	
	public String getItem(String id){
		return itemSet.get(id);
	}
	/**
	 * @return the itemSet
	 */
	public HashMap<String, String> getItemSet() {
		return itemSet;
	}

	
	
}
