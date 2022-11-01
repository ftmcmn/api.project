import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.*;

public class ApiCalisma3 {
    @Test
    public void name() {
        /*
        https://jsonplaceholder.typicode.com/todos/12
    When
        User send a GET Request to the url
    Then
        HTTP Status code should be 200
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Response body contains "ipsa"
    And
        Response body does not contain "TechProEd"
    And
        Transfer-Encoding is "chunked"
         */
        String url="https://jsonplaceholder.typicode.com/todos/12";
        Response response=given().when().get(url);
       // response.prettyPrint();
       // System.out.println("1 : "+response.statusLine());
       // System.out.println("2 : " + response.statusCode());
       // System.out.println("3 : "+response.contentType());
       // System.out.println("body : "+response.body().print());
       // System.out.println("baslıkla : "+response.getHeaders());
        response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK");

        assertTrue(response.asString().contains("ipsa"));
        assertFalse(response.asString().contains("TechProEd"));
        assertEquals("chunked",response.getHeader("Transfer-Encoding"));

    }
}
