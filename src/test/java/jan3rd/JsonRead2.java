package jan3rd;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonRead2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fileReader=new FileReader("src\\test\\resources\\testdata\\jsons\\demo.json");
		
		JsonParser jsonParser=new JsonParser();
		
		//JsonObject jsonObject=(JsonObject) jsonParser.parse(fileReader);
		
		JsonArray  jsonArray=(JsonArray) jsonParser.parse(fileReader);
		
		//JsonArray  jsonArray=jsonObject.getAsJsonArray();
		
		System.out.println(jsonArray.size());
		
		//JsonElement  jsonElement =null;
		
		JsonObject jsonObject=null;
		
		for(int i=0;i<jsonArray.size();i++)
		{
			//jsonElement=jsonArray.get(i);
			
			jsonObject=jsonArray.get(i) .getAsJsonObject();
			
			 System.out.println(jsonObject.get("id"));
			 System.out.println(jsonObject.get("name"));
			 System.out.println(jsonObject.get("email"));
			 System.out.println(jsonObject.get("gender"));
			 System.out.println(jsonObject.get("status"));
			 
			 System.out.println("*********************************");
		}

	}

}
