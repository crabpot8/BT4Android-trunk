package com.love.apps.BT4U.datastructures;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * A single named bus stop
 * 
 * @author Hamilton Turner
 *
 */
@XStreamAlias("ScheduledStops")
public class BusStop {
	@XStreamAlias("StopName")
	public String name;
	
	@XStreamAlias("StopCode")
	public int stopCode;
}
