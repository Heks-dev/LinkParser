package ua.com.parser.htmlparser;

/**
 * Created by vadim on 15.01.17.
 */
public class Main {
    public static void main(String[] args) {
        checkArgs(args);
        FileWorker fileWorker = new FileWorkerImpl();
        try {
            LinkCollector collector = new LinkCollector(fileWorker.read(args[0]));
            fileWorker.write(collector.getLinks());
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    private static void checkArgs(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Incorrect number input parameters\n" +
                    "You must input two path of file:\n" +
                    "The first file should contain conditions for comparison\n" +
                    "The second file for output data");
        }
    }
}