package com.love.apps.BT4U.datastructures;

import android.content.ContentValues;

import com.love.apps.BT4U.cache.Cacheable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * Holds real-time information on a BTransit bus.
 * 
 * @author hamiltont
 * 
 */
@XStreamAlias("RTFInfo")
public class Bus implements Cacheable {

	/** A unique identifier for this vehicle in this agency (btransit) */
	@XStreamAlias("AgencyVehicleName")
	@XStreamConverter(value = IntConverter.class)
	public int agencyVehicleName;

	/** The short (3 or 4 character) code for this route, such as HWD */
	@XStreamAlias("RouteShortName")
	@XStreamConverter(value = StringConverter.class)
	public String routeCode;

	@XStreamAlias("TripStartTime")
	@XStreamConverter(value = StringConverter.class)
	public String tripStartTime;

	@XStreamAlias("TripPointName")
	@XStreamConverter(value = StringConverter.class)
	public String tripPointName;

	@XStreamAlias("StopCode")
	@XStreamConverter(value = IntConverter.class)
	public int stopCode;

	@XStreamAlias("IsTimePoint")
	@XStreamConverter(value = StringConverter.class)
	public String isTimePoint;

	@XStreamAlias("LatestEvent")
	@XStreamConverter(value = StringConverter.class)
	public String latestEvent;

	@XStreamAlias("LatestRSAEvent")
	@XStreamConverter(value = StringConverter.class)
	public String latestRSAEvent;

	@XStreamAlias("Latitude")
	@XStreamConverter(value = DoubleConverter.class)
	public double latitude;

	@XStreamAlias("Longitude")
	@XStreamConverter(value = DoubleConverter.class)
	public double longitude;

	@XStreamAlias("Direction")
	@XStreamConverter(value = IntConverter.class)
	public int direction;

	@XStreamAlias("Speed")
	@XStreamConverter(value = IntConverter.class)
	public int speed;

	@XStreamAlias("TotalCount")
	@XStreamConverter(value = IntConverter.class)
	public int totalCount;
	
	public String getCreateTableSQL(String tableName) {
		StringBuffer b = new StringBuffer("CREATE TABLE " + tableName + " (");
		b.append("vehicleId INTEGER,");
		b.append("routeCode TEXT,");
		b.append("tripStart TEXT,");
		b.append("tripPoint TEXT,");
		b.append("stopCode  INTEGER,");
		b.append("timePoint TEXT,");
		b.append("latestEv  TEXT,");
		b.append("latestRSA TEXT,");
		b.append("latitude  REAL,");
		b.append("longitude REAL,");
		b.append("direction INTEGER,");
		b.append("speed     INTEGER,");
		b.append("totalCnt  INTEGER,");
		b.append(");");
		return b.toString();
	}

	public ContentValues getDatabaseInsert() {
		ContentValues values = new ContentValues();
		values.put("vehicleId", agencyVehicleName);
		values.put("routeCode", routeCode);
		values.put("tripStart", tripStartTime);
		values.put("tripPoint", tripPointName);
		values.put("stopCode", stopCode);
		values.put("timePoint", isTimePoint);
		values.put("latestEv", latestEvent);
		values.put("latestRSA", latestRSAEvent);
		values.put("latitude", latitude);
		values.put("longitude", longitude);
		values.put("direction", direction);
		values.put("speed", speed);
		values.put("totalCnt", totalCount);
		return values;
	}
}
