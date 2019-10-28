package avaj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class ParsedInfo
{
    private class ParsingErrorException extends Exception {
        ParsingErrorException(String message) {
            super(message);
        }
    }

    private long frameCount;
    private ArrayList<Flyable> aircrafts = new ArrayList<>();

    public ArrayList<Flyable> getAircrafts() {
        return aircrafts;
    }

    public long getFrameCount() {
        return frameCount;
    }

    ParsedInfo(String filename) throws FileNotFoundException, IOException, ParsingErrorException, NumberFormatException {
        ArrayList<String> records = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        {
            Scanner s = new Scanner(line);
            s.findInLine("(\\d+)");
            MatchResult result = s.match();
            this.frameCount = Integer.parseInt(result.group(1));
            s.close();
            if (this.frameCount <= 0)
                throw new ParsingErrorException("Frame count is invalid.");
        }

        while ((line = reader.readLine()) != null) {
            Scanner s = new Scanner(line);
            s.useDelimiter(" ");
            String entries[] = new String[5];
            int i = 0;
            while (s.hasNext())
            {
                if (i >= 5)
                {
                    s.close();
                    throw new ParsingErrorException("Too much stuff in one line");
                }
                entries[i++] = s.next();
            }
            if (i < 5)
            {
                s.close();
                throw new ParsingErrorException("Too little stuff in one line: " + line);
            }

            s.close();
            int longitude = Integer.parseInt(entries[2]);
            int latitude = Integer.parseInt(entries[3]);
            int height = Integer.parseInt(entries[4]);
            try {
                aircrafts.add(AircraftFactory.newAircraft(entries[0], entries[1], longitude, latitude, height));
            } catch (Exception e) {
                System.err.format("Exception occurred trying to create new '%s' named '%s'\n", entries[0], entries[1]);
                System.err.println(e.getMessage());
                return;
            }
        }
        reader.close();
    }
}