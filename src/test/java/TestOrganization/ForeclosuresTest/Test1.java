package TestOrganization.ForeclosuresTest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	 public static void main(String[] args){
	
		System.setProperty("webdriver.chrome.driver","C:\\31TestFolder\\New folder\\chromedriver.exe");  
	
	
     WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 //Launching sample website
	 driver.get("https://sso.eservices.jud.ct.gov/foreclosures/Public/PendPostbyTownList.aspx");
	
	 
	 //Get list of Cities
	 List<WebElement> allLinks = driver.findElements(By.xpath("//*[contains(@id,'Body_Panel1')]//a"));
	 
	 //Traversing through the list and checking city matches with the given list
	       for(WebElement link:allLinks)
	       {
	    	  String town = link.getText();
	    	  if(town == "Milford"|| town == "Trumbull"|| town == "Norwalk"|| town == "Stamford"|| town == "Shelton"|| town == "Fairfield")
	    	  {
	    		  System.out.println("Opened city is" + " - " + town);
	    	      //Navigated to specific city sales list in new browser
	    	      driver.get(link.getAttribute("href"));
	    	    
	    		 List<WebElement> datesList = driver.findElements(By.xpath("//span[contains(@id, 'Label1')]"));
	    		 for(WebElement date:datesList)
	  	         {
	  	    	   String salesDate = date.getText();
	  	    	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	  	    	  LocalDateTime now = LocalDateTime.now();  
	  	          System.out.println("today date is"+sdf.format(now));
	          
	  	         if(salesDate.compareTo(sdf.format(now))<7){
	             driver.findElement(By.xpath("//a[text()='View Full Notice']")).sendKeys(Keys.CONTROL +"t");
	              } 
	  	         }
	    		 
	    	   
	    	  
	        }
	    	    
	
	       
	       
	       
	       }
	 }

}
