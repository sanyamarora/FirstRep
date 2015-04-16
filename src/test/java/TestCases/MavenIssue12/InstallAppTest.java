package TestCases.MavenIssue12;


import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;

import TestCases.MavenIssue12.MobilePageTest;

import com.perfectomobile.selenium.MobileDevice;
import com.perfectomobile.selenium.api.IMobileDriver;

//import pages.*;
public class InstallAppTest extends MobilePageTest {
	
@Test

//	public  void installing() throws IOException, InterruptedException
//	{
//	String[][] str= readSheet("C:\\Users\\sanyam.arora\\Downloads\\locators.xls","Sheet1");
//	System.out.println("Run Started");
//		openDevice("ED82E4F1");
//		Thread.sleep(5000);
//		openApp(str[1][1]);
//		Thread.sleep(5000);
//       device.getMobileKeyboard().pressKey("BACK");
//       Thread.sleep(5000);
//       openApp(str[1][1]);
//       Thread.sleep(5000);
//       openApp(str[2][1]);
//       //IMobileWebDriver webDriver7 = driver.getDevice("1DAA7935").getNativeDriver();
//       nativeDriver.findElement(By.className(str[3][1])).click();
//       nativeDriver.findElement(By.className(str[3][1])).clear();
//       nativeDriver.findElement(By.className(str[3][1])).sendKeys("Australia");
//       nativeDriver.findElement(By.xpath(str[4][1])).click();
//       nativeDriver.findElement(By.xpath(str[5][1])).clear();
//       nativeDriver.findElement(By.xpath(str[5][1])).sendKeys("123");
//       nativeDriver.findElement(By.className(str[6][1])).click();
//       nativeDriver.findElement(By.xpath(str[7][1])).getText();
//       Thread.sleep(3000);
//       nativeDriver.findElement(By.linkText(str[8][1])).click();
//        driver.quit();
//        downloadReport(driver);
//		System.out.println("Run ended");
//		
//	}

public  void installing() throws IOException, InterruptedException
{
String[][] str= readSheet("C:\\Users\\sanyam.arora\\Downloads\\locators.xls","Sheet1");
System.out.println("Run Started");
	openDevice("ED82E4F1");
	Thread.sleep(5000);
	 openApp(str[1][2],str[1][1]);
	Thread.sleep(5000);
   device.getMobileKeyboard().pressKey("BACK");
   Thread.sleep(5000);
   openApp(str[1][2],str[1][1]);
   Thread.sleep(5000);
   openApp(str[2][2],str[2][1]);
   //IMobileWebDriver webDriver7 = driver.getDevice("1DAA7935").getNativeDriver();
   clicking(str[3][2],str[3][1]);
  
   entering(str[3][2],str[3][1],"Australia");
   clicking(str[4][2],str[4][1]);
   entering(str[4][2],str[5][1],"123");
   clicking(str[3][2],str[6][1]);
   nativeDriver.findElement(locatortype(str[4][2],str[7][1])).getText();
   Thread.sleep(3000);
   clicking(str[1][2],str[8][1]);
    driver.quit();
    downloadReport(driver);
	System.out.println("Run ended");
	
}
}
