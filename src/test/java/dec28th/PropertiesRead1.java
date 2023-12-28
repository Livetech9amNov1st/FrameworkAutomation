package dec28th;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead1 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("src\\test\\resources\\Properties\\config.properties");
		
		Properties configProp=new Properties();
		
		configProp.load(fis);
		
		System.out.println(configProp.getProperty("browser"));
		
		System.out.println(configProp.getProperty("url"));

	}

}
