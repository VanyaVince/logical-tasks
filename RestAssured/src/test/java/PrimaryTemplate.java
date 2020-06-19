import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class PrimaryTemplate {

    private String URL = "http://demo.guru99.com/V4/sinkministatement.php";
    private String customerID = "68195";
    private String password = "1234!";
    private String account_No = "1";

    private Response makeRequest() {
        return given()
                .queryParam("CUSTOMER_ID", customerID)
                .queryParam("PASSWORD", password)
                .queryParam("Account_No", account_No)
                .when()
                .get(URL);
    }

    @Test
    public void getResponseBody() {
        makeRequest()
                .then()
                .log()
                .body();
    }

    @Test
    public void getResponseStatus() {
        makeRequest()
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getResponseHeaders() {
        Headers headers = makeRequest().then().extract().headers();
        System.out.println(headers);
    }

    @Test
    public void getResponseTime() {
        System.out.println("The time taken to fetch response " + makeRequest().timeIn(TimeUnit.MILLISECONDS));
    }

    @Test
    public void getResponseContentType() {
        System.out.println("The content type of last request is " + makeRequest().then().extract().contentType());
    }

    @Test
    public void sumTotalAmountInResponse() {

        ArrayList<String> amountItems = makeRequest().then().extract().path("result.statements.AMOUNT");
        System.out.println(amountItems.stream().mapToInt(Integer::parseInt).sum());

        ///// the author's solution
//        String url = "http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";
//        ArrayList<String> amounts = when().get(url).then().extract().path("result.statements") ;
//        int sumOfAll=0;
//        for(String a:amounts){
//
//            System.out.println("The amount value fetched is "+a);
//            sumOfAll=sumOfAll+Integer.valueOf(a);
//        }
//        System.out.println("The total amount is "+sumOfAll);
//
    }
}
