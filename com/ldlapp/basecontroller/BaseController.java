package com.ldlapp.basecontroller;

//External Packages importing

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;

import com.ldlapp.DataBaseUtility.DataBaseUtilities;
import com.ldlapp.commonutilities.CommonUtilities;
import com.opera.core.systems.OperaDriver;

//BaseController for Single Browser Execution at a time
public class BaseController {
	
	 public String URL, Node;
	 protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	
	@Test
	public List<Object> initializeApplication(String moduleName,String testCaseName,DataBaseUtilities DBUtilities,CommonUtilities CUtilities,String browserName)
	{    
		 List<Object> list = new ArrayList<Object>();
		 Properties p=null;
		 WebDriver driver=null;
		 ArrayList moduleRecord=null;
		 Map map=null;
		 //String browserName=null;
		 
		  try{
			  
			 
			  p=CUtilities.getProperty();
			  
			  //Getting data connection from oracle database
			 // DBUtilities.DatabaseConnection();
			  
			  //Getting data from oracle database
			//  moduleRecord = DBUtilities.setDBRecord(moduleName);
			  
			  //getting data connection from the excel file
			 // DBUtilities.excelDatabaseConnection();
			  
			  //getting data from the excel file
			  moduleRecord=DBUtilities.excelSetDBRecord(moduleName);
			  
			  for(int i=0;i<moduleRecord.size();i++)
				{
					map=(Map)moduleRecord.get(i);

			        System.out.println("Tabledata:"+map);
					if(map.get("TEST_METHOD_NAME").toString().equalsIgnoreCase(testCaseName)){
						
						browserName=map.get("BROWSER_NAME").toString();

					}
					else
						continue;
				}
			  
			  /*Getting DataBase TestData on the Console */
			  //System.out.println("DataBase Contains following number of Records:"+moduleRecord.size());
			  //System.out.println("DataBase Contains the following Data:"+moduleRecord);
			  
			  list.add(moduleRecord);
			  list.add(p);
			  
			
			  if(browserName.equalsIgnoreCase("Firefox"))
		      { 
				  driver = new FirefoxDriver(); //--FirefoxDriver  
				  list.add(driver);
		      }
			  
			  if(browserName.equalsIgnoreCase("Safari"))
		      { 
				  driver = new SafariDriver(); //--SafariDriver
				  list.add(driver);
		      }
			  
			  if(browserName.equalsIgnoreCase("InternetExplorer"))
			  { 
				 File file = new File("C:\\IEDriverServer.exe"); //--IEDriver
				 System.setProperty("webdriver.ie.driver", file.getAbsolutePath() );  //--IEDriver
					 
			     driver =new InternetExplorerDriver(); //--IEDriver
				  
			     list.add(driver);
			  }
			  
			  if(browserName.equalsIgnoreCase("Opera"))
			  { 
				  driver = new OperaDriver(); //--OperaDriver
				  list.add(driver);
			  }
		      
			  if(browserName.equalsIgnoreCase("Chrome"))
			  { 
		        File file = new File("C:\\chromedriver.exe"); //--ChromeDriver
		        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()); //--ChromeDriver
			   
		        driver =new ChromeDriver();   //--ChromeDriver
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
