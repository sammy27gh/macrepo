package ApplicationDataTest;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.testng.Assert;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;

import DataVariable.DataVariable;
import DataVariable.DataVariableRequest;
import DataVariable.VerifyFunctions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileReader.FileProcessor;
import junit.framework.Assert;

public class DataVariableTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataVariableTest.class);

	public Response responseWhen;
	public Response responseThen;
	private static VerifyFunctions verifyfunctions;

	static DataVariable javaBean;
	static List<DataVariable> requestList = new ArrayList<DataVariable>();
	static Map<String, DataVariable> dataMap = new HashMap<String, DataVariable>();

	static {
		verifyfunctions = new VerifyFunctions();
		Map<String, String> columnMapping = new HashMap<String, String>();

		columnMapping.put("scenarioName", "scenarioName");
		columnMapping.put("website_id", "website_id");
		columnMapping.put("page_number", "page_number");
		columnMapping.put("keywords", "keywords");
		columnMapping.put("manufacturer_name", "manufacturer_name");
		columnMapping.put("Authorization", "Authorization");

		String resources = "src/test/resources/environment/";
		String testDataFile = "/testdata/testdata.csv";
		String env = System.getProperty("env");
		requestList = new FileProcessor<DataVariable>().parseCSVToBeanList(resources + env + testDataFile,
				columnMapping, DataVariable.class);

		Iterator<DataVariable> iterator = requestList.iterator();
		while (iterator.hasNext()) {
			javaBean = iterator.next();
			dataMap.put(javaBean.getScenarioName(), javaBean);

		}
		System.out.println(javaBean);
	}

	@Given("^I have a prescription Application$")
	public void i_have_a_prescription_Application() throws Throwable {
		LOGGER.info("given that i have a  Login Page");
	}

	@When("^I enter the correct UserName and Password$")
	public void i_enter_the_correct_UserName_and_Password() throws Throwable {

		try {
			LOGGER.info("When I send a valid Get_Quote all the request fields");
			String ScenarioName = "Validate the UserName and Password";
			LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
			Headers requestHeaders = DataVariableRequest.createRequestHeader(dataMap.get(ScenarioName));
			Map<String, String> UsingqueryParam = DataVariableRequest.CreateQueryParameter(dataMap.get(ScenarioName));
            
			System.out.println("\n i want to be able to see the map");
			System.out.println(UsingqueryParam);

			System.out.println(requestHeaders);
			// System.out.println(pathParameter);

			System.out.println(verifyfunctions.baseURI());
			verifyfunctions.baseURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.queryParams(UsingqueryParam)
					//.queryParams(UsingqueryParam)
				// .queryParameters(UsingqueryParam)
					 // .queryParam("website-id", 8037253) .queryParam("page-number", 2)
					 // .queryParam("keywords", "barnes and noble") .queryParam("manufacturer-name",
					//  "Noble")
					 
					// .headers(pathParameter)
					.headers(requestHeaders).when().get("/v2/product-search").then().statusCode(200).extract()
					.response();
		} catch (Exception e) {
			// LOGGER.error(e.getMessage());
			System.out.println(e.getMessage());
			Assert.fail();
		}
		responseThen = responseWhen;
		System.out.println(responseThen.asString().toString() + "\n");
	}

	@Then("^I should be able to see the HomePage$")
	public void i_should_be_able_to_see_the_HomePage() throws Throwable {

		try {
			LOGGER.info(responseThen.asString().toString());
			// LOGGER.info("Then I receive valid Get_Quote response along with all
			// applicable fields");
			if (responseThen != null) {
				LOGGER.info("Total Response for Get_Quote is: \n" + responseThen.asString());
				// LOGGER.info(" ", responseThen.asString().equals(11793338));
				Assert.assertTrue(responseThen.asString().contains("Newegg.com"));
				// Assert.assertTrue(responseThen.asString(), "");
				// System.out.println(responseThen.asString());
				Assert.assertTrue(responseThen.asString().contains(""));

			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			e.getMessage();
			// LOGGER.error(e.getMessage());
			Assert.fail();
		}

	}

	/*
	 * @Given("^I enter an invalid userName and Password$") public void
	 * i_enter_an_invalid_userName_and_Password() throws Throwable {
	 * LOGGER.info("I want enter my userName and password");
	 * 
	 * }
	 * 
	 * @When("^i initiate the tool$") public void i_initiate_the_tool() throws
	 * Throwable {
	 * 
	 * String intentionally = null; String itemName = "food"; if
	 * (itemName.equals(intentionally)) {
	 * 
	 * LOGGER.info(itemName); } }
	 * 
	 * @Then("^I should be able to guide the tool$") public void
	 * i_should_be_able_to_guide_the_tool() throws Throwable {
	 * 
	 * if (responseThen != null) {
	 * Assert.assertTrue(responseThen.asString().contains("HP")); } }
	 */

	/*
	 * @Given("^i have a valid useraccount$") public void
	 * i_have_a_valid_useraccount() throws Throwable {
	 * System.out.println("additionl that is needed validation"); }
	 * 
	 * @When("^i enter the righ userName and external id$") public void
	 * i_enter_the_righ_userName_and_external_id() throws Throwable {
	 * 
	 * System.out.
	 * println("I pass a valid user name and password and and i able to validate that"
	 * ); }
	 * 
	 * @Then("^i should be able to receive the response with a valid valid status code\\.$"
	 * ) public void
	 * i_should_be_able_to_receive_the_response_with_a_valid_valid_status_code()
	 * throws Throwable {
	 * 
	 * System.out.println("I should be able to get the solutions that i need ");
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
}
