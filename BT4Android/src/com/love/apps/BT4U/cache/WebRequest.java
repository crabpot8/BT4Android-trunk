package com.love.apps.BT4U.cache;

public class WebRequest {

	public enum TYPE {
		RunningBuses, ActiveRouteCodes, ScheduledStops, ScheduledDepartures, ActiveRoutePaths, RouteCodesForStop, StopsForRoute
	}

	public TYPE mType;
	public Object[] mParams;
	BaseCacheListener callback;


	public WebRequest(TYPE requestType) {
		mType = requestType;
	}

	
	public WebRequest(TYPE requestType, Object[] params) {
		mType = requestType;
		mParams = params;
	}
	
	public void setCallback(BaseCacheListener listener) {
		callback = listener;
	}
	
	public BaseCacheListener getCallback() {
		return callback;
	}
	
}
