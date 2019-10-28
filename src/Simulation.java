package avaj;

import java.util.Scanner;
import java.util.regex.MatchResult;

import avaj.Logger;

import java.io.File;

public class Simulation
{
	private static WeatherTower tower = new WeatherTower();
	private static void usage()
	{
		System.err.println("One and only argument should be file with simulation data.");
	}
	public static void main(String args[])
	{
		if (!Logger.get().valid())
		{
			System.err.println("Couldn't open file simulation.txt for writing");
			return;
		}
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
			System.err.println("Exception occurred trying to read file.\n" + e.getMessage());
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
		Logger logger = Logger.get();
		logger.flushAndClose();
	}
}
