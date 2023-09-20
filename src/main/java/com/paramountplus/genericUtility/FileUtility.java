package com.paramountplus.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Contains methods to read value from property file by passing key in the argument
 * @author rahulrajat.m
 *
 */
public class FileUtility {
	public static String path="./src/test/resources/";
	/**
	 * Used to read value by providing key from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(path+"commonData.properties");
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);

	}
	public void writePropertyValue(String key, String value, String fileName)
	{
		Properties properties = new Properties();
		try {
			FileOutputStream outputStream = new FileOutputStream(path+fileName);  
			properties.setProperty(key, value);
			properties.store(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public String getDataFromFile(String key, String value, String fileName) throws Exception
	{
		FileInputStream fis= new FileInputStream(path+fileName);
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
