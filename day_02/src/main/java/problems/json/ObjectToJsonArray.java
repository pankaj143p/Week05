package problems.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;

public class ObjectToJsonArray {
    public static void main(String[] args) throws Exception {
        List<Student1> studentList = new ArrayList<>();
        studentList.add(new Student1("John", 25));
        studentList.add(new Student1("Jane", 22));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(studentList);
        System.out.println(json);
    }
}

class Student1 {
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
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
}
