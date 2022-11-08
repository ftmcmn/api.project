package post;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.RestfullTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post01 extends RestfulBaseUrl {
    @Test
    public void post01() {
         /*
    {
    "firstname": "John",
    "lastname": "Wick",
    "totalprice": 35007,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2021-09-10",
        "checkout": "2021-10-20"
    },
    "additionalneeds": "Bat Dish"
}
     */

        RestfullTestData obj=new RestfullTestData();
        Map<String,Object> expectedData=obj.disMapMethod("nurettin","guzel",200,true,
                obj.icMapMethod("2022-12-10","2021-12-20"),"arabasi");
        System.out.println(expectedData);

        Response response=given().spec(spec.pathParams("first","booking")).contentType(ContentType.JSON).when().body(expectedData).post("/{first}");
        response.prettyPrint();

        Map<String,Object> actualData=(Map)(((Map)(response.as(HashMap.class))).get("booking"));
        System.out.println(actualData);
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(((Map)(expectedData.get("bookingdates"))).get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        assertEquals(((Map)(expectedData.get("bookingdates"))).get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
    }
}
