package get;

import base_url.AutoEBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;

public class Get07 extends AutoEBaseUrl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be "text/html; charset=utf-8"
    And
        Status Line should be HTTP/1.1 200 OK
    And
        There must be 12 Women, 9 Men, 13 Kids usertype in products
  */

    @Test
    public void name() {

        Response response= given().spec(spec.pathParam("first","productsList")).when().get("/{first}");
        response.prettyPrint();

        //response.then().statusCode(200).contentType(ContentType.HTML);


       //List<String> usertype = js.getList("products.category.usertype.usertype");
        List<String> userTypeList = response.jsonPath().getList("products.category");

        SoftAssert softAssert = new SoftAssert();
        int Women = 0;
        int Men = 0;
        int Kids = 0;


        for (int i = 0; i < userTypeList.size(); i++) {

            if (userTypeList.get(i).equals("Women")) {

                Women++;
            }
            if (userTypeList.get(i).equals("Men")) {

                Men++;
            }
            if (userTypeList.get(i).equals("Kids")) {

                Kids++;
            }
        }

        // System.out.println(Women);
        // System.out.println(Men);
        // System.out.println(Kids);

        softAssert.assertEquals(12,Women,"Women degeri 12 degil");

        softAssert.assertEquals(9,Men,"Men degeri 9 degil");

        softAssert.assertEquals(13,Kids,"Kids degeri 13 degil");

        softAssert.assertAll();

    }

}

