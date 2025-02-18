package problems.csv.advance;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeTwoCSVs {
    public static void main(String[] args) throws Exception {

        try (CSVReader cr1 = new CSVReader(new FileReader("student1.csv"));
             CSVReader cr2 = new CSVReader(new FileReader("student2.csv"));
             CSVWriter cw = new CSVWriter(new FileWriter("mergestudents.csv"),
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END)) {

            String[] arr1;
            String[] arr2;

            // Skip the header rows
            cr1.readNext();
            cr2.readNext();

            String[] header = {"ID", "Name", "Age", "Marks", "Grade"};
            cw.writeNext(header);

            while ((arr1 = cr1.readNext()) != null) {
                String id1 = arr1[0];
                boolean matched = false;

                CSVReader cr2Copy = new CSVReader(new FileReader("student2.csv"));
                cr2Copy.readNext();
                while ((arr2 = cr2Copy.readNext()) != null) {
                    String id2 = arr2[0];

                    if (id1.equals(id2)) {

                        String[] mergedArr = new String[arr1.length + arr2.length - 1];
                        System.arraycopy(arr1, 0, mergedArr, 0, arr1.length);
                        System.arraycopy(arr2, 1, mergedArr, arr1.length, arr2.length - 1);
                        cw.writeNext(mergedArr);
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    System.out.println("No matching ID found for ID: " + id1);
                }
            }

            System.out.println("Merged CSV File Created Successfully");

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
