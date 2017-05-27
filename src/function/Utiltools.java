package function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utiltools {
	/** 
     * 
     * @author Administrator 
     * 
     * 
     *
     * 
     * */  
    public static Object[][] getTestDataByExcel(String filePath, String fileName, String sheetName) throws IOException {  
           File file = new File(filePath + "\\" + fileName);  
           System.out.println("file is :" + file);  
           FileInputStream inputstream = new FileInputStream(file);  
           Workbook workbook = null;  
           String fileExtensionName = fileName.substring(fileName.indexOf("."));  
           if (fileExtensionName.equals(".xlsx")) {  
                  workbook = new XSSFWorkbook(inputstream);  
           } else if (fileExtensionName.equals(".xls")) {  
                  workbook = new HSSFWorkbook(inputstream);  
           } else {  
                  throw new IOException("wrong fileName");  
           }  
           org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);  
           int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();  
           List<Object[]> records = new ArrayList<Object[]>();  
           for (int i = 1; i < rowCount + 1; i++) {  
                  Row row = sheet.getRow(i);  
                  String fields[] = new String[row.getLastCellNum()];  
                  for (int j = 0; j < row.getLastCellNum(); j++) {  
                        if (row.getCell(j).getCellType() == 0) {  
                                 
             
                               fields[j] = row.getCell(j).getNumericCellValue() + "";  
                    
                                 
                        } else {  
                               fields[j] = row.getCell(j).getStringCellValue();  
                        }  
                  }  
                  records.add(fields);  
           }  
           Object[][] results = new Object[records.size()][];  
           for (int x = 0; x < records.size(); x++) {  
                  results[x] = records.get(x);  
           }  
           inputstream.close();  
           workbook.close();  
           return results;  
    }  
      
      
    /** 
     * 
     * @author Administrator 
     * @param
     * 
     *
     * 
     * */  
    public static boolean IsElementPresent(WebDriver dr,By by){  
           try{  
                  dr.findElement(by);  
                  return true;  
           }catch(NoSuchElementException e){  
                          
                  return false;  
                  }       
    }  
        
    /** 
     * 
     * @author Administrator 
     * @param browser = ie,firefox,chrome 
     * 
     * 
     * 
     * */  
    public static WebDriver Initialize_Driver(String browser){  
             
           WebDriver driver = null;  
             
           if(browser.equalsIgnoreCase("firefox")){  
                    
                  driver = new FirefoxDriver();  
                    
           }else if(browser.equalsIgnoreCase("chrome")){  
                    
                   System.setProperty("webdriver.chrome.driver", "C:/Python27/chromedriver.exe");  
                   driver = new ChromeDriver();  
                    
           }else if(browser.equalsIgnoreCase("ie")){  
                    
                   System.setProperty("webdriver.ie.driver", "D:\\Jar\\Selenium_2.53\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");  
                   driver = new InternetExplorerDriver();  
                    
           }  
             
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
           return driver; 
    }

}
