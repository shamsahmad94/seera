package constants;

public class EndPoints {
    public static final String HOST;
    public static final String CALCULATE_REWARDS;
    public static final String FLIGHT_QUOTE;

    static {

        HOST = "https://www.almosafer.com/";
        CALCULATE_REWARDS=HOST+"api/loyalty/bulk-calculate-reward";
        FLIGHT_QUOTE=HOST+"pi/v3/flights/flight/quote/itineraryId/fo8gobdtqkfhrcy9,8m7e9pi03fv0ulbuJ9-1e09edd7_TFN_V3";

    }
}
