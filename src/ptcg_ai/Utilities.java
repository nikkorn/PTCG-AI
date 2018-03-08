package ptcg_ai;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Application utilities.
 */
public class Utilities {
	
	/**
	 * Read a JSON object from file.
	 * @param file The file to read from.
	 * @return JSONObject
	 */
	public static JSONObject readJSONObjectFromFile(File file) {
		String rawJsonObject = Utilities.readStringFromFile(file);
		// Return our constructed JSON object.
		try {
			return new JSONObject(rawJsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Read a JSON array from file.
	 * @param file The file to read from.
	 * @return JSONObject
	 */
	public static JSONArray readJSONArrayFromFile(File file) {
		String rawJsonObject = Utilities.readStringFromFile(file);
		// Return our constructed JSON object.
		try {
			return new JSONArray(rawJsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Read entire file into a string.
	 * @param file
	 * @return string
	 */
	public static String readStringFromFile(File file) {
		String rawString = "";
		if(file.exists()) {
			Scanner scanner = null;
			// Set up our scanner.
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			while(scanner.hasNextLine()) {
				rawString += scanner.nextLine();
			}
		} 
		return rawString;
	}
}
