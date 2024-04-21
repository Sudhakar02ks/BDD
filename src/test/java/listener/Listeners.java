package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.BasePage;

public class Listeners extends BaseTest implements ITestListener{

	public void onTestStart(ITestResult result) {
	
	}

	public void onTestSuccess(ITestResult result) {
		String Res=result.getMethod().getMethodName();
	Test.log(Status.PASS, Res);
	String SS=BasePage.ScreenShot();
	Test.addScreenCaptureFromPath(SS);
	}

	public void onTestFailure(ITestResult result) {
	
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	
}
