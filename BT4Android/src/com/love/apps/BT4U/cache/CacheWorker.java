package com.love.apps.BT4U.cache;

import java.util.List;

import android.app.DownloadManager.Request;
import android.content.Context;
import android.os.AsyncTask;

import com.love.apps.BT4U.datastructures.Bus;
import com.love.apps.BT4U.webservice.BT4U;

/**
 * Handles 1) verifying internet connectivity, 2) executing network requests
 * using the BT4U API and 3) Storing the result into the database
 * 
 * @author hamiltont
 * 
 */
public class CacheWorker extends AsyncTask<WebRequest, Void, CacheResult> {

	private Context mContext;

	public CacheWorker(Context contextForDatabase) {
		mContext = contextForDatabase;
	}

	@Override
	protected CacheResult doInBackground(WebRequest... params) {

		WebRequest r = params[0];

		BT4U webservice = BT4U.getService();

		switch (r.mType) {
		case RunningBuses:
			List<Bus> buses = webservice.getRunningBuses();
			for (Bus b : buses)

				break;
		case ActiveRouteCodes:
			break;

		}

		return null;
	}
}
