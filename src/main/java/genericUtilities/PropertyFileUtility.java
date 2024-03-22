package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/* 
     * This class consists of generic methods related to property file 
     * @author Sonia
     */

public class PropertyFileUtility {
      
	/*
	 * This method reads Data from property file based on given key 
	 * @param key
	 * @return value
	 * @throws Throwable
	 */

	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IConstant.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}


