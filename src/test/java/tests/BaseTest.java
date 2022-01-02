package tests;

import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import request.RequestFactory;
import utils.ConfigRead;
import utils.ExtentReportUtils;

public class BaseTest {

	String configFileName;
	Properties configProperties;

	RequestFactory requestFactory;

	String currentWorkingDirectory;
	String htmlReporterFileName;

	ExtentReportUtils extentReportUtils;

	@BeforeSuite
	public void preSetup() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		configFileName = currentWorkingDirectory + "/src/test/resources/config/config.properties";
		configProperties = ConfigRead.readConfigPeoperties(configFileName);

		htmlReporterFileName = currentWorkingDirectory + "/src/test/resources/reports/htmlReport.html";
		extentReportUtils = new ExtentReportUtils(htmlReporterFileName);
	}

	@BeforeClass
	public void setUp() {
		requestFactory = new RequestFactory();

		RestAssured.baseURI = configProperties.getProperty("baseUrl");
		RestAssured.port = Integer.parseInt(configProperties.getProperty("portNumber"));
	}

	@AfterMethod
	public void postTestCheck(ITestResult result) {
		// String testName = result.getName();
		if (result.getStatus() == result.SUCCESS) {
			extentReportUtils.addLog(Status.PASS, "Test Passed");
		} else if (result.getStatus() == result.FAILURE) {
			extentReportUtils.addLog(Status.FAIL, "Fail Passed");
		} else {
			extentReportUtils.addLog(Status.SKIP, "Skip Test");
		}
	}

	@AfterClass
	public void cleanUp() {
		RestAssured.reset();
		extentReportUtils.closeReports();
	}

}
