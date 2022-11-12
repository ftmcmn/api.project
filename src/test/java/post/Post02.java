package post;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.RegresPojo;
import testData.RegresTestData;
import utils.ObjectMapperUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;


public class Post02 extends ReqresBaseUrl {
    //2:  Map ve Pojo Class ile ayrı ayrı yapınız.
/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
*/

    @Test
    public void post01() {
        spec.pathParam("first","users");

        RegresPojo expectedData=new RegresPojo("fatma","qa");

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        RegresPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),RegresPojo.class);
        System.out.println(actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());


    }

    @Test
    public void post02() throws IOException {
        spec.pathParam("first","users");

        Map<String,String> expectedData= new RegresTestData().mapMethod("zeynep","doktor");

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");

        HashMap actualData=new ObjectMapper().readValue(response.asString(),HashMap.class);
        System.out.println(actualData);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));

    }
}
