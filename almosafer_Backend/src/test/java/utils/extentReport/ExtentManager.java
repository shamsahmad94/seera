package utils.extentReport;

import com.relevantcodes.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Shams AlAfeef
 * @date 3/7/2022
 */
public class ExtentManager {

    private static ExtentReports extent;
    private static String reportFile;

    @BeforeSuite
    public static void setUp(ITestContext ctx) {
        DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        String suiteName = ctx.getCurrentXmlTest().getSuite().getName().trim().replaceAll("\\s+", "_").toLowerCase(Locale.ROOT);
        reportFile = "src/test/resources/extent_reports/" + suiteName + "." + currentDate + ".html";
    }

    public synchronized static ExtentReports getReporter() {
        if (extent != null)
            return extent;
        else
            return extent = new ExtentReports(reportFile, true);
    }
}
