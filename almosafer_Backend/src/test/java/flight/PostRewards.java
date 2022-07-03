package flight;
import constants.EndPoints;
import enums.StatusCode;
import helpers.RequestHelper;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.extentReport.ExtentTestManager;
import utils.listener.TestListener;

import java.lang.reflect.Method;
import static helpers.RequestBodyHelper.bulkCalculateRewards;

/**
 * @author Shams AlAfeef
 * @date 3/7/2022
 */
@Listeners(TestListener.class)
public class PostRewards {
    public final SoftAssert softAssert = new SoftAssert();

    @Test(priority = 0, description = "Successfully run the post method ")
    public void calculateBulkRewards( Method method) {
       ExtentTestManager.startTest(method.getName(), "Successfully run the post method ");
        //expected values
        int expectedCode = StatusCode.OK.getValue();
        String expectedStatusLine = StatusCode.OK.getDescription();
        //Request
        Response response = RequestHelper.postMethod(bulkCalculateRewards("qitaf", "flight", "item-0", 10, "SAR"
                , "", false, true, 10, 10, 10, 10), EndPoints.CALCULATE_REWARDS);
        //Assertion
        if (response != null) {
            ResponseBody body = response.getBody();
            Assert.assertEquals(response.statusCode(), expectedCode, "Status code must be 200");
            softAssert.assertTrue(response.getStatusLine().contains(expectedStatusLine), "Status line must be OK");
        } else {
            System.out.println("Failed ");
        }
    }

}
