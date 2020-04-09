package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Get_Single_Employee_Record extends TestBase {

	//RequestSpecification httpRequest;
	//Response response;

	@BeforeClass
	void getAllEmployees() throws InterruptedException {

		logger.info("*********Started TC001_Get_All_Employees **********");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/" +empID);

		Thread.sleep(5000);
	}

	@Test
	void checkResposeBody() {
		String responseBody = response.getBody().asString();
		logger.info("Response body is==>" + responseBody);
		Assert.assertEquals(responseBody.contains(empID), true);
	}

	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	void checkResponseTime() {
		logger.info("***********  Checking Response Time **********");
		long responseTime = response.getTime(); // Getting status Line
		Assert.assertTrue(responseTime < 6000);

	}

	@Test
	void checkstatusLine() {
		logger.info("***********  Checking Status Line **********");
		String statusLine = response.getStatusLine(); // Gettng status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@Test
	void checkContentType() {
		logger.info("***********  Checking Content Type **********");
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
	}

	@Test
	void checkserverType() {
		logger.info("***********  Checking Server Type **********");
		String serverType = response.header("Server");
		logger.info("Server type is==>" + serverType);
		Assert.assertEquals(serverType, "nginx/1.16.0");
	}

	@Test
	void checkContentLenght() {
		logger.info("***********  Checking Content Length**********");

		String contentLength = response.header("Content-Length");
		logger.info("Content Length is==>" + contentLength);

		if (Integer.parseInt(contentLength) > 1500)
			logger.warn("Content Length is more than 1500");

		Assert.assertTrue(Integer.parseInt(contentLength) < 1500);
	}

	@AfterClass
	void tearDown() {
		logger.info("*********  Finished TC002_Get_Single_Employee_Record **********");
	}

}
