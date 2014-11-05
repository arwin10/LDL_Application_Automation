package com.ldlapp.basecontroller;

//External Packages importing

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidLauncher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;

import com.ldlapp.DataBaseUtility.DataBaseUtilities;
import com.ldlapp.commonutilities.CommonUtilities;
import com.opera.core.systems.OperaDriver;



//BaseController for Multiple Parallel Browser Execution

public class BaseControllerParallelExecution {
  
	 public String URL, Node;
	 protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	 //String browserName = null;
	 
	 private static ChromeDriverService serviceChrome;
	 private static InternetExplorerDriverService serviceIE;
	 private static FirefoxProfile serviceFirefox;
	 private SelendroidLauncher selendroidServer = null;
	  private WebDriver driver;

	 
	@BeforeTest
	public List<Object> initializeApplication(String moduleName,String testCaseName,DataBaseUtilities DBUtilities,CommonUtilities CUtilities,String browserName)
	{    
		 List<Object> list = new ArrayList<Object>();
		 Properties p=null;
		 WebDriver driver=null;
		 ArrayList moduleRecord=null;
		 Map map=null;
		
		
		  try{
			  
			 
			  p=CUtilities.getProperty();
			  
			  //Getting data connection from oracle database
			  DBUtilities.DatabaseConnection();
			  
			  //Getting data from oracle database
			  moduleRecord = DBUtilities.setDBRecord(moduleName);
			  
			  //getting data connection from the excel file
			  //DBUtilities.excelDatabaseConnection();
			  
			  //getting data from the excel file
			  //moduleRecord=DBUtilities.excelSetDBRecord(moduleName);
			  
		      /*Getting DataBase TestData on the Console */
			  //System.out.println("DataBase Contains following number of Records:"+moduleRecord.size());
			  //System.out.println("DataBase Contains the following Data:"+moduleRecord);
			  
			  list.add(moduleRecord);
			  list.add(p);
			  
			
			  if(browserName.equalsIgnoreCase("Firefox"))
		      { 
				  
				  System.out.println(" Executing on FireFox");
				  
				  String Node = "http://localhost:5555/wd/hub";
				  //String Node = "http://bigcanyon.cisco.com:9091/wd/hub";
				  DesiredCapabilities cap = DesiredCapabilities.firefox();
				  cap.setBrowserName("firefox");

				  driver = new RemoteWebDriver(new URL(Node), cap);
				  //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				  
				  list.add(driver);
		      }
			  
			  if(browserName.equalsIgnoreCase("Safari"))
		      {   
				  System.out.println(" Executing on SAFARI");
				  DesiredCapabilities cap = DesiredCapabilities.safari();
				  cap.setBrowserName("safari");
				  String Node = "http://localhost:5556/wd/hub";
			
				  driver = new RemoteWebDriver(new URL(Node), cap);
				  
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				  
			      list.add(driver);
		      }
			  
			  if(browserName.equalsIgnoreCase("Opera"))
		      {   
				  System.out.println(" Executing on OPERA");
				  DesiredCapabilities cap = DesiredCapabilities.opera();
				  cap.setCapability("opera.binary", "C:\\Program Files (x86)\\Opera\\launcher.exe");
				  cap.setBrowserName("opera");
				  String Node = "http://localhost:5559/wd/hub";
			
				  driver = new RemoteWebDriver(new URL(Node), cap);
				  
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				
			      list.add(driver);
		      }
			  
			  if(browserName.equalsIgnoreCase("InternetExplorer"))
			  { 
				
				  System.out.println(" Executing on IE");
				  
				 /* serviceIE = new InternetExplorerDriverService.Builder()
			        .usingDriverExecutable(new File("c:\\IEDriverServer.exe"))
			        .usingAnyFreePort()
			        .build();
				  serviceIE.start();*/
				  
				  DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
				  cap.setBrowserName("ie");
				  String Node = "http://localhost:5558/wd/hub";
			
				  driver = new RemoteWebDriver(new URL(Node), cap);
				  
				  //driver = new RemoteWebDriver(serviceIE.getUrl(), cap);
				  
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				  
			      list.add(driver);
			  }
		      
			  if(browserName.equalsIgnoreCase("Chrome"))
			  { 
				  System.out.println(" Executing on CHROME");
				  
				  serviceChrome = new ChromeDriverService.Builder()
			        .usingDriverExecutable(new File("c:\\chromedriver.exe"))
			        .usingAnyFreePort()
			        .build();
				  serviceChrome.start();
				  
				  
				  DesiredCapabilities cap = DesiredCapabilities.chrome();
				  cap.setBrowserName("chrome");
				  cap.setCapability("chrome.binary", "C:\\Users\\arinsark\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
				  String Node = "http://localhost:5557/wd/hub";
				  
				 // driver = new RemoteWebDriver(new URL(Node), cap);

				  driver = new RemoteWebDriver(serviceChrome.getUrl(), cap);
				  
				 
				  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
				  driver.manage().window().maximize();
				  
		        list.add(driver);
	            
			  }  
			  
			  if(browserName.equalsIgnoreCase("Android"))
			  { 
				  System.out.println(" Executing on Android");
				  
				  if (selendroidServer != null) {
				      selendroidServer.stopSelendroid();
				    }
				    SelendroidConfiguration config = new SelendroidConfiguration();

				    selendroidServer = new SelendroidLauncher(config);
				    selendroidServer.launchSelendroid();

				   DesiredCapabilities caps = SelendroidCapabilities.android();

				   // driver = new SelendroidDriver(caps);
				     driver = new RemoteWebDriver(caps);
				  
				  //Launching in Selenium Grid
				  /*  
				  SelendroidCapabilities caps =
				      new SelendroidCapabilities(
				          "io.selendroid.testapp:0.11.0");
				  
				   
				     String Node = "http://localhost:4444/wd/hub";
					caps.setBrowserName("Android");	
					  driver = new RemoteWebDriver(new URL(Node), caps);   
				     */
					  
				  
		        list.add(driver);
	            
			  }  
			  
			  
		      
			  if(driver==null)
			  {
				  System.out.println("No matching driver found for the browser.");
			  }
			  
			  Thread.sleep(5000);
		   }
		   catch(Exception e)
		   {
			 System.out.println("Error occured:"+e);
		   }
		  return list;
    }
	
	
}
