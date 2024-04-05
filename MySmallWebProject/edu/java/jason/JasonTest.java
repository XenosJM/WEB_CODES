package edu.java.jason;

import com.google.gson.Gson;


public class JasonTest {
	private String name;
	private int age;
	
	public JasonTest(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
} // end JasonTest

public class CreateJsonUsingGson {
	public static void main(String[] args) {
		// Java 객체 생성
		Person person = new Person("John", 30);
		
		// Gson 객체 생성
		Gson gson = new Gson();
		
		// Java 객체를 JSON 문자열로 변환
		String json = gson.toJson(person);
		
		// 결과 출력
		System.out.println("JSON 데이터: " + json);
	}
}