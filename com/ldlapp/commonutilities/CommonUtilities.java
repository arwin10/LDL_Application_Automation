package com.ldlapp.commonutilities;

//External Packages importing
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.Keys;

public class CommonUtilities {
	//WebDriver driver; 
		Properties p=null;
		FileInputStream fis=null;
		Map map=null;
		public ArrayList moduleRecord=null;
		Robot r=null;
		
		
		
		@BeforeTest
		public void initialize() throws Exception {
			
			
			p=getProperty();
			
		
		}
			
		/**
		 * Add code to be executed each iteration for this virtual user.
		 */
		@Test
		public void run() throws Exception {

			
		}
		
		
		public Map userLogin(ArrayList moduleRecord,String testCaseName,WebDriver driver1) throws Exception{

			
			Map map=null;
			//System.out.println("Empty:"+moduleRecord.isEmpty());
			
			System.out.println("Module size:"+moduleRecord.size());
			
			for(int i=0;i<moduleRecord.size();i++)
			{
				map=(Map)moduleRecord.get(i);
                 
				/*Printing Table Data to the console. */
		        //System.out.println("Tabledata:"+map);
				
				if(map.get("TEST_METHOD_NAME").toString().equalsIgnoreCase(testCaseName)){
					
					login(map,driver1);
                    break;
				}
				else
					continue;
			}
			return map;

		}
       
		
		//Old Login Page as SabaApp
		public void login(Map map,WebDriver driver1) throws Exception 
		{
			System.out.println("Inside Login Function:");
			
			if (driver1.findElement(By.tagName(getProperty().getProperty("window"))).isDisplayed()) {
	            
			
				
				driver1.get((map.get("I_URL")).toString());
				Thread.sleep(5000);
	            
				driver1.switchTo().frame(((FindsByName)driver1).findElementByName("SabaMain"));	
				
				fillText(getProperty().getProperty("username"),(map.get("I_USERNAME")).toString(),driver1);
				Thread.sleep(2000);
				
				fillText(getProperty().getProperty("password"),(map.get("I_PASSWORD")).toString(),driver1);
				Thread.sleep(2000);

			    clickButton(getProperty().getProperty("loginbutton"),driver1);
				Thread.sleep(2000);
				System.out.println("Login is successful.");

		   }
			
		   else
			{
				System.out.println("Error:Login Failed.");
			}
		 }
		
		//New Login Page as CEC Credentials
	/*	public void login(Map map,WebDriver driver1) throws Exception 
		{
			System.out.println("Inside Login Function:");
			
			if (driver1.findElement(By.tagName(getProperty().getProperty("window"))).isDisplayed()) {
	            
			
				
				driver1.get((map.get("I_URL")).toString());
				Thread.sleep(5000);
	            
				
				
				fillText(getProperty().getProperty("usernameNew"),(map.get("I_USERNAME")).toString(),driver1);
				Thread.sleep(5000);
				
				fillText(getProperty().getProperty("passwordNew"),(map.get("I_PASSWORD")).toString(),driver1);
				Thread.sleep(5000);

			    clickButton(getProperty().getProperty("loginbuttonNew"),driver1);
				Thread.sleep(5000);
				
				clickLink(getProperty().getProperty("LDLAppLink"),driver1);
				Thread.sleep(5000);
				
			   driver1.switchTo().frame(((FindsByName)driver1).findElementByName("SabaMain"));	

		   }
			
		   else
			{
				System.out.println("Error:Login Failed.");
			}
		 }*/
		
		public void logout(WebDriver driver1) throws Exception 
		{
			System.out.println("Inside Logout Function:");
			
			if (driver1.findElement(By.xpath(getProperty().getProperty("homepage"))).isDisplayed()) {
	 
				
			    clickLink(getProperty().getProperty("logoutLink"),driver1);
				Thread.sleep(5000);
                System.out.println("Logout is succesful.");
		   }
			
		   else
			{
				System.out.println("Error:Logout Failed.");
			}
		 }
		
	    
		public void captureScreen(String filepath) throws Exception{

			 try
			    {      
			     Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
			     Robot robot = new Robot();
			     BufferedImage img = robot.createScreenCapture(new Rectangle(size));
			     File save_path=new File(filepath);
			     ImageIO.write(img, "JPG", save_path);
			    }
			    catch(Exception e)
			    {
			         System.out.println("Failed to capture screen error occured:"+e);
			    }

		}
		public void clickImage(final String linkProperties,WebDriver driver1) throws Exception{
		 WebElement elementimage = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(linkProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementimage.isDisplayed()){
				elementimage.click();
			}
			else
				System.out.println("Error:Image not clicked.");
		}
		
		public void clickLinkByClassName(final String linkProperties,WebDriver driver1) throws Exception{

			 WebElement elementLink = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.className(linkProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementLink.isDisplayed()){
				elementLink.click();
			}
			else
				System.out.println("Error:Link not clicked.");
		}
		
		
		
		public void clickLink(final String linkProperties,WebDriver driver1) throws Exception{

			 WebElement elementLink = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(linkProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementLink.isDisplayed()){
				elementLink.click();
			}
			else
				System.out.println("Error:Link not clicked.");
		}
		public void clickRadioButton(final String linkProperties,WebDriver driver1) throws Exception{

			 WebElement elementRadioButton = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(linkProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementRadioButton.isDisplayed()){
				elementRadioButton.click();
			}
			else
				System.out.println("Error:RadioButton not checked.");
		}
		public void clickTextBox(final String linkProperties,WebDriver driver1) throws Exception{

			 WebElement elementTextBox = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(linkProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementTextBox.isDisplayed()){
				elementTextBox.click();
			}
			else
				System.out.println("Error:TextBox not clicked.");
		}
		
		public void clickTextArea(final String linkProperties,WebDriver driver1) throws Exception{

			 WebElement elementTextArea = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(linkProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementTextArea.isDisplayed()){
				elementTextArea.click();
			}
			else
				System.out.println("Error:TextArea not clicked.");
		}
		public void clickCheckbox(final String linkProperties,WebDriver driver1) throws Exception{

			 WebElement elementCheckbox = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(linkProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementCheckbox.isDisplayed()){
				elementCheckbox.click();
			}
			else
				System.out.println("Error:Checkbox not clicked.");
		}
        
		public void clearText(final String textProperties,WebDriver driver1) throws Exception{


			 WebElement elementTextBox = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(textProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementTextBox.isDisplayed()){
				elementTextBox.clear();
			
			}
			else
				System.out.println("Error:TextBox not Cleared.");

		}
		
		
		public void locateElement(final String Properties,WebDriver driver1) throws Exception{


			 WebElement element = driver1.findElement(By.xpath(Properties));		 
				 Coordinates coordinate = ((Locatable)element).getCoordinates();
				 coordinate.inViewPort();
			

		}
	
		
		public void fillText(final String textProperties,String textValue,WebDriver driver1) throws Exception{


			 WebElement elementTextBox = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(textProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementTextBox.isDisplayed()){
				elementTextBox.clear();
				elementTextBox.sendKeys(textValue);
			}
			else
				System.out.println("Error:TextBox not Filled.");

		}
		
		public void clickButton(final String buttonProperties,WebDriver driver1) throws Exception{
				
			 WebElement elementButton = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(buttonProperties));
		    	          }
		    	    	  
		    	    	
		    	       });
			
			if(elementButton.isDisplayed()){
				elementButton.click();
			}
			else
			 System.out.println("Error:Button not clicked.");
		
		}
	    
		public void clickElement(final String elementProperties,WebDriver driver1) throws Exception{
			
			 WebElement elementElement = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(elementProperties));
		    	          }
		    	    	  
		    	    	
		    	       });
			
			if(elementElement.isDisplayed()){
				elementElement.click();
			}
			else
			 System.out.println("Error:Element not clicked.");
		
		}
		
		
		public void dialogclickOkButton(WebDriver driver1) throws Exception{
			Alert alert = driver1.switchTo().alert();
			
			if(alert!=null)
			alert.accept();
			else
				System.out.println("Error:Dialog box clicking ok button.");
		}

	   public void blankTxnSearch(String searchButtonprop,WebDriver driver1) throws Exception {
			
			System.out.println("func: BlankTxnSearch");
			clickButton(p.getProperty(searchButtonprop),driver1);
			Thread.sleep(5000);
			Alert alert = driver1.switchTo().alert();
			if(alert!=null)
			{
				alert.accept();
				
			}
			else
			{
				System.out.println("No blank search alert box popped up");
			}
		}

		public void invalidTxnSearch(String textBoxProp,String searchButtonprop,String txnNumber,WebDriver driver1) throws Exception {
		
			List<WebElement> element = driver1.findElements(By.tagName(p.getProperty("noResultMsg")));
			System.out.println("func: InvalidTxnSearch");

			Thread.sleep(4000);
			fillText(p.getProperty(textBoxProp),txnNumber,driver1);
			Thread.sleep(3000);
			clickButton(p.getProperty(searchButtonprop),driver1);
			Thread.sleep(5000);
			if(element.size()!=0)
			{
				System.out.println("No such transaction exists");
			}
			else
			{
				System.out.println("Transaction exists");
			}
		}
		
	     public void robotClick(final String mouseProperties,WebDriver driver1) throws Exception{
	    	 WebElement element = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(mouseProperties));
		    	          }
		    	    	  
		    	    	
		    	       });
	    	 
			if(element.isDisplayed()){
				Actions actions = new Actions(driver1);
				actions.moveToElement(element);
			    actions.perform();
				r = new Robot();
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}
		 }
	     
	     public void robotClickTextArea(final String mouseProperties,WebDriver driver1) throws Exception{
	         
	    	 WebElement element = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(mouseProperties));
		    	          }
		    	    	  
		    	    	
		    	       });
	 	 
			if(element.isDisplayed()){
				Actions actions = new Actions(driver1);
				actions.moveToElement(element);
			    actions.perform();
				r = new Robot();
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}
	  	 }
	     
	     public void robotClickImage(final String mouseProperties,WebDriver driver1) throws Exception{
	         
	    	 WebElement element = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(mouseProperties));
		    	          }
		    	    	  
		    	    	
		    	       });
	 	 
			if(element.isDisplayed()){
				Actions actions = new Actions(driver1);
				actions.moveToElement(element);
			    actions.perform();
				r = new Robot();
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
			}
	 	 }
		
		public void selectFromDropDownbyIndex(final String dropDownProperties,int dropDownValue,WebDriver driver1) throws Exception{

			 Select elementDropDown = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<Select>(){
		    	    	  //@Override	  
		    	    	  public Select apply(WebDriver d) {
		    	            return new Select(d.findElement(By.xpath(dropDownProperties)));
		    	          }
		    	    	  
		    	    	
		    	       });
	        List<WebElement> dropdownvalue = elementDropDown.getAllSelectedOptions();
			if(dropdownvalue.size()!=0){
				elementDropDown.selectByIndex(dropDownValue);
			}
			else
				System.out.println("Error:Not able to select from Dropdown.");
		}
		
		public void selectFromDropDownbyText(final String dropDownProperties,String dropDownValue,WebDriver driver1) throws Exception{

			 Select elementDropDown = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<Select>(){
		    	    	  //@Override	  
		    	    	  public Select apply(WebDriver d) {
		    	            return new Select(d.findElement(By.xpath(dropDownProperties)));
		    	          }
		    	    	  
		    	    	
		    	       });
	       List<WebElement> dropdownvalue = elementDropDown.getAllSelectedOptions();
			if(dropdownvalue.size()!=0){
				elementDropDown.selectByVisibleText(dropDownValue);
			}
			else
				System.out.println("Error:Not able to select from Dropdown.");
		}
		
		public void fillTextArea(final String textProperties,String textValue,WebDriver driver1) throws Exception{
			 WebElement elementTextArea = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(textProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementTextArea.isDisplayed()){
				elementTextArea.sendKeys(textValue);
			}
			else
				System.out.println("Error:TextArea not Filled.");
		}

		public void fillDate(final String dateProperties,String dateValue,WebDriver driver1) throws Exception{
			 WebElement elementDate = (new WebDriverWait(driver1,120)).until(
		    	        new ExpectedCondition<WebElement>(){
		    	    	  //@Override	  
		    	    	  public WebElement apply(WebDriver d) {
		    	            return d.findElement(By.xpath(dateProperties));
		    	          }
		    	    	  
		    	    	
		    	       });

			if(elementDate.isDisplayed()){
				elementDate.sendKeys(dateValue);
			}
			else
				System.out.println("Error:Date not Filled.");
		}

		public String todayDate() {

			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			System.out.println("Now the date is :=>  " + dateNow);
			return dateNow;
		}

		public String nextYearDate() {

			Calendar currentDate = Calendar.getInstance();
			currentDate.add(Calendar.MONTH, 18);
			SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
			String dateNow = formatter.format(currentDate.getTime());
			System.out.println("Now the date is :=>  " + dateNow);

			return dateNow;
		}
		
		public Properties getProperty() throws Exception{
			
			String workingdirectory = System.getProperty("user.dir");
			p=new Properties();
			
			fis=new FileInputStream(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\SASObjectProperties.properties");

			p.load(fis);
			
			return p;
		}
		
		 public void robotPressButtons() throws Exception{
	        
		  			r = new Robot();
		  		/*	r.keyPress(KeyEvent.VK_CONTROL);
		  			r.keyPress(KeyEvent.VK_ALT);
		  			r.keyPress(KeyEvent.VK_F);
		  			Thread.sleep(2000);
		  			r.keyRelease(KeyEvent.VK_CONTROL);
		  			r.keyRelease(KeyEvent.VK_ALT);
		  			r.keyRelease(KeyEvent.VK_F);
		  			Thread.sleep(2000);
			 */
		  			r.keyPress(KeyEvent.VK_RIGHT);
		  			Thread.sleep(4000);
		  			r.keyRelease(KeyEvent.VK_RIGHT);
		 }
		  	
		
		@AfterTest
		public void finish() throws Exception {
		}
}
