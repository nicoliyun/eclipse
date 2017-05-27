package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import function.Utiltools;

public class HomePage {
	
    private WebDriver dr = null;
     
    private By input = By.id("kw");    
    private By search_button = By.xpath(".//*[@id='su']");        
    private By result = By.xpath(".//*[@id='container']/div[2]/div/div[2]"); 
    private By login = By.name("tj_login") ;
   
    

	public HomePage(WebDriver driver) {  
           // TODO Auto-generated constructor stub  
           this.dr = driver;  
    }  


	public WebElement getInput() {  
           return dr.findElement(input);  
    }  
      
   
    public WebElement getSearch_button() {  
           return dr.findElement(search_button);  
    }  

  
    public WebElement getResult(){   //*[@id="page"]/strong/span[1]/i
           return dr.findElement(result);  
    }  
      
 
    public boolean search(String search_object){  
             
           this.getInput().sendKeys(search_object.toString());  
           this.getSearch_button().click();  
           return Utiltools.IsElementPresent(dr, result);       
//           return this.getSearch_button() ;
    }  
    
    public WebElement getLogin() {
    	
		return dr.findElement(login);
	}
}
