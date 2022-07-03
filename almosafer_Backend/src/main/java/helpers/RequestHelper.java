package helpers;

import com.google.gson.JsonObject;
import constants.Constant;
import io.restassured.RestAssured;
import io.restassured.response.Response;
/**
 * @author Shams AlAfeef
 * @date 3/7/2022
 */
public class RequestHelper {
    private static String errorMsg = "";


    public static Response postMethod(JsonObject bodyRequest, String url) {
        try {
            return RestAssured.given().that().header(Constant.LANGUAGE, Constant.ENGLISH)
                    .and().header(Constant.CONTENT_TYPE, Constant.SON_CONTENT_TYPE)
                    .and().body(bodyRequest.toString()).when().post(url).thenReturn();
        } catch (Throwable throwable) {
            errorMsg = "Error: " + throwable.getMessage();
            return null;
        }
    }

    public static Response getMethod(String url) {
        try {
            return RestAssured.given().that().header(Constant.LANGUAGE, Constant.ENGLISH)
                    .and().header(Constant.CONTENT_TYPE, Constant.SON_CONTENT_TYPE)
                    .when().get(url).thenReturn();
        } catch (Throwable throwable) {
            errorMsg = "Error: " + throwable.getMessage();
            return null;
        }
    }
}
