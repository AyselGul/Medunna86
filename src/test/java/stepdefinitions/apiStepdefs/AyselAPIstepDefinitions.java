package stepdefinitions.apiStepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import pojos.AyselPojos;
import utilities.ConfigReader;

import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;
import static utilities.TxtWriter.saveAPIAppoinmentData;

public class AyselAPIstepDefinitions {
    Response response;
    AyselPojos[] ayselPojoss;


    @Given("user\\(patient) send get Request for their data")
    public void user_patient_send_get_request_for_their_data() {
        response = RestAssured.given().headers("Authorization",
                        "Bearer " + ConfigReader.getProperty("apiToken"),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                get(ConfigReader.getProperty("usersAPIUrl"));
        // response.prettyPrint();

    }


    @Then("user\\(patient) deserialize their data jo Java")
    public void user_patient_deserialize_their_data_jo_java() throws JsonProcessingException {

        ObjectMapper obj = new ObjectMapper();

        ayselPojoss = obj.readValue(response.asString(), AyselPojos[].class);

/*
        System.out.println("Size of the actual datas" + ayselPojoss.length);

        boolean flag = false;

        for (int i = 0; i < ayselPojoss.length; i++) {
            System.out.println("name " +(i+1) +" : "+ ayselPojoss[i].getFirstName());
            System.out.println("lastname " +(i+1) +" : "+ ayselPojoss[i].getLastName());
        }

        for (int i = 0; i <ayselPojoss.length ; i++) {
            if("147-25-0613".contains(ayselPojoss[i].getSsn()))
                flag=true;

        }
        assertTrue(flag);
    }

*/

    }

    @And("user\\(patient) save the data to related file and validate")
    public void userPatientSaveTheDataToRelatedFileAndValidate() {
        saveAPIAppoinmentData(ayselPojoss);
        generateToken();
    }
}