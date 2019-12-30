package com.atlassian.developer.utils;

import java.sql.Timestamp;
import java.util.Date;


public class JavaUtils  {

	public static String timeStamp()
	{   Date dt=new Date();
	     long time=dt.getTime();
	     
	    Timestamp ts=new Timestamp(time);
	    String d=ts.toString();
	    d=d.replace(" ", "_");
	    d=d.split("\\.")[0];
	    d=d.replace(":", "-");
		return d;
		
	}
	
	
	
	
}
