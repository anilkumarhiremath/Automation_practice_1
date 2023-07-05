package com.webautomation.utilities;

import java.io.*;
import java.util.Properties;

public class Readconfig {

		Properties prop;
	public Readconfig() {
		try {
		File src = new File("./configuration/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String geturl() {
		String url = prop.getProperty("baseURL");
		return url;
	}
}
