package com.love.apps.BT4U.cache;

import java.util.HashMap;
import java.util.Map.Entry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.love.apps.BT4U.datastructures.Bus;

public class CacheDB extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	// Object[][] table = {{"bus", Bus.class}, {"bus", Bus.class}};

	HashMap<String, Class<? extends Cacheable>> tables = new HashMap<String, Class<? extends Cacheable>>();

	public CacheDB(Context context) {
		super(context, "BT4U", null, DATABASE_VERSION);

		tables.put("bus", Bus.class);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		for (String tableName : tables.keySet()) {
			Class<? extends Cacheable> c = tables.get(tableName);
			try {
				Cacheable object = c.newInstance();
				db.execSQL(object.getCreateTableSQL(tableName));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		for (String tableName : tables.keySet())
			db.execSQL("DROP TABLE " + tableName);

		onCreate(db);
	}

	// black, small light jacket long sleeves, hood, similar to hoodie. stretchy black cottony fabric. Look in sherry's room or in the kitchen on the loveseat   
	
	public void insert(Cacheable data) {
		Class<? extends Cacheable> c = data.getClass();
		String tableName = "";
		for (Entry<String, Class<? extends Cacheable>> entry : tables.entrySet()) {
			if (entry.getValue().isInstance(data))
			{
				tableName = entry.getKey();
				break;
			}
		}
		
		// TODO check tablename is not null
		
		SQLiteDatabase db = getWritableDatabase();
		db.insert(tableName, null, data.getDatabaseInsert());
		db.close();
	}
}
