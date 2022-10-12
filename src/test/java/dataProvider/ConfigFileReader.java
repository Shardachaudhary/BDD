package dataProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	public static Properties readconfigfile() throws IOException
	{
		File file = new File("D:\\Sharda Practice\\delete\\configs\\Configurations.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);		
		System.out.println("inside prop file");
		return prop;
	}
	
	public static String fetchConfigData(String inputstr) throws IOException
	{
		String str;
		Properties p1 = readconfigfile();
		str = p1.getProperty(inputstr);
		return str;	
	}
}
