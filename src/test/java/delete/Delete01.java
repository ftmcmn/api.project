package delete;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Delete01 {
    /*
   https://petstore.swagger.io/ documantation adresini kullanarak 'user' oluşturan
   ve oluşsan bu user'ı silen bir otomasyon kodu yazınız.
   */
    @Test
    public void delete01() {


        Response response=given().when().delete("https://petstore.swagger.io/v2/user/zynp");
        response.prettyPrint();

        HashMap expectedData= new HashMap<>();
        expectedData.put("code",200);
        expectedData.put("type","unknown");
        expectedData.put("message","zynp");

        //Map<String,Object>actualData=response.as(HashMap.class);
       HashMap actualData=response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(expectedData.get("code"),actualData.get("code"));
        assertEquals(expectedData.get("type"),actualData.get("type"));
        assertEquals(expectedData.get("message"),actualData.get("message"));




    }
}
