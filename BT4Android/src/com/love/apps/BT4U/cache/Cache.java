package com.love.apps.BT4U.cache;

import java.util.List;

import android.content.Context;

import com.love.apps.BT4U.cache.WebRequest.TYPE;
import com.love.apps.BT4U.datastructures.Bus;
import com.love.apps.BT4U.datastructures.BusStop;
import com.love.apps.BT4U.datastructures.Route;
import com.love.apps.BT4U.datastructures.ScheduledDeparture;
import com.love.apps.BT4U.datastructures.ScheduledStop;
import com.love.apps.BT4U.webservice.BT4U;

public class Cache {
	private Context mContext;

	public Cache(Context c) {
		mContext = c.getApplicationContext();
	}

	public CacheResult<List<Bus>> getRunningBuses(BaseCacheListener callback) {
		CacheWorker cw = new CacheWorker(mContext);

		// Check DB for current data
		
		
		if (callback != null) {
			WebRequest request = new WebRequest(TYPE.RunningBuses);
			request.setCallback(callback);
			cw.execute(request);
		}

	}
	/*
	 * public CacheResult<List<String>> getActiveRouteCodes( BaseCacheListener
	 * callback) {
	 * 
	 * }
	 * 
	 * public CacheResult<List<ScheduledStop>> getScheduledStopsForRoute( String
	 * route, BaseCacheListener callback) {
	 * 
	 * }
	 * 
	 * public CacheResult<List<ScheduledDeparture>>
	 * getScheduledDeparturesFromStop( String routeCode, int stopCode,
	 * BaseCacheListener callback) {
	 * 
	 * }
	 * 
	 * public CacheResult<List<Route>> getAllActiveRoutePaths() {
	 * 
	 * }
	 * 
	 * public CacheResult<List<String>> getRouteCodesForStop(int stop,
	 * BaseCacheListener callback) {
	 * 
	 * }
	 * 
	 * public CacheResult<List<BusStop>> getStopsForRoute(String routeCode,
	 * BaseCacheListener callback) {
	 * 
	 * }
	 */

}
