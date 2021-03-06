package com.ldlapp.DataBaseUtility;


//External Packages importing
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DataBaseUtilities {
	Map map=null;
	ArrayList temp=null;
	Properties p=null;
	FileInputStream fis=null;
	ArrayList moduleRecord=null;
	
	
	Connection dbConnection = null;
	ResultSet tableRecord = null;
	ResultSet tableColumns = null;
	Statement statement = null;
	
	 //
    // Create an ArrayList to store the data read from excel sheet.
    //
    List sheetData = new ArrayList();
    List sheetDataCol =  new ArrayList();
	
	@BeforeTest
	public void initialize() throws Exception {

		
	
	}
		
	/**
	 * Add code to be executed each iteration for this virtual user.
	 */
	@Test
	public void run() throws Exception {

	}
	
	/**
	 * This function is used to add a new record in the database
	 */
	public void insertRecord(String moduleName, String testCaseName) throws Exception {
		
	}
    
	public void updateDatabaseQuery(String execDate,String execTime,String testCaseName,String testStatus) throws Exception 
	{	
		System.out.println("Inside updateDatabaseQuery function:");
	    statement.executeUpdate(getProperty().getProperty("sqlUpdateQuery_DW")+"'"+execDate+"',"+getProperty().getProperty("concatSqlUpdateQuery_DW")+"'"+execTime+"',"+getProperty().getProperty("concatSqlUpdateQuery_DW2")+"'"+testStatus+"' "+getProperty().getProperty("concatSqlUpdateQuery_DW3")+"'"+testCaseName+"'");
	    System.out.println("Update success.");

	}
	
	/**
	 * @author arwin
	 * @Method DatabaseConnection
	 * @Desc   Connect to Database
	 */
	public void DatabaseConnection() throws Exception
	{
		p=getProperty();
		Class.forName(p.getProperty("driverName"));
		Thread.sleep(2000);
		dbConnection  = DriverManager.getConnection(p.getProperty("url"),p.getProperty("userName"),p.getProperty("passWord"));
		System.out.println("Connection Successful to DB.");			
					
	}
	
	public void databaseDisconnect() throws Exception{
		dbConnection.close();
	}

	
	/**
	 * @author arwin
	 * @Method getTableData
	 * @Desc   Return the table data in the form of table object
	 * @param  moduleName
	 */
	
	public ResultSet getTableData(String moduleName) throws Exception 
	{
		p=getProperty();
		try{
		    
			Thread.sleep(2000);
			statement = dbConnection.createStatement();
			tableRecord = statement.executeQuery(p.getProperty("sqlTableDataQuery_DW")+"'"+moduleName+"'");
			return tableRecord;
		}catch(Exception e){
			throw e;
		}
	}


	/**
	 * @author arwin
	 * @Method getColumnName
	 * @Desc   Return the table column names in the form of table object
	 */
	
	public ResultSet getColumnName() throws Exception {
	try{
		Thread.sleep(2000);
		statement = dbConnection.createStatement();
		tableColumns=statement.executeQuery(p.getProperty("sqlGetColumnQuery_DW"));
		
		
	return tableColumns;
	
	}catch(Exception e){
		throw e;
	}
		
	}

	/**
	 * @author arwin
	 * @Method setDBRecord
	 * @Desc   Set the table record to the arraylist and set respective arraylist to the Map with the specific keyValue
	 * @param  moduleName
	 */
	
	public ArrayList setDBRecord(String moduleName) throws Exception{
		String rowContent=null;
		
		String [] rowValue=null;
		
		String key=null;
		
		
	   moduleRecord=new ArrayList();
		
		try{
			
			tableRecord =getTableData(moduleName);
		 
			while(tableRecord.next()) //if more than one record in tableRecord
			{
				
			
				
				ResultSet tableColumns=null;
				
				map=new HashMap();
				
				tableColumns=getColumnName();
				
				
				while(tableColumns.next()){
					
						
				
				
					String colName=tableColumns.getString("COLUMN_NAME");
					
				
					map.put(colName,tableRecord.getString(colName));	//Mapping the columnNames with respective value at runtime
					
					
				}
					moduleRecord.add(map);
					
			}
			
			
	
			return moduleRecord;
			}catch(Exception e){

			throw e;
		}
	}
	
	public void excelDatabaseConnection() throws Exception
	{
		p=getProperty();
		Class.forName(p.getProperty("exceldriverName"));
		dbConnection  = DriverManager.getConnection(p.getProperty("excelurl"),p.getProperty("userName"),p.getProperty("passWord"));
		System.out.println("Connection Successful to DB excel.");			
					
	}
    
	public List excelgetTableData(String moduleName) throws Exception 
	{
		  try {
				String workingdirectory = System.getProperty("user.dir");
		        // Open the Excel file
		        FileInputStream fis = new FileInputStream(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\LDLSampleTestData.xls");
		        // Access the required test data sheet
		        HSSFWorkbook wb = new HSSFWorkbook(fis);
		        HSSFSheet sheet = wb.getSheet("testdata");
		        // Loop through all rows in the sheet
		        // Start at row 1 as row 0 is our header row
		        Iterator rows = sheet.rowIterator();
	            while (rows.hasNext()) {
	            	
	                HSSFRow row = (HSSFRow) rows.next();
	                Iterator cells = row.cellIterator();

	                List data = new ArrayList();
	                while (cells.hasNext()) {
	                    HSSFCell cell = (HSSFCell) cells.next();
	                    sheetData.add(cell);
	                }

	                //sheetData.add(data);
	            }
		        fis.close();
		    } catch (Exception e) {
		        System.out.println("Error Occured:"+e);
		    }  
		  System.out.println("Table data:"+sheetData);
		  return sheetData;
	}

	public List excelgetColumnName() throws Exception {
		 try {  
				String workingdirectory = System.getProperty("user.dir");
		        // Open the Excel file
		        FileInputStream fis = new FileInputStream(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\LDLSampleTestData.xls");
		        // Access the required test data sheet
		        HSSFWorkbook wb = new HSSFWorkbook(fis);
		        HSSFSheet sheet = wb.getSheet("testdata");
		        // Loop through all rows in the sheet
		        // Start at row 1 as row 0 is our header row
		        for(int count = 0;count<=0;count++){
		        	
		            HSSFRow row = sheet.getRow(count);
		            Iterator cells = row.cellIterator();
		           // List data = new ArrayList();
	                while (cells.hasNext()) {
	                    HSSFCell cell = (HSSFCell) cells.next();
	                    if(!cell.equals(" "))
	                    sheetDataCol.add(cell);
	                   
	               }
	                
		        }
		        
		        fis.close();
		       
		      
		    } catch (Exception e) {
		        System.out.println("Error Occured:"+e);
		    } 
		 System.out.println("Table Coloumn data:"+sheetDataCol);
		 return sheetDataCol;
	}
	
	public ArrayList excelSetDBRecord (String moduleName) throws Exception{
        
		
		 List exceltableRecord = null; 
		 List exceltableColumns=null;
		 HSSFCell cell = null;
		 moduleRecord=new ArrayList();
		
		try{
			
			exceltableRecord =excelgetTableData(moduleName);
			exceltableColumns=excelgetColumnName();
			
		   
			for(int j=0;j<exceltableRecord.size();) //if more than one record in tableRecord
			{   
		
				
				map=new HashMap();
						
				for (int i = 0; i < exceltableColumns.size(); i++) {
					 ++j;
					 
					 if(j<exceltableRecord.size())
					 {
					  cell = (HSSFCell) exceltableRecord.get(j-1);
					   String colName=exceltableColumns.get(i).toString();
						map.put(colName,cell.getStringCellValue().toString());	//Mapping the columnNames with respective value at runtime 
					 
					 }
	   
				   
				}
				
	     	  moduleRecord.add(map);	
					
			}
			
	        System.out.println("Excel Data in the file:"+moduleRecord);
	        Thread.sleep(5000);
			return moduleRecord;
			}
		catch(Exception e){

			throw e;
		}
	  
		
	}
	
		
	public Properties getProperty() throws Exception{
		String workingdirectory = System.getProperty("user.dir");
		p=new Properties();
		
		fis=new FileInputStream(workingdirectory+"\\com\\ldlapp\\constantpropertieslibraryfiles\\DbConnectionProperties.properties");
		
		p.load(fis);
		return p;
	}
	
	@AfterTest
	public void finish() throws Exception {
		
	}	
}
