package StepDefinition;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.Asserts;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RestApiCalls_Test {
private String baseUrl;
CloseableHttpResponse getStubResponse = null;



	@Given("^get call base url as \"(.*?)\"$")
	public void getCallBaseUrlAs(String baseUrl) throws Throwable {
		this.baseUrl=baseUrl;
	}
	
	@When("^I search for person \"(.*?)\"$")
	public void iSearchForPerson(String name) throws Throwable {
		//	HttpClient client = HttpClients.createDefault();
		
		//HttpGet getStubMethod = new HttpGet(baseUrl);
	
		//getStubResponse = client.execute(getStubMethod);
		
		baseUrl = baseUrl.concat("/search?source="+name);
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(baseUrl);
		getStubResponse = httpclient.execute(httpGet);
      
	}

	@Then("^I get response as \"(.*?)\"$")
	public void iGetResponseAs(int responseCode) throws Throwable {
		
		if (getStubResponse != null) {
			int getStubStatusCode = getStubResponse.getStatusLine().getStatusCode();
			Asserts.check(responseCode == getStubStatusCode, "Recieved correct response");
			
		}
	}

	
	
	/*
	@Test
	public void testPostCall() throws Throwable {
		String url = "http://localhost:8080/api/v1/products";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("Content-Type", "text/plain");

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("code", "LRX-123"));
		urlParameters.add(new BasicNameValuePair("name", "Thneed"));
		urlParameters.add(new BasicNameValuePair("description", "A fine something that all people need"));
	//	urlParameters.add(new BasicNameValuePair("num", "12345"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("Response Code : "
		                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
	}
	
	@Test
	public void testPostCalls() throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/v1/products";
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(3);
		params.add(new BasicNameValuePair("code", "LRX-125"));
		params.add(new BasicNameValuePair("name", "ThneedM"));
		params.add(new BasicNameValuePair("description", "A fine something that all people need"));
		httppost.setEntity(new UrlEncodedFormEntity(params));

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		System.out.println(response.getStatusLine().getStatusCode());
	
		HttpEntity entity = response.getEntity();

		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try {
		        // do something useful
		    } finally {
		        instream.close();
		    }
		}
	
	}
	
	
	@Test
	public void httpPost() throws InterruptedException {
			
		//Initializing Rest API's URL
		String APIUrl = "http://localhost:8080/api/v1/products";
			
		//Initializing payload or API body
		String APIBody = "{\"code\" :\"LRX-124\", \"name\":\"ThneedB\", \"description\":\"A fine something that all people need\"}"; //e.g.- "{\"key1\":\"value1\",\"key2\":\"value2\"}"
					
		RequestSpecBuilder builder = new RequestSpecBuilder().setBody(APIBody).setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		//Making post request with authentication

		Response response = given().authentication().preemptive().basic("","").spec(requestSpec).when().post(APIUrl);


		int responseStatus = response.getStatusCode();
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		
	//	System.out.println("response in string" + response.toString());
		
	//	String result = JSONResponseBody.optString(response.toString());

		//Fetching the desired value of a parameter
	//	String result = JSONResponseBody.getString(response.toString());
			
		String code = JSONResponseBody.getString("code").toString();
		Assert.assertEquals(responseStatus, 201);
		

		}
	

*/
}

