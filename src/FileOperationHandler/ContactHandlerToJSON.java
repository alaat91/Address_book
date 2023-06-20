package FileOperationHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.UUID;


public class ContactHandlerToJSON {

    private JSONArray jsonArray;

    public ContactHandlerToJSON() {
        this.jsonArray = new JSONArray();
    }


    public void writeToFile(String name, String email, String phoneNum) {
        String uniqueID = UUID.randomUUID().toString();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("ID: ", uniqueID);
        jsonObj.put("Name: ", name );
        jsonObj.put("Email: ", email );
        jsonObj.put("Phone Number: ", phoneNum );

        JSONObject contactObj = new JSONObject();
        contactObj.put("Contact: " ,jsonObj);

        jsonArray.add(contactObj);
        try (FileWriter fileWriter = new FileWriter("Contacts.json")) {
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readFromFile() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader("Contacts.json")) {
            Object obj = jsonParser.parse(fileReader);
            jsonArray = (JSONArray) obj;
            //System.out.println("JSON RECORDS: " + jsonArray);

            for(Object con: jsonArray) {
                ParseContactObj((JSONObject) con);
            }
            //jsonArray.forEach(contact -> ParseContactObj((JSONObject) contact));


        } catch (ParseException | IOException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public void ParseContactObj(JSONObject jsonContact) {
        JSONObject jsonObject = (JSONObject) jsonContact.get("Contact: ");
        String name = (String) jsonObject.get("Name: ");
        String email = (String) jsonObject.get("Email: ");
        String phoneNum = (String) jsonObject.get("Phone Number: ");

        System.out.println("------------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNum);
        System.out.println("------------------------------------------");

    }

    public void deleteRecordFromFile(String name)  {
        try {
            JSONParser jsonParser = new JSONParser();
            jsonArray = (JSONArray) jsonParser.parse(new FileReader("Contacts.json"));

            int indexToDelete = 0;
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject contact = (JSONObject) jsonArray.get(i);
                JSONObject extractedContact = (JSONObject) contact.get("Contact: ");
                String extractedName = extractedContact.get("Name: ").toString();
                if (extractedName.equals(name)) {
                    jsonArray.remove(i);
                    System.out.println("Inside the delete statement: " + extractedContact);
                    indexToDelete++;

                }
                FileWriter fileWriter = new FileWriter("Contacts.json");
                fileWriter.write(jsonArray.toJSONString());
                fileWriter.flush();
            }

        } catch (ParseException pe) {
            pe.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if(jsonArray.isEmpty()) {
            System.out.println("------------------------------------------");
            System.out.println("No Contacts to be Deleted!");
            System.out.println("------------------------------------------");
        }
        }
    }



