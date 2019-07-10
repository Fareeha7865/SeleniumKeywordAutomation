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
//import org.isb.training.selenium.Automation;
//import org.zia.training.selenium.keyword.Driver;
//import org.zia.training.selenium.keyword.ExcelSheetDriver;

import jxl.Sheet;
import jxl.read.biff.BiffException;

public class Automation {
	 final static Logger logger = Logger.getLogger(Automation.class);
	 public static void main(String[] args) throws FileNotFoundException, IOException, BiffException, NumberFormatException, InterruptedException {
	 //  Driver d = new Driver();
		 ExcelSheetDriver excelSheetDriver = new ExcelSheetDriver();
	   Sheet testSuitesheet = excelSheetDriver.getWorksheet("./TestCases/TestSuite.xls", "Sheet1");
	    int c = excelSheetDriver.columnCount();
		int r = excelSheetDriver.rowCount();

	   for(int i = 1;i<r;i++)
		{
			String SNo = excelSheetDriver.readCell(testSuitesheet,0, i);

			String Description = excelSheetDriver.readCell(testSuitesheet,1, i);
			String ExecutionFlag = excelSheetDriver.readCell(testSuitesheet,2, i);
//			logger.info("TestSuite:" + SNo);
//			logger.info("TestSuite:" + Description);
//			logger.info("TestSuite:" + ExecutionFlag);
			System.out.println("TestSuite:" + SNo);
			System.out.println("TestSuite:" + Description);
			System.out.println("TestSuite:" + ExecutionFlag);


}
	
}
}