package serializationDeserialization;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class VideoGameAPITestwithSerializationXML {

	// Post request creates a new record
	@Test(priority = 1)
	public void testVideoGameSerializationJSON() {
		//ArrayList<String> coursesList = new ArrayList<String>();
		//coursesList.add("");
		//coursesList.add("");

		VideoGame myVideoGame = new VideoGame();
		myVideoGame.setID(13);
		myVideoGame.setName("xyz123");
		myVideoGame.setReleaseDate("2019-06-17");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driving");
		myVideoGame.setRating("Five");
		
			given()
				.contentType("application/xml")
				.body(myVideoGame)
			.when()
				.post("http://localhost:8080/app/videogames")
			.then()
				.log().all()
				.body(equalTo("{\"status\": \"Record Added Successfully\"}"));
			
	}

	// Get Request to retrieve student details
	@Test(priority = 2)
	public void testVideoGameDeSerializationJSON()
	{
		VideoGame myVideoGame = get("http://localhost:8080/app/videogames/13").as(VideoGame.class);
		System.out.println(myVideoGame.toString()); 
				
		//given().when().get("http://localhost").then().statusCode(200).assertThat().body("id", equalTo(101)).log().all();

	}

}
