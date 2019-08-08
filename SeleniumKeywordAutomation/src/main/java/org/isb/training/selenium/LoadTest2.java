package org.isb.training.selenium;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//--
import org.openqa.selenium.By;
//--
import org.openqa.selenium.WebDriver;
//--
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//--
import org.openqa.selenium.firefox.FirefoxDriver;
//--
import org.testng.Assert;
//--
import org.testng.annotations.AfterClass;
//--
import org.testng.annotations.BeforeClass;
//--
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.read.biff.BiffException;

public class LoadTest2 {
	
	final static Logger logger = Logger.getLogger(Automation.class);

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	System.setProperty("webdriver.chrome.driver","./webdriver/chromedriver.exe");
       driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
      
    @Test
	public void abc() throws FileNotFoundException, IOException, BiffException, NumberFormatException, InterruptedException {
        //Creating class objects
		Driver d = new Driver();
		ExcelSheetDriver excelSheetDriver = new ExcelSheetDriver();
		ExcelSheetDriver excelSheetDriver1 = new ExcelSheetDriver();
		ExcelSheetDriver excelSheetDriver2 = new ExcelSheetDriver();
		
		Sheet testSuitesheet = excelSheetDriver.getWorksheet("./TestCases/TestSuite.xls", "Sheet1");
		// WebDriver driver = d.InitateDriver();

		//driver.get("https://login.live.com/login.srf?wa = wsignin1.0&rpsnv = 13&ct = 1510644152&rver = 6.7.6640.0&wp = MBI_SSL&wreply = https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d02d9a83a-4a66-dba6-f710-5248efde97fc&id = 292841&CBCXT = out&lw = 1&fl = dob%2cflname%2cwld&cobrandid = 90015");
		Utilities.loadlog4jfile();
		int c = excelSheetDriver.columnCount();
		int r = excelSheetDriver.rowCount();

		for(int i = 1;i<r;i++)
		{
			String SNo = excelSheetDriver.readCell(testSuitesheet,0, i);

			String Description = excelSheetDriver.readCell(testSuitesheet,1, i);
			String ExecutionFlag = excelSheetDriver.readCell(testSuitesheet,2, i);
			logger.info("TestSuite:" + SNo);
			logger.info("TestSuite:" + Description);
			logger.info("TestSuite:" + ExecutionFlag);

			if(ExecutionFlag.equalsIgnoreCase("Y")){
				Sheet TestCasesheet =  excelSheetDriver1.getWorksheet("./TestCases/TestCase.xls", Description);
				int rTestcase = excelSheetDriver1.rowCount();
				int cTestCase = excelSheetDriver1.columnCount();

				for(int k = 1; k < rTestcase; k++)
				{
					String snoTestCase = excelSheetDriver1.readCell(TestCasesheet,0, k);
					String testCaseNumber = excelSheetDriver1.readCell(TestCasesheet,1, k);
					String testcaseDescription = excelSheetDriver1.readCell(TestCasesheet,2, k);
					String testcaseExecutionFlag = excelSheetDriver1.readCell(TestCasesheet,3, k);
					logger.info("TestCases:" + snoTestCase);
					logger.info("TestCases:" + testCaseNumber);
					logger.info("TestCases:" + testcaseDescription);
					logger.info("TestCases:" + testcaseExecutionFlag);


					if(testcaseExecutionFlag.equalsIgnoreCase("y"))
					{
						Sheet testStepsheet = excelSheetDriver2.getWorksheet("./TestCases/BankTestSteps.xls", Description);
						int rowTestSteps = excelSheetDriver2.rowCount();
						int columnTestSteps = excelSheetDriver2.columnCount();
						WebDriver driver = d.InitateDriver();
						CommonFunctionsLib comlib = new CommonFunctionsLib(driver);
						for(int w = 1; w < rowTestSteps; w++)
						{
							String snoTestSteps = excelSheetDriver.readCell(testStepsheet,0, w);
							String testStepcaseNumber = excelSheetDriver.readCell(testStepsheet,1, w);
							String desTestSteps = excelSheetDriver.readCell(testStepsheet,2, w);
							String xpathTestSteps = excelSheetDriver.readCell(testStepsheet,3, w);
							String value = excelSheetDriver.readCell(testStepsheet,4, w);
							String keywordTestSteps = excelSheetDriver.readCell(testStepsheet,5, w);
							if(testCaseNumber.equalsIgnoreCase(testStepcaseNumber)){
								logger.info("snoTestSteps:" + snoTestSteps);
								logger.info("desTestSteps:" + desTestSteps);
								logger.info("xpathTestSteps:" + xpathTestSteps);
								logger.info("value:" + value);
								logger.info("keywordTestSteps:" + keywordTestSteps);
								logger.info("Executing PerformAction method with the 3 arguments - {} {} {} " + keywordTestSteps +" " + value +" " + xpathTestSteps);
							//	System.out.println("Executing PerformAction method with the 3 arguments - {} {} {} " + "Keyword :"  keywordTestSteps +" " + "Value:" + value + " " +  "XpathExpression :" + xpathTestSteps);
								comlib.performActions(keywordTestSteps, value, xpathTestSteps);
							}

						}

					}
				}

			}
		}

		excelSheetDriver.closeworkbook();
		excelSheetDriver2.closeworkbook();
		excelSheetDriver1.closeworkbook();

	}
    
    //@Test
    public void verifySearchButton() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));

        String text = search_button.getAttribute("value");

        Assert.assertEquals(text, search_text, "Text not found!");
    }
}