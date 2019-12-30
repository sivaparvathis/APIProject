import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaExcersises {
	
	public void getInputFromUser()
	{
      Scanner scanner =new Scanner(System.in);
		
		System.out.println("please enter vlaue :");
		String input=scanner.next();
		System.out.println("Entered input is :"+input);
		
		String encryptedValue=Base64.getEncoder().encodeToString(input.getBytes());
		
		
		
		System.out.println(Base64.getEncoder().encodeToString(input.getBytes()));
		System.out.println(new String(Base64.getDecoder().decode(encryptedValue)));
		scanner.close();

	}
	
	public void readrepeatedwords() throws IOException
	{
      Map<String, Integer> map=new HashMap<String, Integer>();
		
		System.out.println("Empty map :"+map);
		
		BufferedReader reader=new BufferedReader(new FileReader(new File("C:\\Users\\ctiruma\\Desktop\\Sample.txt")));
		
		String value=reader.readLine();
		while (value!=null) {
			System.out.println(value);
			
			String[] strArr=value.split(" ");

			for (String string : strArr) {
				if(map.containsKey(string)) {
					int count=map.get(string);
					map.put(string, count+1);
				}
				else
				{
					map.put(string, 1);
				}
			}
			value=reader.readLine();
		}
		reader.close();
		System.out.println(map);
		  
	}

}
