package avaj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
    static BufferedWriter writer;
    static public boolean valid() { return writer != null; }

    static public void log(String line)
    {
        try {
            writer.write(line + "\n");
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    static public void open(String fileName)
    {
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    static public void flushAndClose()
    {
        try {
            writer.close();
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void finalize() throws Throwable {
        writer.close();
        super.finalize();
    }
}