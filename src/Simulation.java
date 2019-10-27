package org.avaj.simulation;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.io.File;

public class Simulation
{
	private static WeatherTower tower = new WeatherTower();
	private static void usage()
	{
		System.out.println("One and only argument should be file with simulation data.");
	}
	public static void main(String args[])
	{
		if (args.length < 1)
		{
			usage();
			return;
		}
		String filename = args[0];
		ParsedInfo info;
		try {
			info = new ParsedInfo(filename);
        } catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.\n", filename);
			e.printStackTrace();
			System.err.println(e.getMessage());
			return;
		}
		long frameCount = info.getFrameCount();
		for (Flyable flyable : info.getAircrafts())
			flyable.registerTower(tower);
		for (long i = 0; i < frameCount; i++)
		{
			tower.conditionsChanged();
			WeatherProvider.getProvider().step();;
		}
	}
}
