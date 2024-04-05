package edu.web.json;

import java.util.Arrays;

public class PersonVO {
	private String name;
	private int age;
	private Boolean isStudent;
	private int[] grade;
	private String[] address;

	public PersonVO() {
	}

	public PersonVO(String name, int age, Boolean isStudent, int[] grade, String[] address) {
		this.name = name;
		this.age = age;
		this.isStudent = isStudent;
		this.grade = grade;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(Boolean isStudent) {
		this.isStudent = isStudent;
	}

	public int[] getGrade() {
		return grade;
	}

	public void setGrade(int[] grade) {
		this.grade = grade;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", isStudent=" + isStudent + ", grade="
				+ Arrays.toString(grade) + ", address=" + Arrays.toString(address) + "]";
	}

}
