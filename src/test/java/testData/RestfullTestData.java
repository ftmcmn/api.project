package testData;

import java.util.HashMap;
import java.util.Map;

public class RestfullTestData {

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
    public Map<String,Object> disMapMethod(String firstname, String lastname, Integer totalprice,
                                     Boolean depositpaid,Map<String,String> bookingdates, String additionalneeds){

        Map<String,Object> disMap=new HashMap<>();
        disMap.put("firstname",firstname);
        disMap.put("lastname", lastname);
        disMap.put("totalprice",totalprice);
        disMap.put("depositpaid",depositpaid);
        disMap.put("bookingdates",bookingdates);
        disMap.put("additionalneeds",additionalneeds);

        return disMap;

    }

    public Map<String,String> icMapMethod(String checkin,String checkout){

        Map<String,String> icMap=new HashMap<>();
        icMap.put("checkin",checkin);
        icMap.put("checkout",checkout);


        return icMap;

    }

}
