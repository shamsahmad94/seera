package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
/**
 * @author Shams AlAfeef
 * @date 3/7/2022
 */
public class RequestBodyHelper {
    private static JsonObject bulkCalculateRewardsBuilder(Object... values) {
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("method",  String.valueOf(values[0]));
        requestBody.addProperty("productType", String.valueOf(values[1]));

        JsonObject indexOne = new JsonObject();
        indexOne.addProperty("itemId",String.valueOf(values[2]));
        indexOne.addProperty("netAmount", Integer.valueOf((Integer) values[3]));
        indexOne.addProperty("currency", String.valueOf(values[4]));

        JsonObject meta = new JsonObject();
        meta.addProperty("airlineCode", String.valueOf(values[5]));
        meta.addProperty("isDomestic", Boolean.valueOf((Boolean) values[6]));
        meta.addProperty("isInternational", Boolean.valueOf((Boolean) values[7]));
        meta.addProperty("productPriceTotal", Integer.valueOf((Integer) values[8]));
        meta.addProperty("productPriceBase", Integer.valueOf((Integer) values[9]));
        meta.addProperty("productPriceTax", Integer.valueOf((Integer) values[10]));
        meta.addProperty("totalWithoutVat", Integer.valueOf((Integer) values[11]));
        indexOne.add("meta",meta);

        JsonArray  item=new JsonArray();

        item.add(indexOne);
        requestBody.add("item",item);
        return requestBody;
    }

    public static JsonObject bulkCalculateRewards(String method, String productType, String itemId, Integer netAmount,
                                                  String currency,String airlineCode,Boolean isDomestic , Boolean isInternational,
                                                  Integer productPriceTotal,Integer productPriceBase,Integer productPriceTax ,Integer totalWithoutVat ) {

        return bulkCalculateRewardsBuilder(method, productType, itemId, netAmount,currency,airlineCode,isDomestic,isInternational
                ,productPriceTotal,productPriceBase,productPriceTax,totalWithoutVat);

    }
}
