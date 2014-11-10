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

public class LDL_TRCOLEAD_TestCases {
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
    	moduleRecord=BController.initializeApplication("TRCOLEAD_Module","firstActions",DBUtilities,CUtilities,browserName);
		
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
	    //LDLsearchRequestverification("LDL_TRCOLEADsearchRequestverification");
		LDLHomePageVerification("LDL_TRCOLEAD_HomePageVerification"); /*Issue with Tab scrolling Because of this Testcase failing.*/
		//LDLCreateNewCourseAndOfferingsInstructorLedVerification("LDLTRCOLEAD_CreateNewCourseAndOfferingsInstructorLedVerification");
		//LDLCreateNewCourseAndOfferingsWBTVerification("LDL_TRCOLEADCreateNewCourseAndOfferingsWBTVerification");
		//LDLCreateNewCourseAndOfferingsVODVerification("LDL_TRCOLEADCreateNewCourseAndOfferingsVODVerification");
		//LDLCreateNewCourseAndOfferingsEPEVerification("LDL_TRCOLEAD_CreateNewCourseAndOfferingsEPEVerification");
		//LDLCreateNewCourseAndOfferingsEPOVerification("LDL_TRCOLEAD_CreateNewCourseAndOfferingsEP0Verification");
		//LDLCreateNewCourseAndOfferingsOJTVerification("LDL_TRCOLEAD_CreateNewCourseAndOfferingsOJTVerification");
		//LDLCreateNewCourseAndOfferingsINLVerification("LDL_TRCOLEAD_CreateNewCourseAndOfferingsINLVerification");
		//LDLCreateNewCourseAndOfferingsVCVerification("LDL_TRCOLEAD_CreateNewCourseAndOfferingsVCVerification");
		//LDLCreateNewOtherLASRequestVerification("LDL_TRCOLEAD_CreateNewOtherLASRequestVerification");
		//LDLUpdateExistingEMSCourseRequestVerification("LDL_TRCOLEAD_UpdateExistingEMSCourseRequestVerification");
		//LDLCancelExistingEMSOfferingRequestVerification("LDL_TRCOLEAD_CancelExistingEMSOfferingRequestVerification");
		//LDLcreateNewOfferingRequestVerification("LDL_TRCOLEAD_createNewOfferingRequestVerification");
	    //LDLUpdateExistingEMSOfferingRequestVerification("LDL_TRCOLEAD_UpdateExistingEMSOfferingRequestVerification");
		//LDLActionItemsVerification("LDL_TRCOLEADActionItemsVerification"); /*LAS TRCOLEAD Cant perform TakeOwnerShip */
		//LDLActionItemsVerification("LDL_TRCOLEADActionItems_CancelRequest_Verification"); /*LAS TRCOLEAD Cant cancel request */
		//LDLActionItemsVerification("LDL_TRCOLEADActionItems_SubmitToEMS_Verification"); /*LAS TRCOLEAD Cant SubmitToEMS request */
		//LDLActionItemsVerification("LDL_TRCOLEADActionItems_ReturnRequest_Verification"); /*LAS TRCOLEAD Cant Return request */
		//LDLActionItemsVerification("LDL_TRCOLEADActionItems_AssignRequest_Verification"); /*LAS TRCOLEAD Cant Assign request */
		//LDLActionItemsVerification("LDL_TRCOLEADActionItems_SetupComplete_Verification"); /*LAS TRCOLEAD Cant Setupcomplete request */
		//LDLActionItemsVerification("LDL_TRCOLEADActionItems_CompleteRequest_Verification"); /*LAS TRCOLEAD Cant complete request */
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
				  
				  if(driver.findElements(By.xpath(p.getProperty("requestDraftPendingSubmissionLink"))).size()>0)
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
        
	public void LDLCreateNewCourseAndOfferingsInstructorLedVerification(String testCaseName) throws Exception{
			
			try
			{
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
						 CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
						 Thread.sleep(3000);
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					  
					   {
					    CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
					    Thread.sleep(3000);
					    
					    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
					    Thread.sleep(2000);  
					    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
					    Thread.sleep(3000);
					    CUtilities.dialogclickOkButton(driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
					    Thread.sleep(2000);
					    parentWindow= driver.getWindowHandle();
					    allWindows = driver.getWindowHandles();
					    for(String curWindow : allWindows){
					        driver.switchTo().window(curWindow);
					    }
					   
					    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
					    Thread.sleep(2000);
					    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
					    Thread.sleep(6000);
					    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
					    Thread.sleep(2000); 
					    
					    driver.switchTo().window(parentWindow);	
					    
						driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
						
					    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
					    Thread.sleep(3000);
					    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
					    Thread.sleep(10000);
					    
					    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
                              							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(3000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("instructorLEDDeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("participantCompletionDrpdwn"), map.get("PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("sessionStartDateTime"), map.get("SESSION_START_DATE_TIME").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("sessionEndDateTime"), map.get("SESSION_END_DATE_TIME").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("locationTextBox"), map.get("OFFERING_LOCATION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("locationLookup"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("locationPicker"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("facilityTextBox"), map.get("OFFERING_FACILITY").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("facilityLookup"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("facilitypicker"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("roomReservationDetTextBox"), map.get("ROOM_RESERVATION_DETAILS").toString(), driver);
							Thread.sleep(2000);
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						   CUtilities.clickLink(p.getProperty("surveyDeleteLink"), driver);
							Thread.sleep(2000); 
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						    CUtilities.clickLink(p.getProperty("surveyEditLink1"), driver);
							Thread.sleep(2000);  
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						    CUtilities.fillText(p.getProperty("openEnrollmentDateTxtBox"), map.get("OPEN_ENROLLEMENT_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("closeEnrollmentDateTxtBox"), map.get("CLOSE_BEFORE_ENROLLEMENT_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("stopAutoPromotionDateTxtBox"), map.get("STOP_AUTO_PROMOTION_DATE").toString(), driver);
							Thread.sleep(2000);
							
							CUtilities.clickLink(p.getProperty("emsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("pricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
								 CUtilities.fillText(p.getProperty("breakOutRoomsTextBox"), map.get("BREAKOUT_ROOMS").toString(), driver);
							     Thread.sleep(2000);
							     CUtilities.fillText(p.getProperty("TCsupportRequestDayofClassTextBox"), map.get("TC_SUPPORT").toString(), driver);
							     Thread.sleep(2000);  
							     
							     CUtilities.clickLink(p.getProperty("TCOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									
									
								    CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								    CUtilities.clickLink(p.getProperty("contentDeleteButton"), driver);
									   Thread.sleep(2000); 
										
									   	
									   CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							          CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
							          Thread.sleep(2000); 
							          driver.switchTo().window(parentWindow);	 
							          driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									   
								   
								   
							     CUtilities.clickLink(p.getProperty("contentEditButton"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
						           CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						       

								    CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								   CUtilities.clickLink(p.getProperty("coltDeleteButton"), driver);
									Thread.sleep(2000); 
									
							       CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							       CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
							        Thread.sleep(2000); 
							       driver.switchTo().window(parentWindow);	 
							       driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
								   

								    CUtilities.clickLink(p.getProperty("coltEditButton"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								 
							      
							       CUtilities.fillText(p.getProperty("PONumberTextBox"), map.get("PO_NUMBER").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("materialLocationTextBox"), map.get("MATERIAL_LOCATION").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("cateringDetailsTextBox"), map.get("CATERINGS_DETAILS").toString(), driver);
							       Thread.sleep(2000);
							       
							       CUtilities.clickLink(p.getProperty("addMaterialsLink"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
	
						           CUtilities.clickLink(p.getProperty("addMaterialSearchButton"), driver);
						           Thread.sleep(2000); 
						           CUtilities.clickLink(p.getProperty("addMaterialDataOption1"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						           CUtilities.clickLink(p.getProperty("addMaterialsRemoveLink"), driver);
						           Thread.sleep(2000); 
						           
						           CUtilities.clickLink(p.getProperty("addMaterialsLink"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
	
						           CUtilities.clickLink(p.getProperty("addMaterialSearchButton"), driver);
						           Thread.sleep(2000); 
						           CUtilities.clickLink(p.getProperty("addMaterialDataOption1"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						           CUtilities.clickLink(p.getProperty("surveyPreviewLink"), driver);
								   Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									       
									        Thread.sleep(5000);
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						         
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           //Submit to LAS can be done by requestor only.
								  /* CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);*/
								   
	       
							
					    }
					    else
					    {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					    }
					    
					    
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					  }
					 }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  //CUtilities.dialogclickOkButton(driver);
					  // Thread.sleep(3000);
					  CUtilities.logout(driver);
					  
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
	 
	
	public void LDLCreateNewCourseAndOfferingsWBTVerification(String testCaseName) throws Exception{
			
			try
			{     
				String parentWindow;
			    Set<String> allWindows;
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					 
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
						 CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
						 Thread.sleep(3000); 
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					   {
						
						   CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
						    Thread.sleep(2000);  
						    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
						    Thread.sleep(3000);
						    CUtilities.dialogclickOkButton(driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
						    Thread.sleep(2000);
						    parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
						    Thread.sleep(2000);
						    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
						    Thread.sleep(6000);
						    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
						    Thread.sleep(2000); 
						    
						    driver.switchTo().window(parentWindow);	
						    
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							
						    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
						    
					        if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					        {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
                           							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("WBTDeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("WBTparticipantCompletionDrpdwn"), map.get("WBT_PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						   CUtilities.clickLink(p.getProperty("surveyDeleteLink"), driver);
							Thread.sleep(2000); 
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						    CUtilities.clickLink(p.getProperty("surveyEditLink1"), driver);
							Thread.sleep(2000);  
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						  
							CUtilities.clickLink(p.getProperty("WBTemsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("WBTpricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
														     
							     CUtilities.clickLink(p.getProperty("TCWBTOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									
									
								    CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								    CUtilities.clickLink(p.getProperty("contentDeleteButton"), driver);
									   Thread.sleep(2000); 
										
									   	
									   CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							          CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
							          Thread.sleep(2000); 
							          driver.switchTo().window(parentWindow);	 
							          driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									   
								   
								   
							     CUtilities.clickLink(p.getProperty("contentEditButton"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
						           CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						       

								    CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								   CUtilities.clickLink(p.getProperty("coltDeleteButton"), driver);
									Thread.sleep(2000); 
									
							       CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							       CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
							        Thread.sleep(2000); 
							       driver.switchTo().window(parentWindow);	 
							       driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
								   

								    CUtilities.clickLink(p.getProperty("coltEditButton"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
							      
							       CUtilities.fillText(p.getProperty("vendorSKUTextBox"), map.get("VENDOR_SKU").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("vendorProtocolTextBox"), map.get("VENDOR_PROTOCOL").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("AICCInternalHostedURLTextBox"), map.get("AICC_INTERNAL_HOSTED_URL").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("AICCExternalHostedURLTextBox"), map.get("AICC_EXTERNAL_HOSTED_URL").toString(), driver);
							       Thread.sleep(2000);
						           
						           CUtilities.clickLink(p.getProperty("WBTsurveyPreviewLink"), driver);
								   Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									       
									        Thread.sleep(5000);
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						         
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           //Submit to LAS can be done by requestor only.
								 /*  CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);*/
								   
	       
							
					    }
					    else
					    {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					    }
					    
					    
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					  }
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  //CUtilities.dialogclickOkButton(driver);
					  // Thread.sleep(3000);
					  CUtilities.logout(driver);
					 
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
	
	
	public void LDLCreateNewCourseAndOfferingsVODVerification(String testCaseName) throws Exception{
			
			try
			{     
				String parentWindow;
			    Set<String> allWindows;
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					 
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
						CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
						Thread.sleep(3000); 
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					   {
						
						   CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
						    Thread.sleep(2000);  
						    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
						    Thread.sleep(3000);
						    CUtilities.dialogclickOkButton(driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
						    Thread.sleep(2000);
						    parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
						    Thread.sleep(2000);
						    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
						    
						    /**Remote Host AutoITExecutor **/
						   // Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\remoteprocexecute.bat");
						    Thread.sleep(6000);
						    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
						    Thread.sleep(2000); 
						    
						    driver.switchTo().window(parentWindow);	
						    
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							
						    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
					    
					    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
                        							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("VODDeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("WBTparticipantCompletionDrpdwn"), map.get("WBT_PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						   CUtilities.clickLink(p.getProperty("surveyDeleteLink"), driver);
							Thread.sleep(2000); 
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						    CUtilities.clickLink(p.getProperty("surveyEditLink1"), driver);
							Thread.sleep(2000);  
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						  
							CUtilities.clickLink(p.getProperty("WBTemsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("WBTpricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
														     
							     CUtilities.clickLink(p.getProperty("TCWBTOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									
									
								    CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								    CUtilities.clickLink(p.getProperty("contentDeleteButton"), driver);
									   Thread.sleep(2000); 
										
									   	
									   CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							          CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
							          Thread.sleep(2000); 
							          driver.switchTo().window(parentWindow);	 
							          driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									   
								   
								   
							     CUtilities.clickLink(p.getProperty("contentEditButton"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
						           CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						       

								    CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								   CUtilities.clickLink(p.getProperty("coltDeleteButton"), driver);
									Thread.sleep(2000); 
									
							       CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							       CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
							        Thread.sleep(2000); 
							       driver.switchTo().window(parentWindow);	 
							       driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
								   

								    CUtilities.clickLink(p.getProperty("coltEditButton"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
							      
							       CUtilities.fillText(p.getProperty("vendorSKUTextBox"), map.get("VENDOR_SKU").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("vendorProtocolTextBox"), map.get("VENDOR_PROTOCOL").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("AICCInternalHostedURLTextBox"), map.get("AICC_INTERNAL_HOSTED_URL").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("AICCExternalHostedURLTextBox"), map.get("AICC_EXTERNAL_HOSTED_URL").toString(), driver);
							       Thread.sleep(2000);
						           
						           CUtilities.clickLink(p.getProperty("WBTsurveyPreviewLink"), driver);
								   Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									       
									        Thread.sleep(5000);
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						         
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           //Submit to LAS can be done by requestor only.
								   /*CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);*/
								   
	       
							
					    }
					    else
					    {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					    }
					    
					    
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					  }
					 }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  //CUtilities.dialogclickOkButton(driver);
					  // Thread.sleep(3000);
					  CUtilities.logout(driver);
					
				  }
				  else
				  {
					  System.out.println(testCaseName+ " testcase execution failed.");
					  success_flag=0;
				  }
				  
				  if(success_flag==1)
				  {
					  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
					  System.out.println(testCaseName + " testcase execution successful.");
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

	 
	public void LDLCreateNewCourseAndOfferingsEPEVerification(String testCaseName) throws Exception{
			
			try
			{     
				String parentWindow;
			    Set<String> allWindows;
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
						CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
						Thread.sleep(3000);  
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					   {
						
						   CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
						    Thread.sleep(2000);  
						    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
						    Thread.sleep(3000);
						    CUtilities.dialogclickOkButton(driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
						    Thread.sleep(2000);
						    parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
						    Thread.sleep(2000);
						    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
						    
						    /**Remote Host AutoITExecutor **/
						   // Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\remoteprocexecute.bat");
						    Thread.sleep(6000);
						    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
						    Thread.sleep(2000); 
						    
						    driver.switchTo().window(parentWindow);	
						    
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							
						    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
					    
					       if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					       {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
                     							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("EPEDeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("EPEparticipantCompletionDrpdwn"), map.get("EPE_PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							
							
							
						  
							CUtilities.clickLink(p.getProperty("WBTemsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("WBTpricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
														     
							     CUtilities.clickLink(p.getProperty("TCEPEOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
															   							      
							     
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(10000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           //Submit to LAS can be done by requestor only.
								 /*  CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);*/
								   
	       
							
					    }
					    else
					    {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					    }
					    
					    
					  }
					   else
					   {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					   }
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  //CUtilities.dialogclickOkButton(driver);
					  // Thread.sleep(3000);
					  CUtilities.logout(driver);
					
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
	 
	
	public void LDLCreateNewCourseAndOfferingsEPOVerification(String testCaseName) throws Exception{
			
			try
			{     
				String parentWindow;
			    Set<String> allWindows;
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
						CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
						Thread.sleep(3000);   
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					   {
						
						   CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
						    Thread.sleep(2000);  
						    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
						    Thread.sleep(3000);
						    CUtilities.dialogclickOkButton(driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
						    Thread.sleep(2000);
						    parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
						    Thread.sleep(2000);
						    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
						    
						    /**Remote Host AutoITExecutor **/
						   // Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\remoteprocexecute.bat");
						    Thread.sleep(6000);
						    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
						    Thread.sleep(2000); 
						    
						    driver.switchTo().window(parentWindow);	
						    
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							
						    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
					    
					    
					    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
                  							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("EPODeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("EPEparticipantCompletionDrpdwn"), map.get("EPE_PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							
							
							
						  
							CUtilities.clickLink(p.getProperty("WBTemsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("WBTpricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
														     
							     CUtilities.clickLink(p.getProperty("TCEPEOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
															   							      
							     
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(10000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						         
						           //Requestor can only submit to LAS as required. 
								/*   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);
								   */
	       
							
					    }
					     else
					     {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					     }
					    
					    
					    }
					   else
					   {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					   }
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  //CUtilities.dialogclickOkButton(driver);
					  // Thread.sleep(3000);
					  CUtilities.logout(driver);
					 
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
	 
	
	public void LDLCreateNewCourseAndOfferingsOJTVerification(String testCaseName) throws Exception{
			
			try
			{     
				String parentWindow;
			    Set<String> allWindows;
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
						CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
						Thread.sleep(3000);   
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					   {
						
						   CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
						    Thread.sleep(2000);  
						    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
						    Thread.sleep(3000);
						    CUtilities.dialogclickOkButton(driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
						    Thread.sleep(2000);
						    parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
						    Thread.sleep(2000);
						    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
						    
						    /**Remote Host AutoITExecutor **/
						   // Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\remoteprocexecute.bat");
						    Thread.sleep(6000);
						    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
						    Thread.sleep(2000); 
						    
						    driver.switchTo().window(parentWindow);	
						    
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							
						    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
					    
					    
					    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
               							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("OJTDeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("EPEparticipantCompletionDrpdwn"), map.get("EPE_PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							
							
							
						  
							CUtilities.clickLink(p.getProperty("WBTemsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("WBTpricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
														     
							     CUtilities.clickLink(p.getProperty("TCEPEOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
															   							      
							     
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(10000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						         
						           //Requestor can only submit to LAS as required. 
								/*   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);
								   */
	       
							
					    }
					     else
					     {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					     }
					    
					    
					    }
					   else
					   {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					   }
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  //CUtilities.dialogclickOkButton(driver);
					  // Thread.sleep(3000);
					  CUtilities.logout(driver);
					 
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
	 
	
	public void LDLCreateNewCourseAndOfferingsINLVerification(String testCaseName) throws Exception{
			
			try
			{     
				String parentWindow;
			    Set<String> allWindows;
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
						CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
						Thread.sleep(3000);   
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					   {
						
						   CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
						    Thread.sleep(2000);  
						    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
						    Thread.sleep(3000);
						    CUtilities.dialogclickOkButton(driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
						    Thread.sleep(2000);
						    parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
						    Thread.sleep(2000);
						    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
						    
						    /**Remote Host AutoITExecutor **/
						   // Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\remoteprocexecute.bat");
						    Thread.sleep(6000);
						    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
						    Thread.sleep(2000); 
						    
						    driver.switchTo().window(parentWindow);	
						    
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							
						    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
					    
					    
					    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
            							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("INLDeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("EPEparticipantCompletionDrpdwn"), map.get("EPE_PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							
							
							
						  
							CUtilities.clickLink(p.getProperty("WBTemsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("WBTpricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
														     
							     CUtilities.clickLink(p.getProperty("TCEPEOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
															   							      
							     
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(10000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						         
						           //Requestor can only submit to LAS as required. 
								/*   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);
								   */
	       
							
					    }
					     else
					     {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					     }
					    
					    
					    }
					   else
					   {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					   }
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  //CUtilities.dialogclickOkButton(driver);
					  // Thread.sleep(3000);
					  CUtilities.logout(driver);
					 
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
	 
	 
	public void LDLCreateNewCourseAndOfferingsVCVerification(String testCaseName) throws Exception{
			
			try
			{
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  
					  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					  { 
					   CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
					   Thread.sleep(3000);   
					   if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					   {

						   CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("createNewCourseAndOfferingsLink"), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
						    Thread.sleep(2000);  
						    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
						    Thread.sleep(3000);
						    CUtilities.dialogclickOkButton(driver);
						    Thread.sleep(3000);
						    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
						    Thread.sleep(2000);
						    parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
						   
						    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
						    Thread.sleep(10000);
						    
						   
						    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
						    
						    /**Remote Host AutoITExecutor **/
						   // Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\remoteprocexecute.bat");
						   // String selectAll = Keys.chord(Keys.CONTROL,Keys.ALT,"G");
						   // driver.findElement(By.tagName("html")).sendKeys(selectAll);
						   // CUtilities.robotPressButtons();
						    
						  //  Actions builder =new Actions(driver);
						   // builder.sendKeys(Keys.chord(Keys.CONTROL,Keys.ALT,"G")).perform();
						    
						    Thread.sleep(6000);
						    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
						    Thread.sleep(2000);
						    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
						    Thread.sleep(2000); 
						    
						    driver.switchTo().window(parentWindow);	
						    
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							
						    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
					    
					    
					    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
                           							
							
						    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
						    Thread.sleep(3000);
						    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
						    Thread.sleep(10000);
							
							
					    }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
					    
					    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("VCDeliveryTypeLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("participantCompletionDrpdwn"), map.get("PARTICIPATION_COMPLETION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("sessionStartDateTime"), map.get("SESSION_START_DATE_TIME").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("sessionEndDateTime"), map.get("SESSION_END_DATE_TIME").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("locationTextBox"), map.get("OFFERING_LOCATION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("locationLookup"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("locationPicker"), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("facilityTextBox"), map.get("OFFERING_FACILITY").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("facilityLookup"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("facilitypicker"), driver);
							Thread.sleep(2000);
							
							
							CUtilities.clickRadioButton(p.getProperty("webexProducerRequiredYesRadioButton"), driver);
							Thread.sleep(2000);
							CUtilities.selectFromDropDownbyText(p.getProperty("webExSessionInformationDrpDwn"), map.get("WEBEX_SESSION_INFORMATION").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("webexPlatformDrpDwn"), map.get("WEBEX_PLATFORM").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("WebExURLAttendeeLinkTextBox"), map.get("WEBEX_URL").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("WebExPasscodeTextBox"), map.get("WEBEX_PASSCODE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("WebexOptionTextBox"), map.get("WEBEX_OPTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("WebexSessionIDTextBox"), map.get("WEBEX_SESSION_ID").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("WebexhostKeyTextBox"), map.get("WEBEX_HOST_KEY").toString(), driver);
							Thread.sleep(2000);
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						   CUtilities.clickLink(p.getProperty("surveyDeleteLink"), driver);
							Thread.sleep(2000); 
							
							CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
							Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						    CUtilities.clickLink(p.getProperty("surveyEditLink1"), driver);
							Thread.sleep(2000);  
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    
						    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						    
						    CUtilities.fillText(p.getProperty("openEnrollmentDateTxtBox"), map.get("OPEN_ENROLLEMENT_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("closeEnrollmentDateTxtBox"), map.get("CLOSE_BEFORE_ENROLLEMENT_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("stopAutoPromotionDateTxtBox"), map.get("STOP_AUTO_PROMOTION_DATE").toString(), driver);
							Thread.sleep(2000);
							
							CUtilities.clickLink(p.getProperty("emsCredittoDeptPicker"), driver);
							Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
							    Thread.sleep(2000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
							    Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							    CUtilities.fillText(p.getProperty("pricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
								Thread.sleep(2000);
								
								  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
								 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
								 Thread.sleep(2000);
								 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
								 Thread.sleep(2000);
							     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
								 Thread.sleep(2000); 
								 driver.switchTo().window(parentWindow);	 
								 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								 
								  
							     
							     CUtilities.clickLink(p.getProperty("TCVCOfferingAttachmentLinkId"), driver);
								 Thread.sleep(2000);
								    parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								   
								    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
								    Thread.sleep(2000);
								    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
								    Thread.sleep(6000);
								    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
									Thread.sleep(3000);
								    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
								    Thread.sleep(2000);
								    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
								    Thread.sleep(2000); 
								    
								    driver.switchTo().window(parentWindow);	
								    
									driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									
									
								    CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								    CUtilities.clickLink(p.getProperty("contentDeleteButton"), driver);
									   Thread.sleep(2000); 
										
									   	
									   CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							          CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
							          Thread.sleep(2000);
							          CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
							          Thread.sleep(2000); 
							          driver.switchTo().window(parentWindow);	 
							          driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
									   
								   
								   
							     CUtilities.clickLink(p.getProperty("contentEditButton"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
						           CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
						           Thread.sleep(2000);
						           CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						       

								    CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								   CUtilities.clickLink(p.getProperty("coltDeleteButton"), driver);
									Thread.sleep(2000); 
									
							       CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							       CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
							        Thread.sleep(2000); 
							       driver.switchTo().window(parentWindow);	 
							       driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
								   

								    CUtilities.clickLink(p.getProperty("coltEditButton"), driver);
											Thread.sleep(2000); 
											  parentWindow= driver.getWindowHandle();
											    allWindows = driver.getWindowHandles();
											    for(String curWindow : allWindows){
											        driver.switchTo().window(curWindow);
											    }
								   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
								   Thread.sleep(2000);
								   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
								   Thread.sleep(2000); 
								   driver.switchTo().window(parentWindow);	 
								   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
								 
							      
							       CUtilities.fillText(p.getProperty("PONumberTextBox"), map.get("PO_NUMBER").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("materialLocationTextBox"), map.get("MATERIAL_LOCATION").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.fillText(p.getProperty("cateringDetailsTextBox"), map.get("CATERINGS_DETAILS").toString(), driver);
							       Thread.sleep(2000);
							       
							       CUtilities.clickLink(p.getProperty("addMaterialsLink"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
	
						           CUtilities.clickLink(p.getProperty("addMaterialSearchButton"), driver);
						           Thread.sleep(2000); 
						           CUtilities.clickLink(p.getProperty("addMaterialDataOption1"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						           CUtilities.clickLink(p.getProperty("addMaterialsRemoveLink"), driver);
						           Thread.sleep(2000); 
						           
						           CUtilities.clickLink(p.getProperty("addMaterialsLink"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
	
						           CUtilities.clickLink(p.getProperty("addMaterialSearchButton"), driver);
						           Thread.sleep(2000); 
						           CUtilities.clickLink(p.getProperty("addMaterialDataOption1"), driver);
						           Thread.sleep(2000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           
						           CUtilities.clickLink(p.getProperty("VCSurveryPreviewLink"), driver);
								   Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									       
									        Thread.sleep(5000);
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000); 
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						         
						           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							     
							       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
								   Thread.sleep(3000);
								   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
								   Thread.sleep(10000);
								   
								   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
								   Thread.sleep(3000);
								   
								   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
								   Thread.sleep(3000);
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
									    Thread.sleep(5000);   
						           driver.switchTo().window(parentWindow);	 
						           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						           
						           //Requestor can only submit to LAS as required. 
								   /*CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
								   Thread.sleep(2000);
								   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
							       Thread.sleep(2000);
							       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
								   Thread.sleep(2000);*/
								   
	       
							
					    }
					    else
					    {
					    	 success_flag=0;
							 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
					    }
					    
					    
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					  }
					 }
					 else
					  {
					     success_flag=0;
					     System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
						 
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(3000);
					  CUtilities.logout(driver);
					  
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
	
	 
	
	public void LDLCreateNewOtherLASRequestVerification(String testCaseName) throws Exception{
			
			try
			{
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  
					if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					 { 
					   CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
					   Thread.sleep(3000);   
					  
					  if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					  {
						  
					    CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("createNewOtherLASRequestLink"), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
					    Thread.sleep(2000);
					    
					    CUtilities.selectFromDropDownbyText(p.getProperty("requestSubTypeDrpDwn"), map.get("REQUEST_SUB_TYPE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("requestTitleTextBox"), map.get("REQUEST_TITLE").toString(), driver);
					    Thread.sleep(3000);
					    
					    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
					    Thread.sleep(2000); 
					    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
					    Thread.sleep(3000);
					    CUtilities.dialogclickOkButton(driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
					    Thread.sleep(2000);
					    String parentWindow= driver.getWindowHandle();
					    Set<String> allWindows = driver.getWindowHandles();
					    for(String curWindow : allWindows){
					        driver.switchTo().window(curWindow);
					    }
					   
					    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
					    Thread.sleep(2000);
					    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
					    Thread.sleep(6000);
					    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
					    Thread.sleep(2000); 
					    
					    driver.switchTo().window(parentWindow);	
					    
						driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
						
					    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
					    Thread.sleep(3000);
					    
					    //Submit to LAS can be done by requestor only.
					   /* CUtilities.clickButton(p.getProperty("otherLASRequestSubmitToLASButton"), driver);
						Thread.sleep(2000);
						CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						Thread.sleep(2000);
						CUtilities.clickButton(p.getProperty("otherLASRequestSubmitToLASButton"), driver);
						Thread.sleep(2000);
						CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
					    Thread.sleep(2000);
					    CUtilities.clickButton(p.getProperty("otherLASRequestSubmitToLASButton2"), driver);
						Thread.sleep(2000);*/
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					  }
					 }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  }
					
					
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(5000);
					  CUtilities.dialogclickOkButton(driver);
					  Thread.sleep(2000);
					  CUtilities.logout(driver);
					 
				  }
				  else
				  {
					  System.out.println(testCaseName+" testcase execution failed.");
					  success_flag=0;
				  }
				  
				  if(success_flag==1)
				  {
					  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
					  System.out.println(testCaseName+" testcase execution Successful.");
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
	 
	
	
	public void LDLUpdateExistingEMSCourseRequestVerification(String testCaseName) throws Exception{
			
			try
			{
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					  
				    if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
				    { 
					  CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
					  Thread.sleep(3000);   
						  
					  if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					  {
					    CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("updateExistingEMSCourseLink"), driver);
					    Thread.sleep(3000);
					    
					    
					    if(driver.findElement(By.xpath(p.getProperty("updateExistingEMSCoursePage"))).isDisplayed())
					    {
					    	
					     CUtilities.fillText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), map.get("SEARCH_EXISTING_COURSE_ID").toString(), driver);
						 Thread.sleep(2000); 
						 CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					     Thread.sleep(2000);
					     CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), driver);
					     Thread.sleep(2000);
					     
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageDomainPickerImg"), driver);
							Thread.sleep(2000); 
							 String parentWindow= driver.getWindowHandle();
							    Set<String> allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						   
							CUtilities.clickButton(p.getProperty("searchDomainButton"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("searchDomainResult1"), driver);
							Thread.sleep(2000); 
							
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						 CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
						 Thread.sleep(3000);
						 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
						 Thread.sleep(2000);
						 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageDomainTextBox"), driver);
						 Thread.sleep(2000); 
						 
						 
						  CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageAudiencePickerImg"), driver);
						  Thread.sleep(2000); 
						  parentWindow= driver.getWindowHandle();
					        allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						   
							CUtilities.clickButton(p.getProperty("searchAudienceButton"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("searchAudienceResult1"), driver);
							Thread.sleep(2000); 
							
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						 CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
						 Thread.sleep(3000);
						 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
						 Thread.sleep(2000);
						 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageAudienceTextBox"), driver);
						 Thread.sleep(2000); 
						 
						
					    	
					     CUtilities.fillText(p.getProperty("searchExistingEMSCoursePageCourseTitle"), map.get("SEARCH_EXISTING__COURSE_TITLE").toString(), driver);
					     Thread.sleep(2000);
					     CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageSearchCourseButtonSearchResultCOT00185584"), driver);
					     Thread.sleep(2000);
					     CUtilities.clickLink(p.getProperty("updateExistingEMSCoursePageUpdateButton"), driver);
					     Thread.sleep(2000);
					    }
					    else
					    {
					    	success_flag=0;
							System.out.println("Error Occured:Search Existing EMS Course Page Section doesn't exist.");
					    }
					    
					 
					    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
					    Thread.sleep(2000);  
					    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
					    Thread.sleep(3000);
					    CUtilities.dialogclickOkButton(driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
					    Thread.sleep(2000);
					    parentWindow= driver.getWindowHandle();
					    allWindows = driver.getWindowHandles();
					    for(String curWindow : allWindows){
					        driver.switchTo().window(curWindow);
					    }
					   
					    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
					    Thread.sleep(2000);
					    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
					    
					    /**Remote Host AutoITExecutor **/
					   // Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\remoteprocexecute.bat");
					    Thread.sleep(6000);
					    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
					    Thread.sleep(2000); 
					    
					    driver.switchTo().window(parentWindow);	
					    
						driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
						
					    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
					    Thread.sleep(3000);
					    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
					    Thread.sleep(10000);
				    
					    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
					    {
					    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
							Thread.sleep(2000);
							
							
							CUtilities.fillText(p.getProperty("courseTitleTextbox"), map.get("COURSE_TITLE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("courseDomainTextBox"), map.get("COURSE_DOMAIN").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("courseDomainLookupImg"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("courseDomainPickerCell"), driver);
							Thread.sleep(2000); 
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("courseDescpTextBox"));
							WebElement element1 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_DESCRIPTION").toString()+"</h1>'", element1);
							driver.switchTo().parentFrame();
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("learnObjTextBox"));
							WebElement element2 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("LEARNING_OBJECTIVE").toString()+"</h1>'", element2);
							driver.switchTo().parentFrame();
							
							
							CUtilities.fillText(p.getProperty("avlStartDate"), map.get("AVL_START_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("EOLDate"), map.get("EOL_DATE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("contentOwnerTxtBox"), map.get("CONTENT_OWNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("supportContactTextBox"), map.get("SUPPORT_CONTACT").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioImageLink"), driver);
							Thread.sleep(2000); 
							CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent1"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioContent2"), driver);
							Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
							Thread.sleep(2000);
							
							
							CUtilities.clickLink(p.getProperty("updateCourseDetailsPageHindiLanguageLink"), driver);
							CUtilities.dialogclickOkButton(driver);
							
						    CUtilities.clickLink(p.getProperty("AddLanguageLink"), driver);
							Thread.sleep(2000);
							   parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							CUtilities.selectFromDropDownbyText(p.getProperty("selectLanguageDrpDown"), map.get("LANGUAGE").toString(), driver);
							Thread.sleep(3000);
							CUtilities.clickLink(p.getProperty("selectLanguaugeButton"), driver);
							Thread.sleep(2000);
						
							driver.switchTo().window(parentWindow);	
							driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							
							CUtilities.fillText(p.getProperty("basePriceLearnerTextBox"), map.get("BASEPRICE_LEARNER").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("durationTextBox"), map.get("DURATIONTEXTBOX").toString(), driver);
							Thread.sleep(2000);
							CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
							Thread.sleep(2000);
							
							//Code for entering text in Rich TextBox
							driver.switchTo().frame(p.getProperty("specialInstLearnerTextBox"));
							WebElement element3 = driver.findElement(By.cssSelector("body"));
							((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("SPECIAL_INST_LEARNER").toString()+"</h1>'", element3);
							driver.switchTo().parentFrame();
							
						     CUtilities.clickLink(p.getProperty("courseAttachmentLink"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
								CUtilities.selectFromDropDownbyText(p.getProperty("complianceConnectFlagDrpDwn"), map.get("COMPLIANCE_CONNECTFLAF").toString(), driver);
								Thread.sleep(3000);
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseOutLineTextBox"));
								WebElement element4 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_OUTLINE").toString()+"</h1>'", element4);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("additionalCourseInfoBox"));
								WebElement element5 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("ADDITONAL_COURSEINFO").toString()+"</h1>'", element5);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseMaterialTextBox"));
								WebElement element6 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_MATERIAL").toString()+"</h1>'", element6);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("recommendedAudTextBox"));
								WebElement element7 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("RECOMMENDED_AUDIENCE").toString()+"</h1>'", element7);
								driver.switchTo().parentFrame();
								
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    CUtilities.clickLink(p.getProperty("EMSPrerequisiteRemoveLink"), driver);
								Thread.sleep(2000); 
								
								
			
								CUtilities.clickLink(p.getProperty("addpreRequisiteRecommendedLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
							
							  //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSPrerequisiteTextBox"));
								WebElement element8 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREREQUISITE").toString()+"</h1>'", element8);
								driver.switchTo().parentFrame();
								
								//Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("nonEMSRecommendedPreWorkTextBox"));
								WebElement element9 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("NON_EMSPREWORK").toString()+"</h1>'", element9);
								driver.switchTo().parentFrame();
								

								CUtilities.clickLink(p.getProperty("AddRelatedEMSCourseLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.fillText(p.getProperty("selectCoursePageTitleTextBox1"), map.get("SELECT_COURSETITLE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("selectCoursesearchButton1"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("addRequiredCheckBox1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							    
							    //Code for entering text in Rich TextBox
								driver.switchTo().frame(p.getProperty("courseFAQTextBox"));
								WebElement element10 = driver.findElement(By.cssSelector("body"));
								((JavascriptExecutor)driver).executeScript("arguments[0].innerHTML = '<h1>"+map.get("COURSE_FAQ").toString()+"</h1>'", element10);
								driver.switchTo().parentFrame();
							    
								CUtilities.fillText(p.getProperty("vendorNameTextBox"), map.get("VENDOR_NAME").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("vendorNameLookupmg"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("vendorNamePickerCell"), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorContactTextBox"), map.get("VENDOR_CONTACT").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.fillText(p.getProperty("vendorPriceTextBox"), map.get("VENDOR_PRICE").toString(), driver);
								Thread.sleep(2000);
							
								CUtilities.clickLink(p.getProperty("instructor_NameImgSelectBox"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								CUtilities.selectFromDropDownbyText(p.getProperty("instructionsel_populationDrpDown"), "Internal", driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("instructor_search_button"), driver);
								Thread.sleep(2000); 
								CUtilities.clickLink(p.getProperty("instructor_search_result1"), driver);
								Thread.sleep(2000); 
								driver.switchTo().window(parentWindow);	 
							    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								CUtilities.fillText(p.getProperty("InstructorContactInfoTextBox"), map.get("INSTRUCTOR_CONTACT_INFO").toString(), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("primaryTechnologyLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnolologycontent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("primaryTechnologycontent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("learnerJobLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("learnerJobContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								
								CUtilities.clickLink(p.getProperty("MarketSegmentLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("marketSegmentContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("verticalIndustriesLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("verticalIndustriesContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("LearningPrgLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("LearningPrgContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoBusinnessSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoBussinessSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoNetworkSolContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
								CUtilities.clickLink(p.getProperty("ciscoProductLink"), driver);
								Thread.sleep(2000); 
								CUtilities.fillText(p.getProperty("searchTagsTextBox"), map.get("PORTFOLIO_SEARCHDATA").toString(), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfoliosearchResult"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("searchTagButton"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent1DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioContent2DelImg"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent1"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("ciscoProductContent2"), driver);
								Thread.sleep(2000);
								CUtilities.clickLink(p.getProperty("portfolioAddOkImg"), driver);
								Thread.sleep(2000);
								
						
								CUtilities.fillText(p.getProperty("otherKeywordTextBox"), map.get("OTHER_KEYWORDS").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("requiredREsourcesTextBox"), map.get("REQUIRED_RESOURCE").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("resourceBillingInoTextBox"), map.get("RESOURCE_BILLING").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("cateringBillingInfoTextBox"), map.get("CATERING_BILLING_INFO").toString(), driver);
								Thread.sleep(2000);
								CUtilities.selectFromDropDownbyText(p.getProperty("reportRequestedDrpDwn"), map.get("REPORT_REQUESTED").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("nonStandarNotesTextBox"), map.get("NON_STANDARDNOTES").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillText(p.getProperty("distributionPortalTextBox"), map.get("DISTRIBUTION_PORTAL").toString(), driver);
								Thread.sleep(2000);
								CUtilities.fillTextArea(p.getProperty("specialInstLASTextArea"), map.get("SPCL_INST_LAS").toString(), driver);
								Thread.sleep(2000);
							
							
							
							CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
							Thread.sleep(3000);
						
							//Requestor can only submit to LAS .
						/*	CUtilities.clickButton(p.getProperty("updateExistingEMSCoursePageSumittoLASButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
							Thread.sleep(2000);
							CUtilities.clickButton(p.getProperty("updateExistingEMSCoursePageSumittoLASButton"), driver);
						    Thread.sleep(2000);
							CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.clickButton(p.getProperty("updateExistingEMSCoursePageSumittoLASButton2"), driver);
							Thread.sleep(2000);*/
			            }
					    else
					    {
					       success_flag=0;
						   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
					    }
				
					    
					  }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					  }
				   }
				  else
				  {
					  success_flag=0;
					  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
				  }
				
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(5000);
					  CUtilities.dialogclickOkButton(driver);
					  Thread.sleep(2000);
					  CUtilities.logout(driver);
					 
				  }
				  else
				  {
					  System.out.println(testCaseName+" testcase execution failed.");
					  success_flag=0;
				  }
				  
				  if(success_flag==1)
				  {
					  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
					  System.out.println(testCaseName+" testcase execution Successful.");
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
	
	 
	public void LDLCancelExistingEMSOfferingRequestVerification(String testCaseName) throws Exception{
			
			try
			{
				  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
				  if(map!=null)
				  {   
					  execDate= sdf1.format(cal.getTime()).toString();
					  execTime= sdf.format(cal.getTime()).toString();
					  Thread.sleep(5000);
					if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
					{ 
					  CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
					  Thread.sleep(3000);    
					
					  if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
					  {
					    CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("cancelExistingEMSOfferingLink"), driver);
					    Thread.sleep(3000);
					    
					    
					    if(driver.findElement(By.xpath(p.getProperty("searchExistingEMSOfferingPage"))).isDisplayed())
					    {
					    	
					     CUtilities.fillText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), map.get("SEARCH_EXISTING_COURSE_ID").toString(), driver);
						 Thread.sleep(2000); 
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					     Thread.sleep(2000);
					     CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), driver);
					     Thread.sleep(2000);
					     
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageDomainPickerImg"), driver);
							Thread.sleep(2000); 
							 String parentWindow= driver.getWindowHandle();
							    Set<String> allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						   
							CUtilities.clickButton(p.getProperty("searchDomainButton"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("searchDomainResult1"), driver);
							Thread.sleep(2000); 
							
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
						 Thread.sleep(3000);
						 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
						 Thread.sleep(2000);
						 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageDomainTextBox"), driver);
						 Thread.sleep(2000); 
						 
						 
						  CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageAudiencePickerImg"), driver);
						  Thread.sleep(2000); 
						  parentWindow= driver.getWindowHandle();
					        allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						   
							CUtilities.clickButton(p.getProperty("searchAudienceButton"), driver);
							Thread.sleep(2000); 
							CUtilities.clickLink(p.getProperty("searchAudienceResult1"), driver);
							Thread.sleep(2000); 
							
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
						 Thread.sleep(3000);
						 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
						 Thread.sleep(2000);
						 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageAudienceTextBox"), driver);
						 Thread.sleep(2000); 
						 
						
						 CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingIDTextBox"), map.get("SEARCH_EXISTING_OFFERING_ID").toString(), driver);
						 Thread.sleep(2000); 
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					     Thread.sleep(2000);
					     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingIDTextBox"), driver);
					     Thread.sleep(2000);
						 
					     CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingStartDateTextBox"), map.get("SEARCH_EXISTING_START_DATE").toString(), driver);
						 Thread.sleep(2000); 
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					     Thread.sleep(2000);
					     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingStartDateTextBox"), driver);
					     Thread.sleep(2000);
						 
					     CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingEndDateTextBox"), map.get("SEARCH_EXISTING_END_DATE").toString(), driver);
						 Thread.sleep(2000); 
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					     Thread.sleep(2000);
					     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingEndDateTextBox"), driver);
					     Thread.sleep(2000);
					     
					     CUtilities.selectFromDropDownbyText(p.getProperty("searchExistingEMSOfferingPageDeleiveryTypeDrpDwn"), map.get("SEARCH_EXISTING_DELIVERY_TYPE").toString(), driver);
						 Thread.sleep(2000); 
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					     Thread.sleep(2000);
					     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingEndDateTextBox"), driver);
					     Thread.sleep(2000);
					     CUtilities.selectFromDropDownbyText(p.getProperty("searchExistingEMSOfferingPageDeleiveryTypeDrpDwn"),"-Select One-", driver);
						 Thread.sleep(2000); 
					     
					     CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageLanguageTexBox"), map.get("SEARCH_EXISTING_LANGUAGE").toString(), driver);
						 Thread.sleep(2000); 
						 CUtilities.clickLink(p.getProperty("searchExistingEMSOfferingPageLangPickerImg"), driver);
					     Thread.sleep(2000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSOfferingPageLangResultLink"), driver);
					     Thread.sleep(2000);
						 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					     Thread.sleep(2000);
					     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageLanguageTexBox"), driver);
					     Thread.sleep(2000);
				 	
					     CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingTitleTextBox"), map.get("SEARCH_EXISTING__COURSE_TITLE").toString(), driver);
					     Thread.sleep(2000);
					     CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					     Thread.sleep(3000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSOfferingPageSearchResultILT00341636"), driver);
					     Thread.sleep(2000);
					     CUtilities.clickLink(p.getProperty("searchExistingEMSOfferingPageSelectOfferingButton"), driver);
					     Thread.sleep(2000);
					     CUtilities.dialogclickOkButton(driver);
					    }
					    else
					    {
					    	success_flag=0;
							System.out.println("Error Occured:Search Existing EMS Offering Page Section doesn't exist.");
					    }
					    
					    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
					    Thread.sleep(2000);
					    
					    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
					    Thread.sleep(2000); 
					    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
					    Thread.sleep(3000);
					    CUtilities.dialogclickOkButton(driver);
					    Thread.sleep(3000);
					    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
					    Thread.sleep(2000);
					    String parentWindow= driver.getWindowHandle();
					    Set<String> allWindows = driver.getWindowHandles();
					    for(String curWindow : allWindows){
					        driver.switchTo().window(curWindow);
					    }
					   
					    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
					    Thread.sleep(2000);
					    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
					    Thread.sleep(6000);
					    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
					    Thread.sleep(2000);
					    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
					    Thread.sleep(2000); 
					    
					    driver.switchTo().window(parentWindow);	
					    
						driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
						
					    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
					    Thread.sleep(3000);
					    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
					    Thread.sleep(3000);
					  //Submit to LAS can be done by requestor only.
					  /*  CUtilities.clickButton(p.getProperty("updateExistingEMSCoursePageSumittoLASButton"), driver);
					    Thread.sleep(2000);
						CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
						Thread.sleep(2000);
						CUtilities.clickButton(p.getProperty("updateExistingEMSCoursePageSumittoLASButton"), driver);
						Thread.sleep(2000);
					    CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickButton(p.getProperty("updateExistingEMSCoursePageSumittoLASButton2"), driver);
					    Thread.sleep(2000);*/
	                 }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
					  }
					 }
					  else
					  {
						  success_flag=0;
						  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
					  } 
					  
					  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
					  Thread.sleep(5000);
					  CUtilities.dialogclickOkButton(driver);
					  Thread.sleep(2000);
					  CUtilities.logout(driver);
					
				  }
				  else
				  {   
					  success_flag=0;
					  System.out.println(testCaseName+" testcase execution failed.");
					 
				  }
				  
				  if(success_flag==1)
				  {
					  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
					  System.out.println(testCaseName+" testcase execution Successful.");
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
	
	
	public void LDLcreateNewOfferingRequestVerification(String testCaseName) throws Exception{
		
		try
		{
			  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
			  if(map!=null)
			  {   
				  execDate= sdf1.format(cal.getTime()).toString();
				  execTime= sdf.format(cal.getTime()).toString();
				  Thread.sleep(5000);
				  
				if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
				{ 
				  CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
				  Thread.sleep(3000);    
					
				  if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
				  {
				    CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("createNewOfferingLink"), driver);
				    Thread.sleep(3000);
				    
				    
				    if(driver.findElement(By.xpath(p.getProperty("searchExistingEMSCoursePage"))).isDisplayed())
				    {
				    	
				     CUtilities.fillText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), map.get("SEARCH_EXISTING_COURSE_ID").toString(), driver);
					 Thread.sleep(2000); 
					 CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), driver);
				     Thread.sleep(2000);
				     
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageDomainPickerImg"), driver);
						Thread.sleep(2000); 
						 String parentWindow= driver.getWindowHandle();
						    Set<String> allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					   
						CUtilities.clickButton(p.getProperty("searchDomainButton"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLink(p.getProperty("searchDomainResult1"), driver);
						Thread.sleep(2000); 
						
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					 CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
					 Thread.sleep(3000);
					 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageDomainTextBox"), driver);
					 Thread.sleep(2000); 
					 
					 
					  CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageAudiencePickerImg"), driver);
					  Thread.sleep(2000); 
					  parentWindow= driver.getWindowHandle();
				        allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					   
						CUtilities.clickButton(p.getProperty("searchAudienceButton"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLink(p.getProperty("searchAudienceResult1"), driver);
						Thread.sleep(2000); 
						
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					 CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
					 Thread.sleep(3000);
					 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageAudienceTextBox"), driver);
					 Thread.sleep(2000); 
					 
					
				    	
				     CUtilities.fillText(p.getProperty("searchExistingEMSCoursePageCourseTitle"), map.get("SEARCH_EXISTING__COURSE_TITLE").toString(), driver);
				     Thread.sleep(2000);
				     CUtilities.clickButton(p.getProperty("searchExistingEMSCoursePageSearchCourseButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageSearchCourseButtonSearchResultCOT00185584"), driver);
				     Thread.sleep(2000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageSelectButton"), driver);
				     Thread.sleep(2000);
				    }
				    else
				    {
				    	success_flag=0;
						System.out.println("Error Occured:Search Existing EMS Course Page Section doesn't exist.");
				    }
				    
				    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
				    Thread.sleep(2000);  
				    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
				    Thread.sleep(3000);
				    CUtilities.dialogclickOkButton(driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
				    Thread.sleep(2000);
				    parentWindow= driver.getWindowHandle();
				    allWindows = driver.getWindowHandles();
				    for(String curWindow : allWindows){
				        driver.switchTo().window(curWindow);
				    }
				   
				    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
				    Thread.sleep(2000);
				    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
				    Thread.sleep(6000);
				    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
				    Thread.sleep(2000); 
				    
				    driver.switchTo().window(parentWindow);	
				    
					driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
					
				    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
				    Thread.sleep(3000);
				    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
				    Thread.sleep(10000);
				    
				    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
				    {
				    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						
					    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
					    Thread.sleep(10000);
						
						
				    }
				    else
				    {
				       success_flag=0;
					   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
				    }
				    
				    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
				    {
				    	CUtilities.clickLink(p.getProperty("addOfferingsButton"), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("VCDeliveryTypeLink"), driver);
						Thread.sleep(2000);
						CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.selectFromDropDownbyText(p.getProperty("participantCompletionDrpdwn"), map.get("PARTICIPATION_COMPLETION").toString(), driver);
						Thread.sleep(2000);
						
						
						/*The below mentioned details must appear in the app through course details page but not so. Please check.. */
						CUtilities.fillText(p.getProperty("minClassSizeTextBox"), map.get("MINCLASSSIZE").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("maxClassSizeTextBox"), map.get("MAXCLASSSIZE").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("durationTextBox2"), map.get("DURATIONTEXTBOX").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("waitlistClassSizeTextBox"), map.get("WAITLIST_CLASSSIZE").toString(), driver);
						Thread.sleep(2000);
						
					
						CUtilities.fillText(p.getProperty("sessionStartDateTime"), map.get("SESSION_START_DATE_TIME").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("sessionEndDateTime"), map.get("SESSION_END_DATE_TIME").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("locationTextBox"), map.get("OFFERING_LOCATION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("locationLookup"), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("locationPicker"), driver);
						Thread.sleep(2000);
						
						//Defect in app Facility field not showing up.
						
						if(driver.findElements(By.xpath(p.getProperty("facilityTextBox"))).size()>0 && driver.findElement(By.xpath(p.getProperty("facilityTextBox"))).isDisplayed())
						{CUtilities.fillText(p.getProperty("facilityTextBox"), map.get("OFFERING_FACILITY").toString(), driver);
						 Thread.sleep(2000);
						 CUtilities.clickLink(p.getProperty("facilityLookup"), driver);
						 Thread.sleep(2000);
						 CUtilities.clickLink(p.getProperty("facilitypicker"), driver);
						 Thread.sleep(2000);
						}
						else
						{
						   success_flag=0;
						   System.out.println("Error Occured:Facility TextBox doesn't exist.");
						}
						
						if(driver.findElements(By.xpath(p.getProperty("webexProducerRequiredYesRadioButton"))).size()>0 && driver.findElement(By.xpath(p.getProperty("webexProducerRequiredYesRadioButton"))).isDisplayed())
						{
						 CUtilities.clickRadioButton(p.getProperty("webexProducerRequiredYesRadioButton"), driver);
						 Thread.sleep(2000);
						}
						else
						{
						   success_flag=0;
						   System.out.println("Error Occured:webexProducerRequiredYesRadioButton doesn't exist.");
						}
						
						if(driver.findElements(By.xpath(p.getProperty("webExSessionInformationDrpDwn"))).size()>0 && driver.findElement(By.xpath(p.getProperty("webExSessionInformationDrpDwn"))).isDisplayed())
						{
						 CUtilities.selectFromDropDownbyText(p.getProperty("webExSessionInformationDrpDwn"), map.get("WEBEX_SESSION_INFORMATION").toString(), driver);
					     Thread.sleep(2000);
						}
						else
						{
						   success_flag=0;
						   System.out.println("Error Occured:webExSessionInformationDrpDwn doesn't exist.");
						}
						
						if(driver.findElements(By.xpath(p.getProperty("webexPlatformDrpDwn"))).size()>0 && driver.findElement(By.xpath(p.getProperty("webexPlatformDrpDwn"))).isDisplayed())
						{	
					     CUtilities.selectFromDropDownbyText(p.getProperty("webexPlatformDrpDwn"), map.get("WEBEX_PLATFORM").toString(), driver);
					     Thread.sleep(2000);
						}
						else
						{
						  success_flag=0;
						  System.out.println("Error Occured:webexPlatformDrpDwn doesn't exist.");
						}
						
						if(driver.findElements(By.xpath(p.getProperty("WebExURLAttendeeLinkTextBox"))).size()>0 && driver.findElement(By.xpath(p.getProperty("WebExURLAttendeeLinkTextBox"))).isDisplayed())
					    { CUtilities.fillText(p.getProperty("WebExURLAttendeeLinkTextBox"), map.get("WEBEX_URL").toString(), driver);
						 Thread.sleep(2000);
					    }
						else
						{
							 success_flag=0;
							 System.out.println("Error Occured:WebExURLAttendeeLinkTextBox doesn't exist.");	
						}
						
						if(driver.findElements(By.xpath(p.getProperty("WebExPasscodeTextBox"))).size()>0 && driver.findElement(By.xpath(p.getProperty("WebExPasscodeTextBox"))).isDisplayed())
						{CUtilities.fillText(p.getProperty("WebExPasscodeTextBox"), map.get("WEBEX_PASSCODE").toString(), driver);
						 Thread.sleep(2000);
						}
						else
						{
						  success_flag=0;
						  System.out.println("Error Occured:WebExPasscodeTextBox doesn't exist.");	
						}
						
						if(driver.findElements(By.xpath(p.getProperty("WebexOptionTextBox"))).size()>0 && driver.findElement(By.xpath(p.getProperty("WebexOptionTextBox"))).isDisplayed())
						{CUtilities.fillText(p.getProperty("WebexOptionTextBox"), map.get("WEBEX_OPTION").toString(), driver);
						 Thread.sleep(2000);
						}
						else
						{
						 success_flag=0;
						 System.out.println("Error Occured:WebexOptionTextBox doesn't exist.");	
						}
						
						if(driver.findElements(By.xpath(p.getProperty("WebexSessionIDTextBox"))).size()>0 && driver.findElement(By.xpath(p.getProperty("WebexSessionIDTextBox"))).isDisplayed())
						{CUtilities.fillText(p.getProperty("WebexSessionIDTextBox"), map.get("WEBEX_SESSION_ID").toString(), driver);
					   	 Thread.sleep(2000);
						}
						else
						{
						  success_flag=0;
						  System.out.println("Error Occured:WebexSessionIDTextBox doesn't exist.");	
						}
						
						if(driver.findElements(By.xpath(p.getProperty("WebexhostKeyTextBox"))).size()>0 && driver.findElement(By.xpath(p.getProperty("WebexhostKeyTextBox"))).isDisplayed())
						{ CUtilities.fillText(p.getProperty("WebexhostKeyTextBox"), map.get("WEBEX_HOST_KEY").toString(), driver);
						 Thread.sleep(2000);
						}
						else
						{
						 success_flag=0;
						 System.out.println("Error Occured:WebexhostKeyTextBox doesn't exist.");	
						}
						
						CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
						Thread.sleep(2000); 
						  parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
					    Thread.sleep(2000);
					    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
						Thread.sleep(2000); 
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					    
					   CUtilities.clickLink(p.getProperty("surveyDeleteLink"), driver);
						Thread.sleep(2000); 
						
						CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
						Thread.sleep(2000); 
						  parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
					    Thread.sleep(2000);
					    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
						Thread.sleep(2000); 
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					    
					    CUtilities.clickLink(p.getProperty("surveyEditLink1"), driver);
						Thread.sleep(2000);  
						  parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					    
					    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
					    Thread.sleep(2000);
					    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
						Thread.sleep(2000); 
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					    
					    CUtilities.fillText(p.getProperty("openEnrollmentDateTxtBox"), map.get("OPEN_ENROLLEMENT_DATE").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("closeEnrollmentDateTxtBox"), map.get("CLOSE_BEFORE_ENROLLEMENT_DATE").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("stopAutoPromotionDateTxtBox"), map.get("STOP_AUTO_PROMOTION_DATE").toString(), driver);
						Thread.sleep(2000);
						
						CUtilities.clickLink(p.getProperty("emsCredittoDeptPicker"), driver);
						Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
						    Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						
						    CUtilities.fillText(p.getProperty("pricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
							Thread.sleep(2000);
							
							  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
							 Thread.sleep(2000);
							 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
							 Thread.sleep(2000);
						     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
							 Thread.sleep(2000); 
							 driver.switchTo().window(parentWindow);	 
							 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							 
							  
						     
						     CUtilities.clickLink(p.getProperty("TCVCOfferingAttachmentLinkId"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
							    CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							   CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
							   Thread.sleep(2000); 
							   driver.switchTo().window(parentWindow);	 
							   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							   
							    CUtilities.clickLink(p.getProperty("contentDeleteButton"), driver);
								   Thread.sleep(2000); 
									
								   	
								   CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
						          CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
						          Thread.sleep(2000);
						          CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
						          Thread.sleep(2000);
						          CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
						          Thread.sleep(2000);
						          CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
						          Thread.sleep(2000); 
						          driver.switchTo().window(parentWindow);	 
						          driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								   
							   
							   
						     CUtilities.clickLink(p.getProperty("contentEditButton"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
					           CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
					           Thread.sleep(2000);
					           CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
					           Thread.sleep(2000);
					           CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
					           Thread.sleep(2000);
					           CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
					           Thread.sleep(2000); 
					           driver.switchTo().window(parentWindow);	 
					           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					           
					           
					       

							    CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
							   Thread.sleep(2000); 
							   driver.switchTo().window(parentWindow);	 
							   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							   
							   CUtilities.clickLink(p.getProperty("coltDeleteButton"), driver);
								Thread.sleep(2000); 
								
						       CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
									Thread.sleep(2000); 
									  parentWindow= driver.getWindowHandle();
									    allWindows = driver.getWindowHandles();
									    for(String curWindow : allWindows){
									        driver.switchTo().window(curWindow);
									    }
						       CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
						        Thread.sleep(2000); 
						       driver.switchTo().window(parentWindow);	 
						       driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
							   

							    CUtilities.clickLink(p.getProperty("coltEditButton"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
							   Thread.sleep(2000); 
							   driver.switchTo().window(parentWindow);	 
							   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							   
							 
						      
						       CUtilities.fillText(p.getProperty("PONumberTextBox"), map.get("PO_NUMBER").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.fillText(p.getProperty("materialLocationTextBox"), map.get("MATERIAL_LOCATION").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.fillText(p.getProperty("cateringDetailsTextBox"), map.get("CATERINGS_DETAILS").toString(), driver);
						       Thread.sleep(2000);
						       
						       CUtilities.clickLink(p.getProperty("addMaterialsLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }

					           CUtilities.clickLink(p.getProperty("addMaterialSearchButton"), driver);
					           Thread.sleep(2000); 
					           CUtilities.clickLink(p.getProperty("addMaterialDataOption1"), driver);
					           Thread.sleep(2000); 
					           driver.switchTo().window(parentWindow);	 
					           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					           
					           
					           CUtilities.clickLink(p.getProperty("addMaterialsRemoveLink"), driver);
					           Thread.sleep(2000); 
					           
					           CUtilities.clickLink(p.getProperty("addMaterialsLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }

					           CUtilities.clickLink(p.getProperty("addMaterialSearchButton"), driver);
					           Thread.sleep(2000); 
					           CUtilities.clickLink(p.getProperty("addMaterialDataOption1"), driver);
					           Thread.sleep(2000); 
					           driver.switchTo().window(parentWindow);	 
					           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					           
					           
					           CUtilities.clickLink(p.getProperty("VCSurveryPreviewLink"), driver);
							   Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								       
								        Thread.sleep(5000);
								        driver.switchTo().window(curWindow);
								    }
								    Thread.sleep(5000); 
					           driver.switchTo().window(parentWindow);	 
					           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					         
					           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
						       Thread.sleep(2000);
						     
						       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
							   Thread.sleep(3000);
							   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
							   Thread.sleep(10000);
							   
							   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
							   Thread.sleep(3000);
							   
							   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
							   Thread.sleep(3000);
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								    Thread.sleep(5000);   
					           driver.switchTo().window(parentWindow);	 
					           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					         
					           //Submit to LAS can be done only by Requestor
					         
							 /*  CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
							   Thread.sleep(2000);
							   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
							   Thread.sleep(2000);
							   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
							   Thread.sleep(2000);
							   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
							   Thread.sleep(2000);*/
							   
       
						
				    }
				    else
				    {
				    	 success_flag=0;
						 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
				    }
				    
				    
				  }
				  else
				  {
					  success_flag=0;
					  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
				  }
				 }
				  else
				  {
					  success_flag=0;
					  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
				  } 
				  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
				  Thread.sleep(5000);
				  CUtilities.logout(driver);
				
			  }
			  else
			  {
				  System.out.println(testCaseName+" testcase execution failed.");
				  success_flag=0;
			  }
			  
			  if(success_flag==1)
			  {
				  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
				  System.out.println(testCaseName+" testcase execution Successful.");
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
    
	
	public void LDLUpdateExistingEMSOfferingRequestVerification(String testCaseName) throws Exception{
		
		try
		{
			  map=CUtilities.userLogin(dbmoduleRecord,testCaseName,driver);	
			  if(map!=null)
			  {   
				  execDate= sdf1.format(cal.getTime()).toString();
				  execTime= sdf.format(cal.getTime()).toString();
				  Thread.sleep(5000);
			  if(driver.findElement(By.xpath(p.getProperty("requestHomePageTCLink"))).isDisplayed())
				{ 
				  CUtilities.clickLink(p.getProperty("requestHomePageTCLink"), driver);
				  Thread.sleep(3000);    
					
				
				  if(driver.findElement(By.xpath(p.getProperty("createNewRequestLink"))).isDisplayed())
				  {
				    CUtilities.clickLink(p.getProperty("createNewRequestLink"), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("updateExistingEMSOfferingLink"), driver);
				    Thread.sleep(3000);
				    
				    
				    if(driver.findElement(By.xpath(p.getProperty("updateExistingEMSOfferingPage"))).isDisplayed())
				    {
				    	
				     CUtilities.fillText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), map.get("SEARCH_EXISTING_COURSE_ID").toString(), driver);
					 Thread.sleep(2000); 
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageCourseIDTextBox"), driver);
				     Thread.sleep(2000);
				     
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageDomainPickerImg"), driver);
						Thread.sleep(2000); 
						 String parentWindow= driver.getWindowHandle();
						    Set<String> allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					   
						CUtilities.clickButton(p.getProperty("searchDomainButton"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLink(p.getProperty("searchDomainResult1"), driver);
						Thread.sleep(2000); 
						
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					 Thread.sleep(3000);
					 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageDomainTextBox"), driver);
					 Thread.sleep(2000); 
					 
					 
					  CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageAudiencePickerImg"), driver);
					  Thread.sleep(2000); 
					  parentWindow= driver.getWindowHandle();
				        allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					   
						CUtilities.clickButton(p.getProperty("searchAudienceButton"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLink(p.getProperty("searchAudienceResult1"), driver);
						Thread.sleep(2000); 
						
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
					 Thread.sleep(3000);
					 CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
					 Thread.sleep(2000);
					 CUtilities.clearText(p.getProperty("searchExistingEMSCoursePageAudienceTextBox"), driver);
					 Thread.sleep(2000); 
					 
					//Giving very slow response from the Database
					 /*CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingIDTextBox"), map.get("SEARCH_EXISTING_OFFERING_ID").toString(), driver);
					 Thread.sleep(2000); 
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingIDTextBox"), driver);
				     Thread.sleep(2000);*/
					 
					//Giving very slow response from the Database
				    /* CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingStartDateTextBox"), map.get("SEARCH_EXISTING_START_DATE").toString(), driver);
					 Thread.sleep(2000); 
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingStartDateTextBox"), driver);
				     Thread.sleep(2000);*/
					 
				     CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingEndDateTextBox"), map.get("SEARCH_EXISTING_END_DATE").toString(), driver);
					 Thread.sleep(2000); 
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingEndDateTextBox"), driver);
				     Thread.sleep(2000);
				     
				     CUtilities.selectFromDropDownbyText(p.getProperty("searchExistingEMSOfferingPageDeleiveryTypeDrpDwn"), map.get("SEARCH_EXISTING_DELIVERY_TYPE").toString(), driver);
					 Thread.sleep(2000); 
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageOfferingEndDateTextBox"), driver);
				     Thread.sleep(2000);
				     CUtilities.selectFromDropDownbyText(p.getProperty("searchExistingEMSOfferingPageDeleiveryTypeDrpDwn"),"-Select One-", driver);
					 Thread.sleep(2000); 
				     
				     CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageLanguageTexBox"), map.get("SEARCH_EXISTING_LANGUAGE").toString(), driver);
					 Thread.sleep(2000); 
					 CUtilities.clickLink(p.getProperty("searchExistingEMSOfferingPageLangPickerImg"), driver);
				     Thread.sleep(2000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSOfferingPageLangResultLink"), driver);
				     Thread.sleep(2000);
					 CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSCoursePageExpanderLink"), driver);
				     Thread.sleep(2000);
				     CUtilities.clearText(p.getProperty("searchExistingEMSOfferingPageLanguageTexBox"), driver);
				     Thread.sleep(2000);
			 	
				     CUtilities.fillText(p.getProperty("searchExistingEMSOfferingPageOfferingTitleTextBox"), map.get("SEARCH_EXISTING__COURSE_TITLE").toString(), driver);
				     Thread.sleep(2000);
				     CUtilities.clickButton(p.getProperty("searchExistingEMSOfferingPageSearchOfferingButton"), driver);
				     Thread.sleep(3000);
				     CUtilities.clickLink(p.getProperty("searchExistingEMSOfferingPageSearchResultILT00341636"), driver);
				     Thread.sleep(2000);
				     CUtilities.clickButton(p.getProperty("updateExistingEMSOfferingPageUpdateButton"), driver);
				     Thread.sleep(2000);
				     
				    }
				    else
				    {
				    	success_flag=0;
						System.out.println("Error Occured:Update Existing EMS Offering Page Section doesn't exist.");
				    }
				    
				    CUtilities.fillText(p.getProperty("requestorIdTextBox"), map.get("REQUESTOR_ID").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("requestorlookupImg"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("requestorIdResultLink"), driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("functionalOrgdrpdown"), map.get("FUNCTIONAL_ORG").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("functionalSubOrgdrpdown"), map.get("FUNCTIONAL_SUB_ORG").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.fillText(p.getProperty("programManagerTextBox"), map.get("PROGRAM_MANAGER").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("prgMgrLookupImg"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("prgMgrResultPickerCell"), driver);
				    Thread.sleep(2000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("relationshipmanagerdrpdown"), map.get("RELATIONSHIP_MANAGER").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.fillText(p.getProperty("fundingdeptTextBox"), map.get("FUNDING_DEPT").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("fundeptLookupImg"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("fundeptPickerCell"), driver);
				    Thread.sleep(2000);  
				    CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickCheckbox(p.getProperty("expediteReqChkBox"), driver);
				    Thread.sleep(3000);
				    CUtilities.dialogclickOkButton(driver);
				    Thread.sleep(3000);
				    CUtilities.clickLink(p.getProperty("TCLASRequestAttachmentLink"), driver);
				    Thread.sleep(2000);
				    parentWindow= driver.getWindowHandle();
				    allWindows = driver.getWindowHandles();
				    for(String curWindow : allWindows){
				        driver.switchTo().window(curWindow);
				    }
				   
				    CUtilities.clickLink(p.getProperty("browseFileLink"), driver);
				    Thread.sleep(2000);
				    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
				    Thread.sleep(6000);
				    CUtilities.clickLink(p.getProperty("uploadFileLink"), driver);
				    Thread.sleep(2000);
				    CUtilities.clickLink(p.getProperty("closeFileUploadLink"), driver);
				    Thread.sleep(2000); 
				    
				    driver.switchTo().window(parentWindow);	
				    
					driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));	
					
				    CUtilities.fillTextArea(p.getProperty("requestNotesTextArea"), map.get("REQUEST_NOTES").toString(), driver);
				    Thread.sleep(3000);
				    CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
				    Thread.sleep(3000);
				    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
				    Thread.sleep(10000);
				    
				    if(driver.findElement(By.xpath(p.getProperty("basicCourseDetailsPage"))).isDisplayed())
				    {
				    	CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						
					    CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
					    Thread.sleep(10000);
						
						
				    }
				    else
				    {
				       success_flag=0;
					   System.out.println("Error Occured:Course Details Page Section doesn't exist.");
				    }
				    
				    if(driver.findElement(By.xpath(p.getProperty("offeringDetailsPage"))).isDisplayed())
				    {
				    	
						CUtilities.clickLink(p.getProperty("updateExistingEMSOfferingOfferingEditLink"), driver);
						Thread.sleep(2000);
						CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						CUtilities.clickLinkByClassName(p.getProperty("collapseAllLink"), driver);
						Thread.sleep(2000); 
						CUtilities.clickLinkByClassName(p.getProperty("expandAllLink"), driver);
						Thread.sleep(2000);
						
						CUtilities.fillText(p.getProperty("offeringDescpTextBox"), map.get("OFFERING_DESCRIPTION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.selectFromDropDownbyText(p.getProperty("updateExistingEMSOfferingParticipantCompletionDrpdwn"), map.get("PARTICIPATION_COMPLETION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("sessionStartDateTime"), map.get("SESSION_START_DATE_TIME").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("sessionEndDateTime"), map.get("SESSION_END_DATE_TIME").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("locationTextBox"), map.get("OFFERING_LOCATION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("locationLookup"), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("locationPicker"), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("facilityTextBox"), map.get("OFFERING_FACILITY").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("facilityLookup"), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("facilitypicker"), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("updateExistingEMSOfferingroomReservationDetTextBox"), map.get("ROOM_RESERVATION_DETAILS").toString(), driver);
						Thread.sleep(2000);
						
						CUtilities.clickLink(p.getProperty("surveyAddRow"), driver);
						Thread.sleep(2000); 
						  parentWindow= driver.getWindowHandle();
						    allWindows = driver.getWindowHandles();
						    for(String curWindow : allWindows){
						        driver.switchTo().window(curWindow);
						    }
					    CUtilities.selectFromDropDownbyText(p.getProperty("surveyIddrpDown"), map.get("SURVEY_NAME").toString(), driver);
					    Thread.sleep(2000);
					    CUtilities.fillText(p.getProperty("surveyinstructionDrpdwn"), map.get("SURVEY_INSTRUCTION").toString(), driver);
						Thread.sleep(2000);
						CUtilities.clickLink(p.getProperty("surveySaveButton"), driver);
						Thread.sleep(2000); 
						driver.switchTo().window(parentWindow);	 
					    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					  
					  					    
					    CUtilities.fillText(p.getProperty("openEnrollmentDateTxtBox"), map.get("OPEN_ENROLLEMENT_DATE").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("closeEnrollmentDateTxtBox"), map.get("CLOSE_BEFORE_ENROLLEMENT_DATE").toString(), driver);
						Thread.sleep(2000);
						CUtilities.fillText(p.getProperty("stopAutoPromotionDateTxtBox"), map.get("STOP_AUTO_PROMOTION_DATE").toString(), driver);
						Thread.sleep(2000);
						
						
						//Application Issue Please kindly check before excecuting the testcase whether this field should be enabled or not.
						
						/*CUtilities.clickLink(p.getProperty("emsCredittoDeptPicker"), driver);
						Thread.sleep(2000); 
							  parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
						    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter1"), map.get("ORGANIZATION_NAME_COST_CENTER").toString(), driver);
						    Thread.sleep(2000);
						    CUtilities.selectFromDropDownbyText(p.getProperty("organisationNameCostCenter2"), map.get("ORGANIZATION_NAME_COST_CENTER2").toString(), driver);
						    Thread.sleep(2000);
							CUtilities.clickLink(p.getProperty("emsCrdDeptSave&CloseButton"), driver);
							Thread.sleep(2000); 
							driver.switchTo().window(parentWindow);	 
						    driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
						*/
						
						
						    CUtilities.fillText(p.getProperty("pricePerLearnerTextBox"), map.get("PRICE_PER_LEARNER").toString(), driver);
							Thread.sleep(2000);
							
							  CUtilities.clickLink(p.getProperty("learnerCancellationDetailsAddDropDetails"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
							 CUtilities.fillText(p.getProperty("lateChargesTextBox"), map.get("LATE_CHARGE").toString(), driver);
							 Thread.sleep(2000);
							 CUtilities.fillText(p.getProperty("calendarDaysTextBox"), map.get("CALENDAR_DAYS").toString(), driver);
							 Thread.sleep(2000);
						     CUtilities.clickLink(p.getProperty("addDropSaveButton"), driver);
							 Thread.sleep(2000); 
							 driver.switchTo().window(parentWindow);	 
							 driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							 
							 CUtilities.fillText(p.getProperty("breakOutRoomsTextBox"), map.get("BREAKOUT_ROOMS").toString(), driver);
						     Thread.sleep(2000);
						     CUtilities.fillText(p.getProperty("TCsupportRequestDayofClassTextBox"), map.get("TC_SUPPORT").toString(), driver);
						     Thread.sleep(2000);  
						     
						     CUtilities.clickLink(p.getProperty("TCOfferingAttachmentLinkId"), driver);
							 Thread.sleep(2000);
							    parentWindow= driver.getWindowHandle();
							    allWindows = driver.getWindowHandles();
							    for(String curWindow : allWindows){
							        driver.switchTo().window(curWindow);
							    }
							   
							    CUtilities.clickLink(p.getProperty("selectFileButton1"), driver);
							    Thread.sleep(2000);
							    Runtime.getRuntime().exec(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\fileupload.exe");
							    Thread.sleep(6000);
							    CUtilities.selectFromDropDownbyText(p.getProperty("courseCategoryDrpDown"), map.get("COURSE_CATEGORY").toString(), driver);
								Thread.sleep(3000);
							    CUtilities.clickLink(p.getProperty("uploadButton1"), driver);
							    Thread.sleep(2000);
							    CUtilities.clickLink(p.getProperty("closeButton1"), driver);
							    Thread.sleep(2000); 
							    
							    driver.switchTo().window(parentWindow);	
							    
								driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
								
								
							    CUtilities.clickLink(p.getProperty("contentModuleAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							   CUtilities.fillText(p.getProperty("contentNameTextBox"), map.get("CONTENT_NAME").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("contentURLTextBox"), map.get("CONTENT_URL").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("contentInstructionTextBox"), map.get("CONTENT_INSTRUCTION").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.clickLink(p.getProperty("contenSaveButton"), driver);
							   Thread.sleep(2000); 
							   driver.switchTo().window(parentWindow);	 
							   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							   
							 

							    CUtilities.clickLink(p.getProperty("coltAddRowLink"), driver);
										Thread.sleep(2000); 
										  parentWindow= driver.getWindowHandle();
										    allWindows = driver.getWindowHandles();
										    for(String curWindow : allWindows){
										        driver.switchTo().window(curWindow);
										    }
							   CUtilities.fillText(p.getProperty("coltassessmentTextBox"), map.get("COLT_ASSESSMENT_NAME").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("coltIdTextBox"), map.get("COLT_ID").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.fillText(p.getProperty("coltinstructionTextBox"), map.get("COLT_INSTRUCTION").toString(), driver);
							   Thread.sleep(2000);
							   CUtilities.clickLink(p.getProperty("coltSaveButton"), driver);
							   Thread.sleep(2000); 
							   driver.switchTo().window(parentWindow);	 
							   driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
							   
							
							 
						      
						       CUtilities.fillText(p.getProperty("PONumberTextBox"), map.get("PO_NUMBER").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.fillText(p.getProperty("materialLocationTextBox"), map.get("MATERIAL_LOCATION").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.fillText(p.getProperty("cateringDetailsTextBox"), map.get("CATERINGS_DETAILS").toString(), driver);
						       Thread.sleep(2000);
						       
						       CUtilities.clickLink(p.getProperty("addMaterialsLink"), driver);
								Thread.sleep(2000); 
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }

					           CUtilities.clickLink(p.getProperty("addMaterialSearchButton"), driver);
					           Thread.sleep(2000); 
					           CUtilities.clickLink(p.getProperty("addMaterialDataOption1"), driver);
					           Thread.sleep(2000); 
					           driver.switchTo().window(parentWindow);	 
					           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					           
					         
					           CUtilities.fillTextArea(p.getProperty("offeringspclInstForLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
						       Thread.sleep(2000);
						     
						       CUtilities.clickButton(p.getProperty("saveDraftButtonlink"), driver);
							   Thread.sleep(3000);
							   CUtilities.clickButton(p.getProperty("continueButtonLink"), driver);
							   Thread.sleep(10000);
							   
							   CUtilities.clickButton(p.getProperty("offeringSaveDraftButton"), driver);
							   Thread.sleep(3000);
							   
							   CUtilities.clickButton(p.getProperty("offeringsPreviewButton"), driver);
							   Thread.sleep(3000);
								  parentWindow= driver.getWindowHandle();
								    allWindows = driver.getWindowHandles();
								    for(String curWindow : allWindows){
								        driver.switchTo().window(curWindow);
								    }
								    Thread.sleep(5000);   
					           driver.switchTo().window(parentWindow);	 
					           driver.switchTo().frame(((FindsByName)driver).findElementByName("SabaMain"));
					           
					           //Requestor Can only Submit to LAS.
							  /* CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
							   Thread.sleep(2000);
							   CUtilities.clickButton(p.getProperty("submitToLASCancelButton"), driver);
							   Thread.sleep(2000);
							   CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton"), driver);
							   Thread.sleep(2000);
							   CUtilities.fillTextArea(p.getProperty("LDLCommentsSubmitToLASTextArea"), map.get("OFFERINGS_SPC_INST_LAS").toString(), driver);
						       Thread.sleep(2000);
						       CUtilities.clickButton(p.getProperty("offeringsSubmitToLASButton2"), driver);
							   Thread.sleep(2000);
							   */
       
						
				    }
				    else
				    {
				    	 success_flag=0;
						 System.out.println("Error Occured:Offering Details Section Page doesn't exist.");
				    }
				    

				    
                  }
				  else
				  {
					  success_flag=0;
					  System.out.println("Error Occured:Create New Request Tab doesn't exist.");
				  }
				 }
			  else
			  {
				  success_flag=0;
				  System.out.println("Error Occured:Request Tab in HomePage doesn't exist.");
			  }  
				  
				  
				  CUtilities.clickLink(p.getProperty("myHomeLink"), driver);
				  Thread.sleep(5000);
				  CUtilities.logout(driver);
				 
			  }
			  else
			  {   
				  success_flag=0;
				  System.out.println(testCaseName+" testcase execution failed.");
				 
			  }
			  
			  if(success_flag==1)
			  {
				  DBUtilities.updateDatabaseQuery(execDate,execTime, testCaseName, "PASSED");
				  System.out.println(testCaseName+" testcase execution Successful.");
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
					   					   			  
					   
					   if(testCaseName.equalsIgnoreCase("LDL_TCActionItems_CompleteRequest_Verification"))
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
			               
			               if((testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItemsVerification")||testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_CancelRequest_Verification")||testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_SubmitToEMS_Verification")||testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_ReturnRequest_Verification"))||testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_AssignRequest_Verification"))
			               { if(tdElement.getText().equalsIgnoreCase("Assigned"))
			                 {   
			                	reqLink.click();
			                	Thread.sleep(2000);
			                	flag=1;
			                	
			                 }
			               }
			              
			               if(testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_SetupComplete_Verification"))
			               {if(tdElement.getText().equalsIgnoreCase("Submitted To EMS"))
			                {   
			                	reqLink.click();
			                	Thread.sleep(2000);
			                	flag=1;
			                	
			                }
			               }
			               
			               if(testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_CompleteRequest_Verification"))
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
			         else if (testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_SubmitToEMS_Verification"))
			         {  
			        	 if(driver.findElements(By.xpath(p.getProperty("actionItemPageEditRequestButton"))).size()>0)		 
			        	 {   
			        		
			        		 CUtilities.clickButton(p.getProperty("actionItemPageEditRequestButton"), driver);
							 Thread.sleep(5000);
							 if(driver.findElement(By.xpath(p.getProperty("requestDetailsPage"))).isDisplayed())
							 {    
								  CUtilities.fillText(p.getProperty("TCExpectedLASDate"), map.get("EXPECTED_LAS_DATE").toString(), driver);
								  Thread.sleep(3000);
								  CUtilities.selectFromDropDownbyText(p.getProperty("TCTieredServiceSelectdrpDwn"), map.get("TIERED_SERVICES").toString(), driver);
								  Thread.sleep(3000);
								  CUtilities.fillText(p.getProperty("TCDeliveryServicefeeTxtBox"), map.get("DELIVERY_SERVICE_FEE").toString(), driver);
								  Thread.sleep(3000);
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
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_CancelRequest_Verification"))
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
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_ReturnRequest_Verification"))
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
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_AssignRequest_Verification"))
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
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_SetupComplete_Verification"))
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
			         
			         else if(testCaseName.equalsIgnoreCase("LDL_TRCOLEADActionItems_CompleteRequest_Verification"))
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
			        	 CUtilities.clickButton(p.getProperty("actionItemscontinueButtonLink"), driver);
					     Thread.sleep(5000);
					   
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
