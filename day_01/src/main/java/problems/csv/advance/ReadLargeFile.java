package problems.csv.advance;
import java.io.*;
import java.nio.file.*;

public class ReadLargeFile {

    public static void main(String[] args) throws IOException {
        String largeCSVFilePath = "large_file.csv";
        createLargeCSVFile(largeCSVFilePath, 11000000);
        processLargeCSVFile(largeCSVFilePath);
        deleteFile(largeCSVFilePath);
    }

    private static void createLargeCSVFile(String filePath, int numRecords) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write("ID,Name,Age,Email");
            writer.newLine();
            for (int i = 1; i <= numRecords; i++) {
                writer.write(i + ",Name" + i + "," + (20 + i % 50) + ",email" + i + "@gmail.com");
                writer.newLine();
            }
        }
    }

    private static void processLargeCSVFile(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            int count = 0;
            int processedCount = 0;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                count++;
                processedCount++;
                if (count == 100) {
                    System.out.println("Processed " + processedCount + " records.");
                    count = 0;
                }
            }
            if (count > 0) {
                System.out.println("Processed " + processedCount + " records.");
            }
        }
    }

    private static void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.deleteIfExists(path);
    }
}
