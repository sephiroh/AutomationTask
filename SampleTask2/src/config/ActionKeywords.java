package config;

import static executionEngine.DriverScript.OR;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import executionEngine.DriverScript;
import utility.Log;

public class ActionKeywords {

	public static WebDriver driver;
	public static Actions action;
	public static Select dropdown;
	public static WebElement element;
	public static int iIndex;
	public static boolean bFlag;
	public static String strTemp;
	
	
	public static void openBrowser(String object, String data){	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", Constants.Exepath);
		driver = new ChromeDriver(options);
		Log.info("Opening Browser");
		try{
			driver.get("https://accounts.amaysim.com.au/identity/login/");
			DriverScript.bResult = true;
		}catch (Exception e){
			Log.error("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	
	
	public static void enter(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).clear();
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			DriverScript.bResult = true;
		 }catch(Exception e){
			 Log.error("Not able to Enter text --- " + e.getMessage());
			 DriverScript.bResult = false;
		 }
	}
	
	public static void click(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			iIndex = object.indexOf("rdo");
			if(iIndex==-1){
				object = OR.getProperty(object);
			}else{
				object = selectYesNo(object,data);
			}
			element = driver.findElement(By.xpath(object));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView(true);",element);
			element.click();			
			DriverScript.bResult = true;
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         }
	}
	
	public static void select(String object, String data){
		try{
			Log.info("Selecting " + data +  " on Webelement "+ object);
			dropdown = new Select(driver.findElement(By.xpath(OR.getProperty(object))));
			dropdown.selectByValue(data);			
			DriverScript.bResult = true;
		 }catch(Exception e){
 			Log.error("Not able to select --- " + e.getMessage());
 			DriverScript.bResult = false;
         }
	}
	
	public static void verify(String object, String data){
		try{
			Log.info("Checking if " + data + " is displayed in " + object);
			strTemp = driver.findElement(By.xpath(OR.getProperty(object))).getText();
			if (strTemp.indexOf(data) == -1) {
				Log.error(data + " is NOT displayed in " + object);
				DriverScript.bResult = false;
			}else{
				Log.info(data + " is displayed in " + object);
				DriverScript.bResult = true;
			}	
		 }catch(Exception e){
			 Log.error("Not able to verify object --- " + e.getMessage());
			 DriverScript.bResult = false;
		 }
	}
		
	public static void isEnabled(String object, String data){
		try{
			if (data.equalsIgnoreCase("true")) {
				Log.info("Checking if " + object + " is enabled");
			} else if (data.equalsIgnoreCase("false")) {
				Log.info("Checking if " + object + " is disabled");
			}
			bFlag = driver.findElement(By.xpath(OR.getProperty(object))).isEnabled();
			if (String.valueOf(bFlag).equalsIgnoreCase(data)) {
				if (data.equalsIgnoreCase("true")) {
					Log.info(object + " is Enabled");
				} else if (data.equalsIgnoreCase("false")) {
					Log.info(object + " is Disabled");
				}
				DriverScript.bResult = true;
			}else{
				if (data.equalsIgnoreCase("true")) {
					Log.error(object + " is NOT Enabled");
				} else if (data.equalsIgnoreCase("false")) {
					Log.error(object + " is NOT Disabled");
				}
				DriverScript.bResult = false;
			}	
		 }catch(Exception e){
			 Log.error("Not able to check object if enable --- " + e.getMessage());
			 DriverScript.bResult = false;
		 }
	}
	
	public static void isSelected(String object, String data){
		try{
			Log.info("Checking if " + object + " is selected/deselected");
			bFlag = driver.findElement(By.xpath(OR.getProperty(object))).isSelected();
			if (String.valueOf(bFlag).equalsIgnoreCase(data)) {
				Log.info(object + " is Selected/Deselected");
				DriverScript.bResult = true;
			}else{
				Log.error(object + " is NOT Selected/Deselected");
				DriverScript.bResult = false;
			}	
		 }catch(Exception e){
			 Log.error("Not able to check object if selected --- " + e.getMessage());
			 DriverScript.bResult = false;
		 }
	}
	
	public static void isVisible(String object, String data){
		try{
			Log.info("Checking if " + object + " is visible");
			bFlag = driver.findElement(By.xpath(OR.getProperty(object))).isDisplayed();
			if (bFlag==true) {
				Log.info(object + " is Visible");
				DriverScript.bResult = true;
			}
		 }catch(Exception e){
			 Log.error("Object is not visible --- " + e.getMessage());
			 DriverScript.bResult = false;
		 }
	}
	
	public static void navigate(String object, String data){
		try{
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			DriverScript.bResult = true;
			driver.get(data);
		}catch(Exception e){
			Log.error("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	
	public static void waitFor(String object, String data){
		try{
			Log.info("Wait for 10 seconds");
			Thread.sleep(10000);
			DriverScript.bResult = true;
		 }catch(Exception e){
			 Log.error("Not able to Wait --- " + e.getMessage());
			 DriverScript.bResult = false;
         }
	}
	
	public static void pressESC(String object, String data){
		try{
			Log.info("Pressing ESC");
			action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).perform();
			DriverScript.bResult = true;
		 }catch(Exception e){
			 Log.error("Not able to press ESC --- " + e.getMessage());
			 DriverScript.bResult = false;
         }
	}
	
	public static void closeBrowser(String object, String data){
		try{
			Log.info("Closing the browser");
			DriverScript.bResult = true;
			driver.quit();
		 }catch(Exception e){
			 Log.error("Not able to Close the Browser --- " + e.getMessage());
			 DriverScript.bResult = false;
         }
	}
	
	
	//Private Functions
	private static String selectYesNo(String object, String data) {
		if (data.equalsIgnoreCase("YES")) {
			object = OR.getProperty(object) + "true']//following-sibling::span";
		}else if (data.equalsIgnoreCase("NO")){
			object = OR.getProperty(object) + "false']//following-sibling::span";
		}
		return object;
	}
	
	
}
