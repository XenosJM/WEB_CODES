package edu.web.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read_json {
	public static void main(String[] args) {
		String userHome = System.getProperty("user.home");
		String filePath = userHome + "\\Desktop\\makePractice.json";
		try {
			FileReader reader = new FileReader(filePath);
			JSONParser parser = new JSONParser();
			JSONObject jsonObj  = (JSONObject) parser.parse(reader);
			System.out.println(jsonObj.toString());
			String name = (String) jsonObj.get("name");
			System.out.println(name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // end main
} // end Read_json
