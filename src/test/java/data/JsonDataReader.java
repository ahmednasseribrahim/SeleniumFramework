package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {

	public String firstname;
	public String lastname;
	public String email ; 
	public String password;
	
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		
		String jsonFilePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";
		File jsonFile = new File(jsonFilePath);
		
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(jsonFile));
		
		for(Object jObj : jArray) {
			JSONObject person = (JSONObject) jObj;
			firstname = (String) person.get("firstname");
			lastname = (String) person.get("lastname");
			email = (String) person.get("email");
			password = (String) person.get("password");
		}
				
		
		
	}
}
