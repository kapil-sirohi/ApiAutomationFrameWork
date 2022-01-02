package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtils {

	ExtentHtmlReporter htmlReporter;

	ExtentReports extentReports;

	ExtentTest extentTest;

	public ExtentReportUtils(String fileName) {
		htmlReporter = new ExtentHtmlReporter(fileName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
	}

	public void createTestCase(String testCaseName) {
		extentTest = extentReports.createTest(testCaseName);
	}

	public void addLog(Status status, String markup) {
		extentTest.log(status, markup);
	}

	public void closeReports() {
		extentReports.flush();
	}

}
