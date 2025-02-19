package problems.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeTwoJSON {
    public static void main(String[] args) throws IOException {
        File file1 = new File("j1.json");
        File file2 = new File("j2.json");
        ObjectMapper om = new ObjectMapper();
        JsonNode node1 = om.readTree(file1);
        JsonNode node2 = om.readTree(file2);
        ObjectNode node3 = (ObjectNode) node1.deepCopy();
        node3.setAll((ObjectNode) node2);
        om.writeValue(new File("merge.json"), node3);
        System.out.println("merge.json created successfully");
        System.out.println(node3);

    }
}
