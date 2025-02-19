package problems.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Car{
    String name;
    int price;
    String color;

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getColor() {
        return color;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setColor(String color) {
        this.color = color;
    }
}

public class ConvertToJson {
    public static void main(String[] args) throws JsonProcessingException {
        Car car = new Car();
        car.setName("BMW");
        car.setPrice(100000);
        car.setColor("Red");
        ObjectMapper mapper = new ObjectMapper();
        String details = mapper.writeValueAsString(car);
        System.out.println(car);
    }
}
