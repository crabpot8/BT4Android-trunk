package com.love.apps.BT4U.cache;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CacheDB extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	public CacheDB(Context context) {
		super(context, "BT4U", null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		StringBuffer b = new StringBuffer("CREATE TABLE cache (");
		b.append("id          INTEGER PRIMARY KEY AUTOINCREMENT,");
		b.append("recordTime  INTEGER,");
		b.append("requestType TEXT,");
		b.append("paramOne    TEXT,");
		b.append("paramTwo    TEXT,");
		b.append("response    TEXT");
		b.append(");");

		db.execSQL(b.toString());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE cache");
		onCreate(db);
	}

	/**
	 * Searches the cache for any data matching the request. If data is found it
	 * is returned in an unparsed form
	 * 
	 * @return
	 */
	public CacheResult get(CacheRequest r) {
		Cursor results = getReadableDatabase().query(
				"cache",
				new String[] { "id", "recordTime", "response" },
				"requestType=? and paramOne=? and paramTwo=?",
				new String[] { r.requestType,
						r.params[0] == null ? "" : r.params[0],
						r.params[1] == null ? "" : r.params[1] }, null, null,
				"resultTime desc");

		if (!results.moveToFirst())
			return null;

		// Check that the record is valid
		long recordTime = results.getLong(results.getColumnIndex("recordTime"));
		long recordAge = System.currentTimeMillis() - recordTime;
		if (recordAge > r.allowedAge)
			return null;
		
		CacheResult result = new CacheResult();
		result.age = recordTime;
		result.unparsedResult = results.getString(results.getColumnIndex("response"));
		
		return result;
	}
}
