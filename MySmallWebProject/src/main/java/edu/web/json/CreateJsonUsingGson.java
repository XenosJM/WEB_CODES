package edu.web.json;

// Java 객체 생성
//        Person person = new Person("John", 30);
//
//        // Gson 객체 생성
//        Gson gson = new Gson();
//
//        // Java 객체를 JSON 문자열로 변환
//        String json = gson.toJson(person);
//
//        // JSON 데이터를 파일에 저장
//        try (FileWriter writer = new FileWriter("C:/Users/sdedu/Desktop/person.json")) {
//            writer.write(json);
//            System.out.println("JSON 데이터가 파일에 저장되었습니다.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CreateJsonUsingGson {
	public static void main(String[] args) {
		String filePath = "C:/Users/sdedu/Desktop/person.json";

		try (FileReader reader = new FileReader(filePath)) {
			// JSON 파일을 JsonElement로 파싱
			JsonElement jsonElement = JsonParser.parseReader(reader);

			// 필요한 키 또는 경로로 접근
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			String name = jsonObject.get("name").getAsString();
			int age = jsonObject.get("age").getAsInt();
			// 객체화된 json 데이터의 배열을 다시 객체형식으로 가져와서
			// 배열 안에 데이터에 직접 접근가능.
			JsonObject address = jsonObject.getAsJsonObject("address");
			address.remove("street");
			address.addProperty("street", "야탑동");
			String street = address.get("street").getAsString();
			address.remove("city");
			address.addProperty("city", "성남");
			String city = address.get("city").getAsString();
			// 값 출력
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Street: " + street);
			System.out.println("City: " + city);

			// 굳이 vo형식으로 만들어서 저장할 필요가 없다.
			// 이미 객체형식으로 파싱을 했기때문에 데이터를 빼거나 바꾼후
			// 객체형태인 데이터를 다시 json으로 파싱해서 저장하면된다.
			// 다만 이제 다른데서 처리할시 vo로 보내는편이 안전
//			PersonVO pv = new PersonVO(name, age, false, null, address);
			Gson gson = new Gson();
			String json = gson.toJson(jsonObject);
			
			try (FileWriter writer = new FileWriter(filePath)) {
				writer.write(json);
				System.out.println("JSON 데이터 저장 완료");
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
