package get;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class get04 extends JsonplaceholderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
          I send a GET request to the Url
       And
           Accept type is "application/json"
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           There should be 200 todos
       And
           "quis eius est sint explicabo" should be one of the todos title
       And
           2, 7, and 9 should be among the userIds
     */

    @Test
    public void name() {
        Response response=given().when().and().spec(spec.pathParam("first","todos")).accept(ContentType.JSON).get("/{first}");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("null",hasSize(200),
                        "title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));


    }
}
