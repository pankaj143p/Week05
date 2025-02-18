package problems.csv.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args) throws IOException {
        try{
         BufferedReader br = new BufferedReader(new FileReader("csvfile.csv"));
         String line;
         while ((line = br.readLine()) != null) {
             String arr[] = line.split(",");
             System.out.println(arr[0]+" | "+arr[1]+" | "+arr[2]+" | "+arr[3]);
         }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
