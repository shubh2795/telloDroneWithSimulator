import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

    public static void Reader(){
        JSONParser parser=null;
        JSONObject jsonObject=null;
        JSONArray companyList=null;
        try {
            parser = new JSONParser();
            Object obj = parser.parse(new FileReader(
                    "C:\\Users\\shubh\\IdeaProjects\\Homework2\\telloDrone\\Commands.json"));

            jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("Command");
            String author = (String) jsonObject.get("CommandDescription");
            companyList = (JSONArray) jsonObject.get("TelloCommands");

            System.out.println("Name: " + name);
            System.out.println("Author: " + author);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public JsonReader() throws IOException, ParseException {
    }
}
