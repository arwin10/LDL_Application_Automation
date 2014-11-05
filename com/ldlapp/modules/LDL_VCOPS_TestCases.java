package com.ldlapp.modules;

//External Packages importing

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

//Internal packages importing
import com.ldlapp.DataBaseUtility.DataBaseUtilities;
import com.ldlapp.basecontroller.BaseController;
import com.ldlapp.basecontroller.BaseControllerParallelExecution;
import com.ldlapp.commonutilities.CommonUtilities;

public class LDL_VCOPS_TestCases {
	WebDriver driver;
	int success_flag=1;
	Properties p=null;
	List<Object> moduleRecord = new ArrayList<Object>();
	ArrayList dbmoduleRecord=null;
	Map map=null;
	Dimension windowMinSize = new Dimension(300,300);
	DataBaseUtilities DBUtilities = new DataBaseUtilities();
	CommonUtilities CUtilities = new CommonUtilities();
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	String execDate,execTime;
	String workingdirectory;
	String parentWindow;
	Set<String> allWindows;
	
	@Parameters("browserName") 
	@BeforeTest
	public void setUp(String browserName){
		
	    System.out.println("Checking Browser... Name="+browserName);

	    workingdirectory = System.getProperty("user.dir");
	    System.out.println("Working Directory="+workingdirectory);
	    
	    /*BaseController for Multiple Parallel Browser Execution*/
		BaseControllerParallelExecution BController = new BaseControllerParallelExecution();
    	moduleRecord=BController.initializeApplication("VCOPS_Module","firstActions",DBUtilities,CUtilities,browserName);
		
		/*BaseController for Single Browser Execution at a time*/
		//BaseController BController = new BaseController();
		//moduleRecord=BController.initializeApplication("Requestor_Module","firstActions",DBUtilities,CUtilities,browserName);
	    
		dbmoduleRecord=(ArrayList)moduleRecord.get(0);
	    p=(Properties)moduleRecord.get(1);
	    driver=(WebDriver)moduleRecord.get(2);
	  
	}
	
	
	@AfterTest
	public void tearDown(){
	if (driver != null) {
		      driver.quit();
	 }
    
	 if(success_flag==1)
	 System.out.println("Script Executed Successfully.");
	 else
	 System.out.println("Script Execution failed.");
	}
	
	
	@Test
	public void testCaseExecution() throws Exception{
		
		System.out.println("--Inside testCaseExecution function--");
		//LDLfirstAction();
	    //LDLsearchRequestverification("LDL_VCOPS_searchRequestverification");
	     LDLHomePageVerification("LDL_VCOPS_HomePageVerification"); /*Issue with Tab scrolling Because of this Testcase failing. And No data in Action Items Page to verify*/	
		//LDLActionItemsVerification("LDL_VCOPS_ActionItemsVerification");
		//LDLActionItemsVerification("LDL_VCOPS_ActionItems_CancelRequest_Verification"); /**LAS-VCOPS can't cancel a request. **/
		//LDLActionItemsVerification("LDL_VCOPS_ActionItems_SubmitToEMS_Verification"); /**LAS-VCOPS can't Submit to EMS a request. **/
		//LDLActionItemsVerification("LDL_VCOPS_ActionItems_ReturnRequest_Verification");
		//LDLActionItemsVerification("LDL_VCOPS_ActionItems_AssignRequest_Verification");
		//LDLActionItemsVerification("LDL_VCOPS_ActionItems_SetupComplete_Verification");
		//LDLActionItemsVerification("LDL_VCOPS_ActionItems_CompleteRequest_Verification"); /*--Setup Complete Data is taking a lot of time to reflect in the table becuase of which testcase failing.--*/
	}
	 
	public void LDLfirstAction() throws Exception{
		// We will put LDL sample selenium examples in here
			try
			{
				  map=CUtilities.userLogin(dbmoduleRecord,"createNewCourseandOfferingsILT",driver);	
				  if(map!=null)
				  {   
					  Thread.sleep(5000);
					  System.out.println("LDLfirstAction testcase Successful.");
					  CUtilities.logout(driver);
					  success_flag=1;
				  }
				  else
				  {
					  System.out.println("LDLfirstAction testcase failed.");
					  success_flag=0;
				  }
				 
			}
			
			catch(Exception e)
			{
				 success_flag=0;
				 System.out.println("Exception occured:"+e);
				 e.printStackTrace();
			}
	}
    
	
	public void LDLHomePageVerification(String testCaseName) throws Exception{
		
		try
		{
			  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
			  if(map!=null)
			  {   
				  execDate= sdf1.format(cal.getTime()).toString();
				  execTime= sdf.format(cal.getTime()).toString();
				  Thread.sleep(5000);
				  
				  //Progress DashBoard Verification
				  if(driver.findElements(By.xpath(p.getProperty("requestImmAttLink"))).size()>0)
				  {
					  CUtilities.clickLink(p.getProperty("requestImmAttLink"), driver);
				      Thread.sleep(5000);
				      CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
		  
				  }
				  else
				  {    success_flag=0;
					  System.out.println("Error Occured:Request requiring immediate action link is not present.");
				  }
				  
				  if(driver.findElements(By.xpath(p.getProperty("requestPendingCompletionLink"))).size()>0)
				  {
					  CUtilities.clickLink(p.getProperty("requestPendingCompletionLink"), driver);
				      Thread.sleep(5000);
				      CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					 
				  }
				  else
				  {    success_flag=0;
					  System.out.println("Error Occured:Request in-progress requiring pending completion link is not present.");
				  }
				  
				  if(driver.findElements(By.xpath(p.getProperty("requestPendingCompletionDeliveryLink"))).size()>0)
				  {
					  CUtilities.clickLink(p.getProperty("requestPendingCompletionDeliveryLink"), driver);
				      Thread.sleep(5000);
				      CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					 
				  }
				  else
				  {    success_flag=0;
					  System.out.println("Error Occured:Request in-progress requiring pending completion delivery link is not present.");
				  }
				  
				  if(driver.findElement(By.xpath(p.getProperty("requestDraftPendingSubmissionLink"))).isDisplayed())
				  {
					  CUtilities.clickLink(p.getProperty("requestDraftPendingSubmissionLink"), driver);
				      Thread.sleep(5000);
				      CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					 
				  }
				  else
				  {    success_flag=0;
					  System.out.println("Error Occured:Request in draft status requiring pending submission link is not present.");
				  }
                  
				  if(driver.findElements(By.xpath(p.getProperty("requestExpediteLink"))).size()>0)
				  {
					  CUtilities.clickLink(p.getProperty("requestExpediteLink"), driver);
				      Thread.sleep(5000);
				      CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					 
				  }
				  else
				  {    success_flag=0;
					  System.out.println("Error Occured:Request in Expedite status requiring pending completion link is not present.");
				  }
                  
				  
				  // My Request Tab Verification
				  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
				  {
				    CUtilities.clickElement(p.getProperty("requestHomePageTCLink"), driver);
				    Thread.sleep(3000);
				  
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"75", driver);
				    Thread.sleep(2000);
				    if(driver.findElements(By.xpath(p.getProperty("myRequestTabNextLink"))).size()>0)
			 	
				    { 	
				      CUtilities.clickLink(p.getProperty("myRequestTabNextLink"), driver);
				      Thread.sleep(2000);
				      CUtilities.clickLink(p.getProperty("myRequestTabPrevLink"), driver);
				      Thread.sleep(2000);
				      CUtilities.clickLink(p.getProperty("myRequestTabLastLink"), driver);
				      Thread.sleep(2000);
				      CUtilities.clickLink(p.getProperty("myRequestTabFirstLink"), driver);
				      Thread.sleep(2000);
				      CUtilities.clickLink(p.getProperty("myRequestSecondPageLink"), driver);
				      Thread.sleep(2000);
				     
				     CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"100", driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"125", driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"150", driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"200", driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"All", driver);
					    Thread.sleep(2000);
				     
				     CUtilities.fillText(p.getProperty("requestTableRequestIDTxtBox"),map.get("REQUEST_ID").toString() ,driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("requestTableRequestIDTxtBox"),driver);
				     Thread.sleep(2000);
				     CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestTypeDrpDwn"),map.get("REQUEST_TYPE").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestTypeDrpDwn"),"Select One", driver);
				     Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableDeliveryTypeDrpDwn"),map.get("DELIVERY_TYPE").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableDeliveryTypeDrpDwn"),"Select One", driver);
				     Thread.sleep(2000);
				                 
					 CUtilities.fillText(p.getProperty("requestTableRequestTitleTxtBox"),map.get("REQUEST_TITLE").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableRequestTitleTxtBox"),driver);
				     Thread.sleep(2000);
					 CUtilities.fillText(p.getProperty("requestTableCourseTitleTxtBox"),map.get("SEARCH_EXISTING__COURSE_TITLE").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableCourseTitleTxtBox"),driver);
				     Thread.sleep(2000);
					 CUtilities.fillText(p.getProperty("requestTableRequestorNameTxtBox"),map.get("REQUESTOR_NAME").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableRequestorNameTxtBox"),driver);
				     Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestStatusDrpDwn"),map.get("REQUEST_STATUS").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestStatusDrpDwn"),"Select One", driver);
					 Thread.sleep(2000);
					 
				     
				   	/* ((JavascriptExecutor)driver).executeScript("var tableElement = document.getElementsByTagName('table');"+"tableElement.scrollLeft = tableElement.scrollWidth;"+"alert(document.getElementsByTagName('table'));");
		                Thread.sleep(1000);
		                */
					 //CUtilities.locateElement(p.getProperty("requestTableCurrentAssigneeTxBox"), driver);
					 
					 //CUtilities.clickLink(p.getProperty("requestTableColorPropClick"), driver);
				     //Thread.sleep(2000);
					 //CUtilities.robotPressButtons();
					 
					 CUtilities.fillText(p.getProperty("requestTableCurrentAssigneeTxBox"),map.get("CURRRENT_ASSIGNEE").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableCurrentAssigneeTxBox"),driver);
				     Thread.sleep(2000);
				      
				     //CUtilities.robotPressButtons();
				     
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncOrgDrpDwn"),map.get("FUNCTIONAL_ORG").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncOrgDrpDwn"),"Select One", driver);
					 Thread.sleep(2000);
					 
					 //CUtilities.robotPressButtons();
					 
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncSubOrgDrpDwn"),map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncSubOrgDrpDwn"),"Select One", driver);
					 Thread.sleep(2000);
				    }
				    else
				    {    success_flag=0;
				    	System.out.println("Error Occured:Open Request Tab Next Link doent exist.");
				    }
				
				    
				    CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
				    Thread.sleep(2000);
				  }
				  else
				  {   success_flag=0;
					  System.out.println("Error Occured:My Request Tab not Present.");
				  }
				  
				  // My Action Items Tab Verification
				  if(driver.findElement(By.xpath(p.getProperty("actionItemsPageTCLink"))).isDisplayed())
				  {
				    CUtilities.clickElement(p.getProperty("actionItemsPageTCLink"), driver);
				    Thread.sleep(3000);
				  
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"75", driver);
				    Thread.sleep(2000);
				    if(driver.findElements(By.xpath(p.getProperty("myRequestTabNextLink"))).size()>0)
			 	
				    {	
				     CUtilities.clickLink(p.getProperty("myRequestTabNextLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clickLink(p.getProperty("myRequestTabPrevLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clickLink(p.getProperty("myRequestTabLastLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clickLink(p.getProperty("myRequestTabFirstLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clickLink(p.getProperty("myRequestSecondPageLink"), driver);
				     Thread.sleep(2000);
				    }
				    else
				    {    success_flag=0;
				    	System.out.println("Error Occured:Open Request Tab Next Link doent exist.");
				    }
				   CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"100", driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"125", driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"150", driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"200", driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"All", driver);
				    Thread.sleep(2000);
				    
				    CUtilities.fillText(p.getProperty("requestTableRequestIDTxtBox"),map.get("REQUEST_ID").toString() ,driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("requestTableRequestIDTxtBox"),driver);
				     Thread.sleep(2000);
				     CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestTypeDrpDwn"),map.get("REQUEST_TYPE").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestTypeDrpDwn"),"Select One", driver);
				     Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableDeliveryTypeDrpDwn"),map.get("DELIVERY_TYPE").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableDeliveryTypeDrpDwn"),"Select One", driver);
				     Thread.sleep(2000);
					 CUtilities.fillText(p.getProperty("requestTableRequestTitleTxtBox"),map.get("REQUEST_TITLE").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableRequestTitleTxtBox"),driver);
				     Thread.sleep(2000);
					 CUtilities.fillText(p.getProperty("requestTableCourseTitleTxtBox"),map.get("SEARCH_EXISTING__COURSE_TITLE").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableCourseTitleTxtBox"),driver);
				     Thread.sleep(2000);
					 CUtilities.fillText(p.getProperty("requestTableRequestorNameTxtBox"),map.get("REQUESTOR_NAME").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableRequestorNameTxtBox"),driver);
				     Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestStatusDrpDwn"),map.get("REQUEST_STATUS").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestStatusDrpDwn"),"Select One", driver);
					 Thread.sleep(2000);
					 CUtilities.fillText(p.getProperty("requestTableSendeNameTxtBox"),map.get("CURRRENT_ASSIGNEE").toString() ,driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("requestTableSendeNameTxtBox"),driver);
				     Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncOrgDrpDwn"),map.get("FUNCTIONAL_ORG").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncOrgDrpDwn"),"Select One", driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncSubOrgDrpDwn"),map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
					 Thread.sleep(2000);
					 CUtilities.selectFromDropDownbyText(p.getProperty("requestTableFuncSubOrgDrpDwn"),"Select One", driver);
					 Thread.sleep(2000);
				    
				    CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
				    Thread.sleep(2000);
				  }
				  else
				  {   success_flag=0;
					  System.out.println("Error Occured:My Action Items Tab not Present.");
				  }
				  
				  //Help & Support Link Verification
				  if(driver.findElements(By.xpath(p.getProperty("helpAndSupportPortlet"))).size()>0)
				  {
					  CUtilities.clickLink(p.getProperty("aboutLDLLink"), driver);
					  driver.manage().window().setSize(windowMinSize);
					  Thread.sleep(10000);
					  CUtilities.clickLink(p.getProperty("helpLink"), driver);
					  driver.manage().window().setSize(windowMinSize);
					  Thread.sleep(10000);
					  CUtilities.clickLink(p.getProperty("supportLink"), driver);
					  driver.manage().window().setSize(windowMinSize);
					  Thread.sleep(10000);
				  }
				  else
				  {   success_flag=0;
					  System.out.println("Error Occured:Help & Support Portlet doesnt exist.");
				  }
				  
				  CUtilities.logout(driver);
				
			  }
			  else
			  {
				  System.out.println(testCaseName+" testcase execution failed.");
				  success_flag=0;
			  }
			  
			  if(success_flag==1)
			  {    System.out.println(testCaseName+" testcase execution Successful.");
				  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
			  }
			  else
			  { DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "FAILED");
			    success_flag=0;
			    System.out.println(testCaseName+" testcase execution failed.");
			  }
			 
		}
		
		catch(Exception e)
		{
			 success_flag=0;
			 DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "FAILED");
			 System.out.println("Exception occured:"+e);
			 e.printStackTrace();
		}
	 }
	
	
	public void LDLsearchRequestverification(String testCaseName) throws Exception{
			
			try
			{
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(2000);
					  
					 if(driver.findElement(By.xpath(p.getProperty("searchrequesttabTCrole"))).isDisplayed())
					  { 
						 CUtilities.clickLink(p.getProperty("searchrequesttabTCrole"), driver);
					     Thread.sleep(5000);
	                     
					     if(driver.findElement(By.xpath(p.getProperty("searchRequestPage"))).isDisplayed())
					     {
					      CUtilities.fillText(p.getProperty("requestIdtextbox"), map.get("REQUEST_ID").toString(), driver);
					      Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
					      Thread.sleep(2000);
					  
					       //Retrieving Search table data
					      WebElement table_element = driver.findElement(By.id("paginated"));
				          List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));

				          System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
				          int row_num,col_num;
				          row_num=1;
				          for(WebElement trElement : tr_collection)
				          {
				            List<WebElement> td_collection=trElement.findElements(By.tagName("td"));
				            System.out.println("NUMBER OF COLUMNS="+td_collection.size());
				            col_num=1;
				            for(WebElement tdElement : td_collection)
				            {
				                System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
				                col_num++;
				            }
				            row_num++;
				          }
				          if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
				          CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
				          Thread.sleep(2000);
				          CUtilities.clearText(p.getProperty("requestIdtextbox"), driver);
				          Thread.sleep(2000);
				          
                       
				          CUtilities.fillText(p.getProperty("searchRequestPageKeywordTxtBox"), map.get("OTHER_KEYWORDS").toString(), driver);
				          Thread.sleep(2000);
				          CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(3000);
			                 if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
					      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageKeywordTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestOpenedFromDateTxtBox"), map.get("SEARCH_EXISTING_START_DATE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(5000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
					      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestOpenedFromDateTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestOpenedToDateTxtBox"), map.get("SEARCH_EXISTING_END_DATE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(5000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
					      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestOpenedToDateTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestSetupFromDateTxtBox"), map.get("SEARCH_EXISTING_START_DATE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(5000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
					      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestSetupFromDateTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestSetupToDateTxtBox"), map.get("SEARCH_EXISTING_END_DATE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(5000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestSetupToDateTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestTitleTxtBox"), map.get("REQUEST_TITLE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestTitleTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.selectFromDropDownbyText(p.getProperty("searchRequestPageRequestRequestTypedrpdwn"), map.get("REQUEST_TYPE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.selectFromDropDownbyIndex(p.getProperty("searchRequestPageRequestRequestTypedrpdwn"),0, driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestEMSCourseIDTxtBox"), map.get("SEARCH_EXISTING_COURSE_ID").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestEMSCourseIDTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestEMSOfferingIDTxtBox"), map.get("SEARCH_EXISTING_OFFERING_ID").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              //CUtilities.clearText(p.getProperty("searchRequestPageRequestEMSOfferingIDTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestRequestorNameTxtBox"), map.get("REQUESTOR_NAME").toString(), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestRequestorNameSearchImg"), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestRequestorNameSearchResult"), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestRequestorNameTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestInitiatorNameTxtBox"), map.get("INITIATOR_NAME").toString(), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestInitiatorNameSearchImg"), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestInitiatorNameSearchResult"), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestInitiatorNameTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.clickLink(p.getProperty("searchRequestPageRequestRequestStatus"), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.selectFromDropDownbyText(p.getProperty("searchRequestPageRequestFunctionalOrgDrpDwn"), map.get("FUNCTIONAL_ORG").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.selectFromDropDownbyIndex(p.getProperty("searchRequestPageRequestFunctionalOrgDrpDwn"),0, driver);
			              Thread.sleep(2000);
			              
			              CUtilities.selectFromDropDownbyText(p.getProperty("searchRequestPageRequestDeleiveryTypeDrpDwn"), map.get("DELIVERY_TYPE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.selectFromDropDownbyIndex(p.getProperty("searchRequestPageRequestDeleiveryTypeDrpDwn"),0, driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestRelationShipManagerTxtBox"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestRelationShipManagerSearchImg"), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestRelationShipManagerSearchResult"), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestRelationShipManagerTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestExpLASDateTxtBox"), map.get("EOL_DATE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestExpLASDateTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.selectFromDropDownbyText(p.getProperty("searchRequestPageRequestRoleDrpDwn"), map.get("LAS_ROLE").toString(), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.selectFromDropDownbyIndex(p.getProperty("searchRequestPageRequestRoleDrpDwn"),0, driver);
			              Thread.sleep(2000);
			              
			              CUtilities.fillText(p.getProperty("searchRequestPageRequestCurrentAssgnTxtBox"), map.get("CURRRENT_ASSIGNEE").toString(), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestCurrentAssgnSearchImg"), driver);
			              //CUtilities.clickLink(p.getProperty("searchRequestPageRequestCurrentAssgnSearchResult"), driver);
			              Thread.sleep(2000);
			              CUtilities.clickButton(p.getProperty("searchButtton"), driver);
			              Thread.sleep(2000);
			              if(driver.findElements(By.xpath(p.getProperty("searchRequestPageMaximizecontent"))).size()>0)
						      CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);
			              Thread.sleep(2000);
			              CUtilities.clearText(p.getProperty("searchRequestPageRequestCurrentAssgnTxtBox"), driver);
			              Thread.sleep(2000);
			              
			              CUtilities.clickLink(p.getProperty("searchRequestPageRequestSelectPeopleLink"), driver);
						    Thread.sleep(2000);
						    String parentWindow= driver.getWindowHandle();
						    Set<String> allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("searhRequestPageSelectPeopleSearchButton"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("searhRequestPageSelectPeopleSearchResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("searhRequestPageSelectPeopleSelectAndCloseButton"), driver);
						    Thread.sleep(2000); 
						    driver.switchTo().window(parentWindow);	
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
						    
						    CUtilities.clickLink(p.getProperty("searchRequestPageExpanderLink"), driver);  
						    Thread.sleep(2000);  
			              
					      CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					      Thread.sleep(5000);
					  
					      CUtilities.logout(driver);
					      System.out.println("LDLsearchRequestverification testcase execution Successful.");
					     }
					     else
						 {
							 success_flag=0;
							 System.out.println("Error Occured:Search Request Page doesn't exist.");
						 }
					  }
					 else
					 {
						 success_flag=0;
						 System.out.println("Error Occured:Search Request Tab doesn't exist.");
					 }
					
				  }
				  else
				  {
					  System.out.println(testCaseName+" testcase execution failed.");
					  success_flag=0;
				  }
				  
				  if(success_flag==1)
				  {
					  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
					  System.out.println(testCaseName+" testcase execution successful.");
				  }
				  else
				  {
					  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "FAILED");
					  System.out.println(testCaseName+" testcase execution failed.");
				  }
				 
			}
			
			catch(Exception e)
			{
				 success_flag=0;
				 DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "FAILED");
				 System.out.println("Exception occured:"+e);
				 e.printStackTrace();
			}
		 }	
        

	public void LDLActionItemsVerification(String testCaseName) throws Exception{
		
		try
		{
			  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
			  if(map!=null)
			  {   
				  execDate= sdf1.format(cal.getTime()).toString();
				  execTime= sdf.format(cal.getTime()).toString();
				  Thread.sleep(2000);
				  
				 if(driver.findElement(By.xpath(p.getProperty("actionItemsPageTCLink"))).isDisplayed())
				  { 
					 CUtilities.clickLink(p.getProperty("actionItemsPageTCLink"), driver);
				     Thread.sleep(5000);
                     
				     if(driver.findElement(By.xpath(p.getProperty("actionItemsPage"))).isDisplayed())
				     {
				       CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"All", driver);
					   Thread.sleep(2000);
					   					   			  
					   
					   if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_CompleteRequest_Verification"))
					   { CUtilities.selectFromDropDownbyText(p.getProperty("requestTableRequestStatusDrpDwn"),map.get("REQUEST_STATUS").toString(), driver);
					     Thread.sleep(5000);
					     CUtilities.selectFromDropDownbyText(p.getProperty("TCPageRowsPerPageDrpDwn"),"50", driver);
						 Thread.sleep(60000);
					     //WebDriverWait wait = new WebDriverWait(driver,15);
					     //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("requestDetailsDataDivId")));
					   }
					   
					 				   
					  //Retrieving Search table data
					  WebElement table_element = driver.findElement(By.id("requestDetailsDataDivId"));
					  List<WebElement> tr_collection=table_element.findElements(By.tagName("tr"));
			          System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
			          int row_num,col_num,flag=0;
			          String request_ID = "ABCD1234";
			          WebElement reqLink=null;
			          row_num=1;
			          for(WebElement trElement : tr_collection)
			          { 
			        	  
			            List<WebElement> td_collection=trElement.findElements(By.tagName("td"));
			            System.out.println("NUMBER OF COLUMNS="+td_collection.size());
			            col_num=1;
			            for(WebElement tdElement : td_collection)
			            {   
			            	System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
			            	if(col_num==3)
			            	{
			            		
			            	    List<WebElement> links=tdElement.findElements(By.tagName("a"));
			            	    for(WebElement elemLinks : links)
					            { 
			            	    	reqLink=elemLinks;
					            }
			            		
			            	}
			               
			               if((testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItemsVerification")||testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_CancelRequest_Verification")||testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_SubmitToEMS_Verification")||testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_ReturnRequest_Verification"))||testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_AssignRequest_Verification"))
			               { if(tdElement.getText().equalsIgnoreCase("Assigned"))
			                 {   
			                	reqLink.click();
			                	Thread.sleep(2000);
			                	flag=1;
			                	
			                 }
			               }
			              
			               if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_SetupComplete_Verification"))
			               {if(tdElement.getText().equalsIgnoreCase("Submitted To EMS"))
			                {   
			                	reqLink.click();
			                	Thread.sleep(2000);
			                	flag=1;
			                	
			                }
			               }
			               
			               if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_CompleteRequest_Verification"))
			               {if(tdElement.getText().equalsIgnoreCase("Setup Complete"))
			                {   
			                	reqLink.click();
			                	Thread.sleep(2000);
			                	flag=1;
			                	
			                }
			               }
			               
			                if(flag==1)
				            {   
				            	
				            	break;
				            }
				            else
				            {  
				                col_num++;
				            	continue;
				            }
			               
			            }
			            if(flag==1)
			            {   
			            	
			            	break;
			            }
			            else
			            {  
			                row_num++;
			            	continue;
			            }
			            
			          }
			         if(flag==0)
			         {   success_flag=0;
			        	 System.out.println("Error Occured:In Action Items Page Required Status doesn't exist.");
			         }
			       
			         if(driver.findElements(By.xpath(p.getProperty("takeOwnerShipButton1"))).size()>0)
			         {   
			        	 System.out.println("TakeOwnerShip Button Exist.");
			        	  CUtilities.clickButton(p.getProperty("takeOwnerShipButton1"), driver);
					      Thread.sleep(2000);
					      CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						  Thread.sleep(2000);
						  CUtilities.clickButton(p.getProperty("takeOwnerShipButton1"), driver);
						  Thread.sleep(2000);
						  CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
					      Thread.sleep(2000);
					      CUtilities.clickButton(p.getProperty("takeOwnerShipButton2"), driver);
						  Thread.sleep(2000);
			         }
			         else if (testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_SubmitToEMS_Verification"))
			         {  
			        	 if(driver.findElements(By.xpath(p.getProperty("actionItemPageEditRequestButton"))).size()>0)		 
			        	 {   
			        		
			        		 CUtilities.clickButton(p.getProperty("actionItemPageEditRequestButton"), driver);
							 Thread.sleep(5000);
							 if(driver.findElement(By.xpath(p.getProperty("requestDetailsPage"))).isDisplayed())
							 {    
								  CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
								  Thread.sleep(3000);
								 /*Not Valid for LAS-VCOPS Role */
								  /* CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
								  Thread.sleep(3000);
								  CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
								  Thread.sleep(3000);
								  */
								  CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								  Thread.sleep(3000);
								  CUtilities.clickButton(p.getProperty("returnToRequestOverviewButton"), driver);
								  Thread.sleep(3000);
								  
							 }
							 else
							 {
								 success_flag=0;
								 System.out.println("Error Occured:Action Items Page the Request Details Page doesn't exist.");
							 }
			        		 CUtilities.clickButton(p.getProperty("actionItemPageSubmittoEMS"), driver);
							 Thread.sleep(5000);
							 CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
							 Thread.sleep(2000);
							 CUtilities.clickButton(p.getProperty("actionItemPageSubmittoEMS"), driver);
							 Thread.sleep(2000);
							 CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
						     Thread.sleep(2000);
						     CUtilities.clickButton(p.getProperty("actionItemPageSubmittoEMS2"), driver);
							 Thread.sleep(5000);
			        	 }
			        	 else
			        	 {
			        		 success_flag=0;
							 System.out.println("Error Occured:Action Items Page Edit Button doesn't exist.");
			        	 }
			        	 
			         }
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_CancelRequest_Verification"))
			         {  		        	 
						 CUtilities.clickButton(p.getProperty("actionItemPageCancelRequestButton"), driver);
						 Thread.sleep(5000);
						 CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("actionItemPageCancelRequestButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
					     Thread.sleep(2000);
					     CUtilities.clickButton(p.getProperty("actionItemPageSubmittoEMS2"), driver);
						 Thread.sleep(2000);
			        	 
			         }
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_ReturnRequest_Verification"))
			         {  
			        
						 CUtilities.clickButton(p.getProperty("actionItemPageReturnRequestButton"), driver);
						 Thread.sleep(5000);
						 CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("actionItemPageReturnRequestButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("actionItemPageReturnPopUpRequestorRdBtn"), driver);
						 Thread.sleep(2000);
						 CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
					     Thread.sleep(2000);
					     CUtilities.clickButton(p.getProperty("actionItemPageRequestPopUpReturnButton"), driver);
						 Thread.sleep(2000);
			        	 
			         }
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_AssignRequest_Verification"))
			         {  
						 CUtilities.clickButton(p.getProperty("actionItemPageAssignRequestButton"), driver);
						 Thread.sleep(5000);
						 CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("actionItemPageAssignRequestButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("actionItemPageAssignPopVCOpsRdBtn"), driver);
						 Thread.sleep(2000);
						 CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
					     Thread.sleep(2000);
					     CUtilities.clickButton(p.getProperty("actionItemPageRequestPopUpAssignButton"), driver);
						 Thread.sleep(2000);
			        	 
			         }
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_SetupComplete_Verification"))
			         {  
			        	 CUtilities.clickButton(p.getProperty("setUpCompleteButton"), driver);
						 Thread.sleep(5000);
						 CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("setUpCompleteButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
					     Thread.sleep(2000);
					     CUtilities.clickButton(p.getProperty("setUpCompleteButton2"), driver);
						 Thread.sleep(2000);
			         }
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_VCOPS_ActionItems_CompleteRequest_Verification"))
			         {
			        	 CUtilities.clickButton(p.getProperty("completeRequestButton"), driver);
						 Thread.sleep(5000);
						 CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("completeRequestButton"), driver);
						 Thread.sleep(2000);
						 CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
					     Thread.sleep(2000);
					     CUtilities.clickButton(p.getProperty("completeRequestButton2"), driver);
						 Thread.sleep(2000);
			         }
			         
			         
			         else
			         {  
			        	 if(driver.findElements(By.xpath(p.getProperty("actionItemscontinueButtonLink"))).size()>0)
			        	 { CUtilities.clickButton(p.getProperty("actionItemscontinueButtonLink"), driver);
					       Thread.sleep(5000);
			        	 }
			        	 else
			        	 {   success_flag=0;
			        		 System.out.println("Error occured:Continue Button doesn't exists.");
			        	 }
			         }
			         
			         
				      CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
				      Thread.sleep(5000);
				  
				      CUtilities.logout(driver);
				     
				     }
				     else
					 {
						 success_flag=0;
						 System.out.println("Error Occured:Action Items Page doesn't exist.");
					 }
				  }
				 else
				 {
					 success_flag=0;
					 System.out.println("Error Occured:Action Items Tab doesn't exist.");
				 }
				 
			  }
			  else
			  {
				  System.out.println(testCaseName+" testcase execution failed.");
				  success_flag=0;
			  }
			  
			  if(success_flag==1)
			  {
				  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
				  System.out.println(testCaseName +" testcase execution Successful.");
			  }
			  else
			  {
				  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "FAILED");
				  System.out.println(testCaseName+" testcase execution failed.");
			  }
			 
		}
		
		catch(Exception e)
		{
			 success_flag=0;
			 DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "FAILED");
			 System.out.println("Exception occured:"+e);
			 e.printStackTrace();
		}
	 }	
    
	
}	
