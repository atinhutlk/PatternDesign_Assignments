import java.io.*;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName = "default.txt";

    private Logger() {
        open();
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    private void open() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error opening file");
        }
    }

    public void setFileName(String name) {
        close();          
        fileName = name;  
        open();           
    }

    public void write(String msg) {
        try {
            writer.write(msg);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing");
        }
    }

    public void close() {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            System.out.println("Error closing file");
        }
    }
}
