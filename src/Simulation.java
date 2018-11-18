import java.util.Scanner;
import java.util.regex.MatchResult;
import java.io.File;

public class Simulation
{
	public static void main(String args[])
	{
		String input = "29";
		Scanner s = new Scanner(input);
		s.findInLine("(\\d+)");
		MatchResult result = s.match();

		System.out.println("start");
		System.out.println(result.group(1));
		System.out.println("end");
	}
}
