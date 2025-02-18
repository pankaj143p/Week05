package problems.csv.advance;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/*
Detect Duplicates in a CSV File
Read a CSV file and detect duplicate entries based on the ID column.
Print all duplicate records.

 */
public class DetectDuplicate {
    public static void main(String[] args) throws IOException, CsvValidationException {
        try{
            CSVReader csvReader = new CSVReader(new FileReader("dupcontains.csv"));
            String arr[];
            HashSet<String> set=new HashSet<>();
            while((arr=csvReader.readNext())!=null){

                if(set.contains(arr[0])){
                    System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
                }
                else{
                    set.add(arr[0]);
                }
            }
        }
        catch (IOException  e){
            e.printStackTrace();
        }
    }
}
