package com.love.apps.BT4U.cache;

public class CacheResult<T> {
	long ageInMilliseconds;
	T result;
	
	
	
	// Note: Can implement if we need. Use something like getAndSet on a static variable
	///** If the requester needs to keep track of the request, this identifies the exact request that was initiated */
	//int id;
}