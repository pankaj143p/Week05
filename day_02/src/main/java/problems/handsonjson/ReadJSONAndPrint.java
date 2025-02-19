package problems.handsonjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
public class ReadJSONAndPrint {

    public static void main(String[] args) throws Exception {
        String filePath = "data.json";

        ObjectMapper objectMapper = new ObjectMapper();


        JsonNode jsonNode = objectMapper.readTree(new File(filePath));
        if(jsonNode.isArray()){
            for (JsonNode element  : jsonNode){
                Iterator<Map.Entry<String,JsonNode>> iterator = element.fields();

                while (iterator.hasNext()){
                    Map.Entry<String , JsonNode> field = iterator.next();
                    System.out.println("key : " + field.getKey() + " : value :" + field.getValue());
                }
                System.out.println();
            }
        }
    }
}
