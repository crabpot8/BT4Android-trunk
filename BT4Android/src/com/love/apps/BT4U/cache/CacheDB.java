package com.love.apps.BT4U.cache;

import android.content.Context;
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
		b.append("id          INTEGER,");
		b.append("resultTime  INTEGER,");
		b.append("requestType TEXT,");
		b.append("paramOne    TEXT,");
		b.append("paramTwo    TEXT,");
		b.append("paramThree  TEXT,");
		b.append("response    TEXT");
		b.append(");");

		db.execSQL(b.toString());
	}
	
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE cache");
		onCreate(db);
	}
}
