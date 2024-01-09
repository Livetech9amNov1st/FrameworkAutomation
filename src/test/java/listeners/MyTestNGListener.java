package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class MyTestNGListener extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String screenshotsFolderPath=System.getProperty("user.dir")+"\\screenshots";
		File screenshotsFolder=new File(screenshotsFolderPath);
		
		screenshotsFolder.mkdir();
		
		String testName=result.getMethod().getMethodName();
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String date=simpleDateFormat.format(new Date());
		
		System.out.println(date);
		
		date=date.replace(":", "-");
		
		System.out.println(date);
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(screenshotsFolderPath+"\\"+testName+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenshotsFolderPath+"\\"+testName+date+".png");
		
		test.log(Status.PASS, testName+" is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String screenshotsFolderPath=System.getProperty("user.dir")+"\\screenshots";
		File screenshotsFolder=new File(screenshotsFolderPath);
		
		screenshotsFolder.mkdir();
		
		String testName=result.getMethod().getMethodName();
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String date=simpleDateFormat.format(new Date());
		
		System.out.println(date);
		
		date=date.replace(":", "-");
		
		System.out.println(date);
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(screenshotsFolderPath+"\\"+testName+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenshotsFolderPath+"\\"+testName+date+".png");
		
		test.log(Status.FAIL, testName+" is failed");
		
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
