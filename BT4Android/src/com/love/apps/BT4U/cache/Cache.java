package com.love.apps.BT4U.cache;

import java.util.List;

import com.love.apps.BT4U.webservice.Bus;
import com.love.apps.BT4U.webservice.BusStop;
import com.love.apps.BT4U.webservice.Route;
import com.love.apps.BT4U.webservice.ScheduledDeparture;
import com.love.apps.BT4U.webservice.ScheduledStop;

public class Cache {

	public static Cache get() {
		return new Cache();
	}

	public CacheResult<List<Bus>> getRunningBuses(BaseCacheListener callback) {

	}

	public CacheResult<List<String>> getActiveRouteCodes(
			BaseCacheListener callback) {

	}

	public CacheResult<List<ScheduledStop>> getScheduledStopsForRoute(
			String route, BaseCacheListener callback) {

	}

	public CacheResult<List<ScheduledDeparture>> getScheduledDeparturesFromStop(
			String routeCode, int stopCode, BaseCacheListener callback) {

	}

	public CacheResult<List<Route>> getAllActiveRoutePaths() {

	}

	public CacheResult<List<String>> getRouteCodesForStop(int stop,
			BaseCacheListener callback) {

	}

	public CacheResult<List<BusStop>> getStopsForRoute(String routeCode,
			BaseCacheListener callback) {

	}

}
