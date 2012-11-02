package com.love.apps.BT4U.cache;

import java.util.List;

import android.content.Context;

import com.love.apps.BT4U.cache.CacheRequest.TYPE;
import com.love.apps.BT4U.datastructures.Bus;
import com.love.apps.BT4U.datastructures.BusStop;
import com.love.apps.BT4U.datastructures.Route;
import com.love.apps.BT4U.datastructures.ScheduledDeparture;
import com.love.apps.BT4U.datastructures.ScheduledStop;
import com.love.apps.BT4U.webservice.BT4U;
import com.thoughtworks.xstream.XStream;

public class Cache {
	private Context mContext;

	public Cache(Context c) {
		mContext = c.getApplicationContext();
	}

	public CacheResult<List<Bus>> getRunningBuses(BaseCacheListener callback) {
		CacheWorker cw = new CacheWorker(mContext);

		// Build the request
		CacheRequest request = new CacheRequest("RunningBuses", CacheRequest.Age_Day, (String[]) null);
		
		// Check DB for current data
		CacheDB db = new CacheDB(mContext);
		CacheResult result = db.get(request);
		if (result != null) {
			
		}
		
		
		if (callback != null) {
			CacheRequest request = new CacheRequest();
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
