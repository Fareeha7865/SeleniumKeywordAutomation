package org.isb.training.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctionsLib {
	
	final static Logger logger = Logger.getLogger(CommonFunctionsLib.class);
	
	WebDriver driver;

	CommonFunctionsLib(WebDriver driver) {
		this.driver = driver;
	}

	public boolean performActions(String Keyword, String value, String xpathExpression) throws NumberFormatException, InterruptedException {
		//logger.debug("Keyword: " + Keyword + "value: " + value + "xpathExpression: " + xpathExpression);
		System.out.println("Keyword: " + Keyword + "value: " + value + "xpathExpression: " + xpathExpression);
		if (Keyword.equalsIgnoreCase("Click")) {
			driver.findElement(By.xpath(xpathExpression)).click();
			logger.info("Click is performed sucessfully");		
			return true;
		} else if (Keyword.equalsIgnoreCase("Input")) {
			driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
			logger.info("Input is performed sucessfully");
			return true;
			
		} else if (Keyword.equalsIgnoreCase("Radio-Male")) {
//				driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
//				logger.info("Input is performed sucessfully");
			
			//Identifying Male radio button using its ID as an locator

            WebElement maleRadioBtn = driver.findElement(By.id(xpathExpression));

           

            //Checking if the Male Radio button is displayed on the Webpage and printing the status

            boolean radioBtnIsDisplayed = maleRadioBtn.isDisplayed();

            System.out.println("Is Male radio button displayed: "+radioBtnIsDisplayed);

           

            //Checking if the Male Radio button is enabled on the webpage and printing the status

            boolean radioBtnIsEnabled = maleRadioBtn.isEnabled();

            System.out.println("Is Male radio button enabled: "+radioBtnIsEnabled);

           

            //Checking the default radio button selection status

            boolean radioBtnIsSelected = maleRadioBtn.isSelected();

            System.out.println("Default Radio button selection Status: "+radioBtnIsSelected);

           

            //Selecting male radio button

            maleRadioBtn.click();

           

            //rechecking the male radio button selection status and printing it..

            boolean radioBtnNewSelectionStatus = maleRadioBtn.isSelected();

            System.out.println("Male radio Selection status after perform click() event: "+radioBtnNewSelectionStatus);
			
			
			
			return true;
				
			
				
		
		
		} else if (Keyword.equalsIgnoreCase("Radio-Female")) {
//				driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
//				logger.info("Input is performed sucessfully");
			
			//Identifying Male radio button using its ID as an locator

            WebElement maleRadioBtn = driver.findElement(By.id(xpathExpression));

           

            //Checking if the Male Radio button is displayed on the Webpage and printing the status

            boolean radioBtnIsDisplayed = maleRadioBtn.isDisplayed();

            System.out.println("Is Male radio button displayed: "+radioBtnIsDisplayed);

           

            //Checking if the Male Radio button is enabled on the webpage and printing the status

            boolean radioBtnIsEnabled = maleRadioBtn.isEnabled();

            System.out.println("Is Male radio button enabled: "+radioBtnIsEnabled);

           

            //Checking the default radio button selection status

            boolean radioBtnIsSelected = maleRadioBtn.isSelected();

            System.out.println("Default Radio button selection Status: "+radioBtnIsSelected);

           

            //Selecting male radio button

            maleRadioBtn.click();

           

            //rechecking the male radio button selection status and printing it..

            boolean radioBtnNewSelectionStatus = maleRadioBtn.isSelected();

            System.out.println("Male radio Selection status after perform click() event: "+radioBtnNewSelectionStatus);
			
			
			
			return true;
				
			
				
		}
		
		else if (Keyword.equalsIgnoreCase("gettext")) {
			driver.findElement(By.xpath(xpathExpression)).getText();
			logger.info("getText is performed sucessfully");
			return true;
		} else if (Keyword.equalsIgnoreCase("url")) {
			driver.get(value);
			logger.info("Url is opened sucessfully");
			return true;
		} else if (Keyword.equalsIgnoreCase("CloseBrowser")) {
			driver.close();
			logger.info("Browser is closed sucessfully");
				return true;
				
						
		} else if (Keyword.equalsIgnoreCase("sleep")) {
			if (value.equalsIgnoreCase("level1")) {
				Thread.sleep(3000);
			} else if (value.equalsIgnoreCase("level2")) {
				Thread.sleep(7000);
			} else if (value.equalsIgnoreCase("level3")) {
				Thread.sleep(15000);
			} else if (value.equalsIgnoreCase("level4")) {
				Thread.sleep(20000);
			} else if (value.equalsIgnoreCase("level4")) {
				Thread.sleep(25000);
			} else {
				Thread.sleep(5000);
			}
			logger.info("sleep is done sucessfully");
			return true;
		}
		else if(Keyword.equalsIgnoreCase("VerifyText")){
			
		     if(value.equalsIgnoreCase(driver.findElement(By.xpath(xpathExpression)).getText()))
		     {
		    	 logger.info("verify text true");
		    	 return true;
		     } else {
		    	 logger.info("verify text failed");
		    	 return false;
		     }
			
		}
		else if(Keyword.equalsIgnoreCase("Pop"))
		{
			// Do nothing
		}
	

		return false;
	}

}
