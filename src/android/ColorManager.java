package com.belle.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;

public class ColorManager extends CordovaPlugin {

	private static final String LOG_TAG = "ColorManager";
	public ColorManager() {}

	@Override
	public void onDestroy() {
		Log.i(LOG_TAG, "onDestroy");
	}

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		Log.d(LOG_TAG, "JS-Action: " + action);

	    if (action.equalsIgnoreCase("showRed")) {
			cordova.getThreadPool().execute(new Runnable() {
				public void run() { 
					FileUtil.showColor("red"); 
				}
			});

		} else if (action.equalsIgnoreCase("showGreen")) {
			cordova.getThreadPool().execute(new Runnable() {
				public void run() { 
					FileUtil.showColor("green"); 
				}
			});

		} else if (action.equalsIgnoreCase("showOrange")) {
			cordova.getThreadPool().execute(new Runnable() {
				public void run() { 
					FileUtil.showColor("orange"); 
				}
			});

		} else if(action.equalsIgnoreCase("closeColor")) {

			cordova.getThreadPool().execute(new Runnable() {
				public void run() { 
					FileUtil.closeColor(); 
				}
			});
			 

		} else {
			return false;
		}

		return true;
	}
 

}
