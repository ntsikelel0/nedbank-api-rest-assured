package stepdefs;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonParser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.Requests;

import java.util.ArrayList;
import java.util.HashMap;

public class StepDefs {

    Response response;


    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String url) {
        response = Requests.get(url);
    }
    @Then("The status code is {int}")
    public void the_status_code_is(Integer stsCode) {
        Assert.assertEquals(response.statusCode(),stsCode);
    }
    @And("The state for wits is returned")
    public void the_state_for_wits_is_returned() {
        JsonPath jsonPath = response.jsonPath();

        ArrayList<HashMap> jsonBody = jsonPath.get();

        for(HashMap hm : jsonBody){
            if(hm.get("name").equals("University of Witwatersrand")){
                System.out.println(hm.get("state-province"));
            }
        }

    }

}
