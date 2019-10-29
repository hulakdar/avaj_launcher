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
		if (args.length < 1)
		{
			usage();
			return;
		}
		String filename = args[0];
		ParsedInfo info;
		try {
			info = new ParsedInfo(filename);
        } catch (ParsedInfo.ParsingErrorException e) {
			System.err.println("File is invalid.");
			System.err.println(e.getMessage());
			return;
        } catch (Exception e) {
			System.err.println("Exception occurred trying to read file " + filename);
			return;
		}
		long frameCount = info.getFrameCount();
		Logger.open("simulation.txt");
		if (!Logger.valid())
		{
			System.err.println("Couldn't open file simulation.txt for writing");
			return;
		}
		for (Flyable flyable : info.getAircrafts())
			flyable.registerTower(tower);
		for (long i = 0; i < frameCount; i++)
		{
			tower.conditionsChanged();
			WeatherProvider.getProvider().step();;
		}
		Logger.flushAndClose();
	}
}
