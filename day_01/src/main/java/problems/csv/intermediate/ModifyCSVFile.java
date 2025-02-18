package problems.csv.intermediate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
Modify a CSV File (Update a Value)
Read a CSV file and increase the salary of employees from the "IT" department by 10%.
Save the updated records back to a new CSV file.
*/
public class ModifyCSVFile {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("csvfile.csv"));
             BufferedWriter bw = new BufferedWriter(new java.io.FileWriter("updatedfile.csv"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                if (arr[2].equalsIgnoreCase("IT")) {
                    int salary = Integer.parseInt(arr[3]);
                    salary = (int) (salary * 1.1);
                    arr[3] = String.valueOf(salary);
                }
                System.out.println(Arrays.toString(arr));
                bw.write(String.join(",", arr) + "\n");
            }
            System.out.println("File written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
