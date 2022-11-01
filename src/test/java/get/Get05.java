package get;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends RestfulBaseUrl {
      /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
     */

    @Test
    public void name() {

       // Response response=given().when().spec()

    }
}
