package com.love.apps.BT4U.cache;

import java.util.List;

import android.app.DownloadManager.Request;
import android.content.Context;
import android.os.AsyncTask;

import com.love.apps.BT4U.datastructures.Bus;
import com.love.apps.BT4U.webservice.BT4U;

/**
 * Handles 1) verifying Internet connectivity, 2) executing network requests
 * using the BT4U API and 3) Storing the result into the database
 * 
 * @author hamiltont
 * 
 */
public class CacheWorker extends AsyncTask<CacheRequest, Void, CacheResult> {

	private Context mContext;

	public CacheWorker(Context contextForDatabase) {
		mContext = contextForDatabase;
	}

	@Override
	protected CacheResult doInBackground(CacheRequest... params) {

		CacheRequest request = params[0];

		// Get result from web
		CacheResult result = getResult(request);
		if (result == null)
			return null;
		
		// Persist to database
		CacheDB db = new CacheDB(mContext);
		
		

		return result;
	}

	private CacheResult getResult(CacheRequest request) {
		BT4U webservice = BT4U.getService();
		CacheResult result = new CacheResult();

		try {
			switch (request.mType) {

			case RunningBuses:
				List<Bus> buses = webservice.getRunningBuses();
				result.result = buses;
				break;

			case ActiveRouteCodes:
				break;

			}

			result.age = System.currentTimeMillis();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
