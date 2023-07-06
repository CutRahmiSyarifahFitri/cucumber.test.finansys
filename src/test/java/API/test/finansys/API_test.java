package API.test.finansys;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.ParseException;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_test {

@Test
    public void test_1() throws ParseException, org.json.simple.parser.ParseException {
        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://demo.finansysapps.id");
        requestSpec.basePath("/api/identity/authentication/authenticate");

        JSONObject payload = new JSONObject();
        payload.put("username", "system");
        payload.put("password", "P@ssw0rd123#");

        requestSpec.headers("accept", "text/plain").headers("Content-Type", "application/json-patch+json").contentType(ContentType.JSON).body(payload.toJSONString());


        Response response = requestSpec.post();

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Response status line:" + response.statusLine());
        System.out.println("Response body:" + response.body().asString());


        RequestSpecification requestToken = RestAssured.given();

        requestToken.baseUri("https://demo.finansysapps.id");
        requestToken.basePath("/api/identity/authentication/isauthenticated");

        // JSONObject payloadToken = new JSONObject();

        requestToken
                .headers("Content-Type", "application/json-patch+json")
                .headers("Cookie", "FinanSys.ApplicationScheme=" + response.getCookies().get("FinanSys.ApplicationScheme"))
                .contentType(ContentType.JSON);
        Response responseToken = requestToken.get();

        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Response status line:" + responseToken.statusLine());
        System.out.println("Response body:" + responseToken.body().asString());
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(responseToken.body().asString());
        JSONObject data = (JSONObject) jsonObject.get("data");
        String token = (String) data.get("token");
        System.out.println("token : " + token);
        
		RequestSpecification requestApp = RestAssured.given();
		
		requestApp.baseUri("https://demo.finansysapps.id");
		requestApp.basePath("/api/form/Editor/ListApplications ");
		
		JSONObject payloadApp = new JSONObject();
		payloadApp.put("application_module_category_id", "uid");
		payloadApp.put("category_name","Demonstration");
		payloadApp.put("created_by", "e1e349999fdd4966bd111c71d9fb123b");
		payloadApp.put("created_on","2021-10-26T06:46:57.426434");
		payloadApp.put("Demonstration","Sales Invoice Demo");
		payloadApp.put("id", "2df4062c330845e7b5462b39aed721ee");
		payloadApp.put("module_name", "sales_invoice_demo");
		
		String AuthToken ="Bearer "+token;
		requestApp.headers("Authorization", AuthToken).contentType(ContentType.JSON).body(payloadApp.toJSONString());
		
		Response responseApp = requestApp.get();
		
		Assert.assertEquals(responseApp.statusCode(),200);
		System.out.println("Response status line:" + responseApp.statusLine());
		System.out.println("Response body:" + responseApp.body().asString());

    }

}
