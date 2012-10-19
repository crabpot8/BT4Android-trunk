package com.love.apps.BT4U.cache;

import java.util.List;

import com.love.apps.BT4U.datastructures.Bus;
import com.love.apps.BT4U.datastructures.BusStop;
import com.love.apps.BT4U.datastructures.Route;
import com.love.apps.BT4U.datastructures.ScheduledDeparture;
import com.love.apps.BT4U.datastructures.ScheduledStop;

/**
 * An empty class for cache results. Does nothing by default, users can subclass
 * the exact methods they would like to receive results for
 * 
 * @author Hamilton Turner
 * 
 */
public class BaseCacheListener {

	public void onRunningBusUpdate(CacheResult<List<Bus>> update) {

	}
	
	public void onActiveRouteCodeUpdate(CacheResult<List<String>> update) {
		
	}
	
	public void onScheduledStopsForRouteUpdate(CacheResult<List<ScheduledStop>> update) {
		
	}
	
	public void onScheduledDeparturesFromStopUpdate(CacheResult<List<ScheduledDeparture>> update) {
		
	}
	
	public void onAllActiveRoutePathsUpdate(CacheResult<List<Route>> update) {
		
	}
	
	public void onRouteCodesForStopUpdate(CacheResult<List<String>> update) {
		
	}
	
	public void onStopsForRouteUpdate(CacheResult<List<BusStop>> update) {
		
	}
}
