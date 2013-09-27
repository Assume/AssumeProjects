package org.assume.api.flightchecking;

import java.util.ArrayList;

import org.assume.api.types.Flight;

public class FlightUtil
{

	
	public static void scheduleAll(ArrayList<Flight> flights)
	{
		for(Flight f : flights)
		{
			f.schedule();
		}
	}

}
