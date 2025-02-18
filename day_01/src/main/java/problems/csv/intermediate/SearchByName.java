package problems.csv.intermediate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchByName {
    public static void main(String[] args)  throws IOException {
        String path = "csvfile.csv";
        String name = "Raj";
               try(BufferedReader br = new BufferedReader(new FileReader(path))) {
                   String line;
                   boolean found = false;
                   while((line=br.readLine())!=null){
                       String arr[]=line.split(",");
                       if(name.equalsIgnoreCase(arr[1])){
                           System.out.println(arr[2]+" | "+arr[3]);
                           found = true;
                       }
                   }
                   if(!found){
                       System.out.println("Name not found");
                   }
               }
               catch (IOException e){
                   e.printStackTrace();
               }
    }
}
