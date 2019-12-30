package com.atlassian.developer.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class CreateSessionId {
	protected Properties prop;
	
	 

public void getPathUrl() throws FileNotFoundException, IOException
{
	 prop=new Properties();
	prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties")));
	
}

}
