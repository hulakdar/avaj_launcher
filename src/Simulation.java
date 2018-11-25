//package org.avaj.simulation;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.io.File;

public class Simulation
{
	private static void usage()
	{

	}
	public static void main(String args[])
	{
		if (args.length < 2)
		{
			usage();
			return;
		}
		String filename = args[1];
		System.out.println("start");
		ParsedInfo info;
		try {
			info = new ParsedInfo(filename);
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return;
		}

		System.out.println(info.getFrameCount());
		System.out.println("end");
	}
}
