package get;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;
import static org.hamcrest.Matchers.*;


public class get06 extends RestfulBaseUrl {
    
    /*
        Given
            https://restful-booker.herokuapp.com/booking/2325
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
         {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-10-27",
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
}
     */

    @Test
    public void name() {
        Response response=given().when().spec(spec.pathParams("first","booking","second",2325))
                .get("/{first}/{second}");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("firstname", equalTo("Bradley"),
                "lastname", equalTo("Pearson"),
                "totalprice", equalTo(132),
                "depositpaid", equalTo(false),
                "bookingdates.checkin", equalTo("2022-10-27"),
                "bookingdates.checkout", equalTo("2022-11-07"),
                "additionalneeds", equalTo("None"));


        JsonPath jsonPath=response.jsonPath();

        assertEquals("Bradley",jsonPath.getString("firstname"));
        assertEquals("Pearson",jsonPath.getString("lastname"));
        assertEquals(132,jsonPath.getInt("totalprice"));
        assertFalse(jsonPath.getBoolean("depositpaid"));
        assertEquals("2022-10-27",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2022-11-07",jsonPath.getString("bookingdates.checkout"));
        assertEquals("None",jsonPath.getString("additionalneeds"));

    }
}
