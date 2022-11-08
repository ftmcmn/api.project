package get;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import testData.RestfullTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get08 extends RestfulBaseUrl {
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

    @Test
    public void get08() {
        RestfullTestData obj=new RestfullTestData();
        Map<String,Object> expectedData=obj.disMapMethod("John","Wick",35007,true,
                obj.icMapMethod("2021-09-10","2021-10-20"),"Bat Dish");

        Response response=given().spec(spec.pathParams("first","booking","second",3864)).when().get("/{first}/{second}");

        response.prettyPrint();

        Map<String,Object>actualData=response.as(HashMap.class);

        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(((Map)(expectedData.get("bookingdates"))).get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        assertEquals(((Map)(expectedData.get("bookingdates"))).get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
    }
}
