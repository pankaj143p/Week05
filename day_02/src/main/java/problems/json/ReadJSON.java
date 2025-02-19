package problems.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

class Person {
    private String name;
    private String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class ReadJSON {
    public static void main(String[] args) throws Exception {
       try{
           File file = new File("data.json");
           ObjectMapper mapper = new ObjectMapper();
           Person p = mapper.readValue(file,Person.class);
           System.out.println(p.getName());
           System.out.println(p.getEmail());
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}
