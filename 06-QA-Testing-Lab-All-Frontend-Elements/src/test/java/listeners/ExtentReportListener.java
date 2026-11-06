
package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        try {
            Files.createDirectories(Paths.get("target/extent-reports"));
        } catch (Exception e) {
            throw new RuntimeException("Unable to create report directory", e);
        }

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter("target/extent-reports/ExtentReport.html");

        sparkReporter.config().setDocumentTitle("QA Testing Lab - Test Report");
        sparkReporter.config().setReportName("Selenium Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Project", "QA Testing Lab - All Frontend Elements");
        extent.setSystemInfo("Framework", "Selenium WebDriver with TestNG");
        extent.setSystemInfo("Tester", "Namritha Dsouza");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        test.remove();
    }
}
