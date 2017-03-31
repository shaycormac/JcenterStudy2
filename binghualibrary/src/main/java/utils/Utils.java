package utils;

import android.util.Log;

/**
 * 什么吊东西
 */
public class Utils {

	static final String LOG_TAG = "PullToRefresh";
//注释也是最冷额
	public static void warnDeprecation(String depreacted, String replacement) {
		Log.w(LOG_TAG, "You're using the deprecated " + depreacted
				+ " attr, please switch over to " + replacement);
	}

}
