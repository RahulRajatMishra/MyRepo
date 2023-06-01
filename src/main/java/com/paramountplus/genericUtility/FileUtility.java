package com.paramountplus.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Contains methods to read value from property file by passing key in the argument
 * @author rahulrajat.m
 *
 */
public class FileUtility {
	/**
	 * Used to read value by providing key from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties");
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);

	}
}
