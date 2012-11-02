package com.love.apps.BT4U.cache;

public class CacheRequest {

	String requestType;
	String[] params;

	/**
	 * The age in milliseconds before this type of request should be considered
	 * invalid
	 */
	long allowedAge;
	
	public static long Age_Day = 1000 * 60 * 60 * 24;

	BaseCacheListener callback;

	/**
	 * Creates a request for a result from the cache
	 * 
	 * @param request
	 *            Must be a string that equals one in the BT4U implementation,
	 *            such as "RunningBuses" or "ActiveRouteCodes"
	 * @param params
	 *            The parameters for the BT4U method. Maximum two parameters.
	 *            These will be parsed into the appropriate object types if the
	 *            request is executed. If the parsing fails (e.g. "A2" is passed
	 *            for a parameter that is expecting an integer) then the request
	 *            will fail
	 */
	public CacheRequest(String request, long validAge, String... params) {
		requestType = request;
		allowedAge = validAge;
	}

	public void setCallback(BaseCacheListener listener) {
		callback = listener;
	}

	public BaseCacheListener getCallback() {
		return callback;
	}

}
