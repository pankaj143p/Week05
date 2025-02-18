package problems.csv.intermediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecord {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("csvfile.csv"))){
            String line;
            int cnt=0;
            while ((line=br.readLine()) != null) {
                String arr[]=line.split(",");
                if (cnt>0 && arr.length > 2) {
                    try {
                        int marks = Integer.parseInt(arr[2].trim());
                        if (marks >= 80) {
                            System.out.println(arr[0] + " | " + arr[1] + " | " + arr[2] + " | " + (arr.length > 3 ? arr[3] : ""));
                        }
                    }catch(NumberFormatException e) {
                        System.err.println("Invalid number format in marks column: " + arr[2]);
                    }
                }
                cnt++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
