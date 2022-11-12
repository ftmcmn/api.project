package patch;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.RegresPojo;
import testData.RegresTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Patch01 extends ReqresBaseUrl {
    //4: Map ile ve Pojo Class ile ayrı ayrı Object Mapper kullanarak yapınız.
  /*
       Given
           1) https://reqres.in/api/users/2
           2) {
                "name": "neo"
               }
       When
            I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                                                "name": "neo",
                                                "updatedAt": "2022-10-02T12:53:21.675Z"
                                         }
    */

    @Test
    public void patch01() {
        spec.pathParams("first","users","second",2);

        Map<String,String> expectedData=new RegresTestData().mapMethod("büşra",null);
        System.out.println(expectedData);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");

        HashMap actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));

    }
}
