package britenet;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {

    public static void main(String[] args) throws IOException, ParseException {
        String path = "C:\\Users\\BRITENET\\Documents\\SoapUI\\createCards.json";

        String jsonString = "{\n" +
                "  \"accountID\": 64024810,\n" +
                "  \"card\": {\n" +
                "    \"cardContractNumber\": \"string\",\n" +
                "    \"cbsnumber\": \"string\",\n" +
                "    \"contractName\": \"string\",\n" +
                "    \"embossedData\": {\n" +
                "      \"embossedCompanyName\": \"string\",\n" +
                "      \"embossedFirstName\": \"string\",\n" +
                "      \"embossedLastName\": \"string\",\n" +
                "      \"embossedTitle\": \"string\"\n" +
                "    },\n" +
                "    \"expirationDate\": \"string\",\n" +
                "    \"productCode\": \"string\",\n" +
                "    \"sequenceNumber\": 0\n" +
                "  }\n" +
                "}\n";


        JSONObject obj = new JSONObject(jsonString);
        JsonParserString.jsonToMap(obj);


    }
}
