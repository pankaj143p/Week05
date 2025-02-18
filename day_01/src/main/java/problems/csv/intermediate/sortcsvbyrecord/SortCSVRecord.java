package problems.csv.intermediate.sortcsvbyrecord;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class SortCSVRecord {
    public static void main(String[] args) throws Exception {
        int cnt=0;
        ArrayList<Employee> empList = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader("csvfile.csv"))){
            String [] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {

                if(cnt>0){
                   empList.add(new Employee(Integer.parseInt(nextRecord[0]),nextRecord[1],nextRecord[2],Double.parseDouble(nextRecord[3])));
                }
                cnt++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        empList.sort((Employee e1,Employee e2)->Double.compare(e2.getSalary(),e1.getSalary()));
        System.out.println("Sorted by Salary");
        System.out.println("ID | Department | Name | Salary");
        int cnt1=0;
        for(Employee emp:empList){
            if(cnt1>4){
                break;
            }
            System.out.println(emp.getId()+" | "+emp.getDepartment()+" | "+emp.getName()+" | "+emp.getSalary());
            cnt1++;
        }
    }
}
