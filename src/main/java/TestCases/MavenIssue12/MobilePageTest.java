package TestCases.MavenIssue12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;

import com.perfectomobile.httpclient.MediaType;
import com.perfectomobile.httpclient.utils.FileUtils;
import com.perfectomobile.selenium.MobileDriver;
import com.perfectomobile.selenium.api.IMobileDevice;
import com.perfectomobile.selenium.api.IMobileDriver;
import com.perfectomobile.selenium.api.IMobileWebDriver;
import com.perfectomobile.selenium.options.MobileDeviceFindOptions;
import com.perfectomobile.selenium.options.MobileDeviceOS;

public class MobilePageTest
{
	MobileDriver driver = new MobileDriver();
	IMobileWebDriver drivermob=null;
	MobileDeviceFindOptions options = new MobileDeviceFindOptions();
	IMobileDevice device= null;
	IMobileWebDriver nativeDriver = null;
	By appOpen=By.linkText("Apps");
	//Device open
	public void openDevice(String deviceId)
	{
		try 
		{
			// write your code here
			device= driver.getDevice(deviceId);
			device.open();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void openDevice(String operatingSystem,String osVersion)
	{
		try 
		{
			if(operatingSystem.equalsIgnoreCase("Android"))
			{
				options.setOS(MobileDeviceOS.ANDROID);
			}
			if(operatingSystem.equalsIgnoreCase("IOS"))
			{
				options.setOS(MobileDeviceOS.IOS);
			}

			options.setOSVersion(osVersion);
			IMobileDevice device = driver.findDevice(options);
			System.out.println(device.getDeviceId());
			device.open();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}




	public void openDevice(String operatingSystem,String osVersion,String model)
	{
		try 
		{
			if(operatingSystem.equalsIgnoreCase("Android"))
			{
				options.setOS(MobileDeviceOS.ANDROID);
			}
			if(operatingSystem.equalsIgnoreCase("IOS"))
			{
				options.setOS(MobileDeviceOS.IOS);
			}

			options.setOSVersion(osVersion);
			options.setModel(model);
			IMobileDevice device = driver.findDevice(options);
			System.out.println(device.getDeviceId());
			device.open();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void openDevice(String operatingSystem,String osVersion,String model,String manufacturer,String network )
	{
		try 
		{
			if(operatingSystem.equalsIgnoreCase("Android"))
			{
				options.setOS(MobileDeviceOS.ANDROID);
			}
			if(operatingSystem.equalsIgnoreCase("IOS"))
			{
				options.setOS(MobileDeviceOS.IOS);
			}

			options.setOSVersion(osVersion);
			options.setModel(model);
			options.setManufacturer(manufacturer);
			options.setNetwork(network);


			IMobileDevice device = driver.findDevice(options);
			System.out.println(device.getDeviceId());
			device.open();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	// Installing  App
	public void installApp( String appRepository)
	{
		//Set the application identifier and MobileCloud repository path

		String appRepositoryPath;

		//if(device.getProperty(MobileDeviceProperty.OS).equals("Android")){
		appRepositoryPath = appRepository;	
		//Define the nativeDriver
		//note: the same nativelDriver is used throughout the test
		//Install the demo app from the MobileCloud Public repository folder
		device.installApplication(appRepositoryPath);

		//Define the nativeDriver

	}

	//open app
	public void openApp(String type,String identifier)
	{
		
		nativeDriver = device.getNativeDriver(identifier);
		
		nativeDriver.findElement(locatortype(type,identifier)).click();

		
	}
	public void clicking(String type,String value)
	{
		if(nativeDriver.findElement(locatortype(type,value)).isDisplayed())
		nativeDriver.findElement(locatortype(type,value)).click();
		else
		{
			System.out.println("locator type" +type + "or value" +value + "not found");
		}
	}
	public void entering(String type,String value,String ch)
	{
		if(nativeDriver.findElement(locatortype(type,value)).isDisplayed())
		{
		nativeDriver.findElement(locatortype(type,value)).clear();
		nativeDriver.findElement(locatortype(type,value)).sendKeys(ch);
		}
		else
		{
			System.out.println("locator type" +type + "or value" +value + "not found");
		}
	}
	public  By locatortype(String type,String value)
	{
		By locName=null;
		if(type.equalsIgnoreCase("linkText"))
		{
			locName=By.linkText(value);
		}
		else if(type.equalsIgnoreCase("xpath"))
		{
			locName=By.xpath(value);
		}
		else if(type.equalsIgnoreCase("classname"))
		{
			locName=By.className(value);
		}
		else
			locName=By.partialLinkText(value);
		return locName;
	
	}

	//report with screenshots and video
	public  void downloadReport(IMobileDriver driver) 
	{
		InputStream reportStream = driver.downloadReport(MediaType.PDF);
		if (reportStream != null) 
		{
			String path = "C:\\Users\\sanyam.arora\\workspace\\Reports\\report5.pdf";
			File reportFile = new File(path);
			try 
			{
				FileUtils.write(reportStream, reportFile);
			} catch (IOException e) 
			{
				System.out.println("Failed to write report to path: " + path + " - " + e.getMessage());
			}
		}
	}


	//read excel sheet
	public  String[][] readSheet(String dataTablePath, String sheetName) throws IOException{
		/*Step 1: Get the XL Path*/
		File xlFile = new File(dataTablePath);
		/*step2: Access the Xl File*/
		FileInputStream  xlDoc = new FileInputStream(xlFile);
		/*Step3: Access the work book */
		HSSFWorkbook  wb = new HSSFWorkbook(xlDoc);
		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);
		int iRowCount = sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();
		String[][] xlData = new String[iRowCount][iColCount];
		for(int i = 0; i <iRowCount; i++ ){
			for(int j= 0 ; j <iColCount; j++){
				/*Step 5: Access the particular cell*/
				HSSFCell cell = sheet.getRow(i).getCell(j);
				if(cell!=null)
					xlData[i][j] = cell.getStringCellValue();
				else
					xlData[i][j] = sheet.getRow(i).createCell(j).getStringCellValue();
			}
		}
		return xlData;
	}



	//closing device
	public void closeDevice()
	{
		driver.quit();
	}

	//sleep function
	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

}
