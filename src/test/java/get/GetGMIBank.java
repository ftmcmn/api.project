package get;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetGMIBank {

    public static void main(String[] args) {
        tokenAlma("Batch81+",true,"Batch81");
    }

    public static String tokenAlma(String password, Boolean rememberMe, String username){

        Map<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("rememberMe",rememberMe);
        map.put("password",password);
        System.out.println(map);
        String url="https://www.gmibank.com/api/authenticate";
        Response response = given().contentType(ContentType.JSON).when().body(map).post(url);
        response.prettyPrint();
        Map<String,Object> tokanMap=response.as(HashMap.class);
        String token= (String)(tokanMap.get("id_token"));

        System.out.println(token);

        return token;
    }


}
