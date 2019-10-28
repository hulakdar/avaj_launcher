package avaj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger
{
    static Logger logger = new Logger("simulation.txt");
    static Logger get() { return logger; }
    BufferedWriter writer;

    Logger(String fileName)
    {
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public boolean valid() { return writer != null; }

    public void log(String line)
    {
        try {
            writer.write(line + "\n");
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public void flushAndClose()
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