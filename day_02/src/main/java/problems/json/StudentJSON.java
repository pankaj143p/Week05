package problems.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int age;
    private List<String> skills; // List of skills

    // Constructor, getters, and setters
    public Student(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}

public class StudentJSON {
    public static void main(String[] args) {
     try{
         List<String> skills = Arrays.asList("Java", "Python", "SQL");
         Student student = new Student("John", 25, skills);
         ObjectMapper mapper = new ObjectMapper();
         String jsonString = mapper.writeValueAsString(student);
         System.out.println(jsonString);
     }
     catch(Exception e){
         e.printStackTrace();
     }
    }
}
