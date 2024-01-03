package dec28th;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonRead1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fileReader=new FileReader("src\\test\\resources\\testdata\\jsons\\Sample.json");
		
		JsonParser jsonParser=new JsonParser();
		
		JsonObject jsonObject=(JsonObject) jsonParser.parse(fileReader);
		
		System.out.println(jsonObject.get("username"));
		System.out.println(jsonObject.get("rollNo"));

	}

}
