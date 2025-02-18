package problems.csv.basic;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadAndCountRow {

    public static void main(String[] args) throws IOException {
        String filePath = "writecsv.csv"; // Path to your CSV file

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> allRows = reader.readAll();
            int rowCount = allRows.size() - 1;

            System.out.println("Number of records (excluding header): " + rowCount);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
