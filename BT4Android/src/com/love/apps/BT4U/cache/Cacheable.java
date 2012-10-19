package com.love.apps.BT4U.cache;

import android.content.ContentValues;

public interface Cacheable {

	public ContentValues getDatabaseInsert();
	
	public String getCreateTableSQL(String table);
	
}
