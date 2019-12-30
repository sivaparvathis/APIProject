package yamlvalidations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import yaml.javaclassess.Basicyaml;
import yaml.javaclassess.Employee;

public class yamlvalidation {
	
	@Test
	public void yamlvalidationtest() throws JsonParseException, JsonMappingException, IOException
	{
	//Yaml yml=new Yaml();
//	HashMap<String, Object> object=yml.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\empolyee.yaml")));
//	System.out.println(object.get("description"));
//	HashMap<String, Object> employeemap=(HashMap<String, Object>) object.get("employee");
//	System.out.println(employeemap.get("gender"));
//	System.out.println(employeemap.get("name"));
//	System.out.println(employeemap.get("skills"));
//	ArrayList<String> skillarry=(ArrayList<String>) employeemap.get("skills");
//	System.out.println(skillarry.get(0));
	
	Basicyaml obj=new ObjectMapper().readValue(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\empolyee.yaml"), Basicyaml.class);
	System.out.println("Printing POJO:"+obj.getDescription());

	
	}
	
	
	

}
