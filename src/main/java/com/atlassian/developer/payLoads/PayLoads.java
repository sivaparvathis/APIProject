package com.atlassian.developer.payLoads;

public class PayLoads {
	
	public static String createSessionPayload()
	{
		return "{     \r\n" + 
				"	\"username\": \"sivaparvathis\",\r\n" + 
				"    \"password\": \"Balaji@1\"\r\n" + 
				"}";
	}

	public static String createIssuePayload()
	{
		return "{\r\n" + 
				"  \"fields\": {\r\n" + 
				"  	 \"project\": {\r\n" + 
				"      \"key\": \"MYP\"\r\n" + 
				"    },\r\n" + 
				"    \"summary\": \"New Summary22\",\r\n" + 
				"    \"description\": \"new description1\",\r\n" + 
				"    \"issuetype\": {\r\n" + 
				"      \"name\": \"Bug\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
	}
	
	
}
