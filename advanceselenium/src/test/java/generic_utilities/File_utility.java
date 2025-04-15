package generic_utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_utility {
	/**
	 * This method is used to read data from properties file(External resource)
	 * @param key
	 * @return
	 * @throws throwable
	 * 
	 */
	public String getKeyAndValuePair(String key)throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");

		// step2:-create an object to properties class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
		
	}

}
