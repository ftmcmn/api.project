import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ApiCalisma2 {
    @Test
    public void name() {
        /* Given
        https://restful-booker.herokuapp.com/booking/1
    When
        User send a GET Request to the url
    Then
        HTTP Status code should be 404
    And
        Status Line should be HTTP/1.1 404 Not Found
    And
        Response body contains "Not Found"
    And
        Response body does not contain "TechProEd"
    And
        Server is "Cowboy"
 */
        String url="https://restful-booker.herokuapp.com/booking/1";
        Response response=given().when().get(url);

        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));
        assertEquals("Cowboy",response.getHeader("Server"));
    }
}
