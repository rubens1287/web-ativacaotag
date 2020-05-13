package azure;

import azure.model.Results;
import azure.model.ResultTestCase;
import cucumber.api.Scenario;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigCache;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RunTestController {

    private AzureConfig azureConfig = ConfigCache.getOrCreate(AzureConfig.class);

    public void runTestCase(Scenario scenario) {

        CucumberController tagsCucumber = new CucumberController(scenario);
        String url = String.format("%s_apis/testplan/Plans/%s/Suites/%s/TestPoint?api-version=5.1-Preview&includePointDetails=true&returnIdentityRef=true"
                ,getBaseUrl(),tagsCucumber.getPlanId(), tagsCucumber.getSuiteId());

        RequestSpecification httpRequest = given();
        httpRequest.contentType(ContentType.JSON);
        httpRequest.header("Authorization", "Basic " +  LoginController.getToken(azureConfig.personalToken()));

        List<ResultTestCase> resultTestCases = Collections.singletonList(
                new ResultTestCase(getPointIdFromTestCase(scenario, tagsCucumber.getTestId()),
                        new Results(CucumberController.getStatus(scenario))));
        httpRequest.body(resultTestCases);
        httpRequest.patch(url);
    }

    private Integer getPointIdFromTestCase(Scenario scenario, String testId){
        CucumberController tagsCucumber = new CucumberController(scenario);
        RequestSpecification httpRequest = given();
        httpRequest.contentType(ContentType.JSON);
        httpRequest.header("Authorization", "Basic " + LoginController.getToken(azureConfig.personalToken()));
        String url = String.format("%s_apis/testplan/Plans/%s/Suites/%s/TestPoint?api-version=5.1-Preview&testCaseId=%s&includePointDetails=true&returnIdentityRef=true"
                ,getBaseUrl(),tagsCucumber.getPlanId(), tagsCucumber.getSuiteId(),testId);
        Response response = httpRequest.get(url);
        return response.jsonPath().get("value.id[0]");
    }

    private String getBaseUrl(){
        return String.format("https://%s/%s/%s/",azureConfig.hostAzure(), azureConfig.organization(), azureConfig.project());
    }

}
