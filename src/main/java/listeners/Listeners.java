package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		
		extentTest = extentReport.createTest(testName);
		extentTestThread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName =result.getName();
		extentTestThread.get().log(Status.PASS,testName+"got Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTestThread.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String testMethodName = result.getName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String screenshotFilePath = takesScreenshot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
}
