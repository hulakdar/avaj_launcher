import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.MatchResult;

import com.sun.java_cup.internal.runtime.Scanner;

class ParsedInfo
{
    private long frameCount;
    private ArrayList<Aircraft> aircrafts;

    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public long getFrameCount() {
        return frameCount;
    }

    ParsedInfo (String filename) throws FileNotFoundException, IOException
    {
        ArrayList<String> records = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        Scanner s = new Scanner(line);
		s.findInLine("(\\d+)");
        MatchResult result = s.match();
        this.frameCount = Integer.parseInt(result.group(1));

        while ((line = reader.readLine()) != null) {
            records.add(line);
        }
        reader.close();
    }
}