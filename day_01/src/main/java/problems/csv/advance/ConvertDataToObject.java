package problems.csv.advance;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private String stream;
    private double totalMarks;
    public Student(int id, String name, String stream, double totalMarks) {
        this.id = id;
        this.name = name;
        this.stream = stream;
        this.totalMarks = totalMarks;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getstream() {
        return stream;
    }
    public double gettotalMarks() {
        return totalMarks;
    }
}

public class ConvertDataToObject {

    public static void main(String[] args) throws IOException{
        List<Student> students=new ArrayList<>();
      try{
          CSVReader csvReader=new CSVReader(new FileReader("studentsfile.csv"));
          String[] arr;
          csvReader.readNext();
          while ((arr = csvReader.readNext()) != null) {
              students.add(new Student(Integer.parseInt(arr[0]),arr[1],arr[2],Double.parseDouble(arr[3])));
          }
          csvReader.close();
      } catch (IOException | CsvValidationException e){
          e.printStackTrace();
      }
        System.out.println("Student Details : ");
        System.out.println("ID | Name | Stream | Total Marks");
      for(Student student:students){
            System.out.println(student.getId()+" | "+student.getName()+" | "+student.getstream()+" | "+student.gettotalMarks());
        }
    }
}
