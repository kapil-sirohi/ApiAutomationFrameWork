package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.response.Response;

public class ProductTest extends BaseTest {

	@Test
	public void verifyGetRequest() {
		extentReportUtils.createTestCase("Verify Get Product");
		Response response = requestFactory.getAllProducts();
		extentReportUtils.addLog(Status.INFO, response.asPrettyString());
		response.then().statusCode(200).log().all();
	}

	@Test
	public void verifyAddProduct() {
		extentReportUtils.createTestCase("Verify add Product");
		String requestPayLoad = "{\n" + "  \"name\": \"Api Automation\",\n" + "  \"type\": \"Testing\",\n"
				+ "  \"price\": 100,\n" + "  \"shipping\": 10,\n" + "  \"upc\": \"string\",\n"
				+ "  \"description\": \"string\",\n" + "  \"manufacturer\": \"string\",\n"
				+ "  \"model\": \"string\",\n" + "  \"url\": \"string\",\n" + "  \"image\": \"string\"\n" + "}";
		requestFactory.addProducts(requestPayLoad).then().log().all().statusCode(201);
	}

	@Test
	public void verifyAddProductAsObjectPayLoad() {
		extentReportUtils.createTestCase("Verify add Product as payload");
		Map<String, Object> requestPayLoad = new HashMap<String, Object>();
		requestPayLoad.put("name", "auom");
		requestPayLoad.put("type", "josn");
		requestPayLoad.put("price", 1000);
		requestPayLoad.put("shipping", 10);
		requestPayLoad.put("upc", "samsung");
		requestPayLoad.put("description", "mobile");
		requestPayLoad.put("manufacturer", "2019");
		requestPayLoad.put("model", "samsung");
		requestPayLoad.put("url", "20103.sdfsf");
		requestPayLoad.put("image", ".jpg");

		requestFactory.addProducts(requestPayLoad).then().log().all().statusCode(201);
	}

}
