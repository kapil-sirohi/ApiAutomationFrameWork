package request;

import client.RestClient;
import io.restassured.response.Response;

public class RequestFactory {

	RestClient restClient;

	// contructor
	public RequestFactory() {
		restClient = new RestClient();
	}

	public Response getAllProducts() {
		return restClient.sendGetRequest("/products");
	}

	public Response addProducts(Object requestPayLoad) {
		return restClient.sendPostRequest("/products", requestPayLoad);
	}

	public Response updateProducts(Object requestPayLoad) {
		return restClient.sendPutRequest("/products", requestPayLoad);
	}
}
