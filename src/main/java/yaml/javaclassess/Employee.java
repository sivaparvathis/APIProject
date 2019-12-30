package yaml.javaclassess;

import java.util.List;

public class Employee {
	
	private String gender;
	
	private String name;
	private List<String> skills ;
	
	@Override
	public String toString() {
		return "Employee [gender=" + gender + ", name=" + name + ", skills=" + skills + "]";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	


}
