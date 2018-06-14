package com.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 *  Test case:
      Title: dice job search 

      Step 1. Launch browser and navigate to https://dice.com 
        Expected: dice home page should be displayed

      Step 2. Insert search keyword and location then click on
      find tech jobs
      Expected: -Search results page should be loaded.
                -Page title should contain count of results , 
                along with search keyword.
                -Count of results should be displayed on the page.
      ====================
      Steps to automate:
        -Make sure you understand what functionality is being tested 
        and each step. What is expected, what is being tested.

        If you don't understand:  Ask manual tester/person who wrote it.
        BAs, Developers, Lead 

        -Manually test it and make sure , it is passing manually.
        And make sure no defects/bugs around it.
        -if a test case is failing manually, it does not qualify 
        for automation.

        --> starts automating:
        Java + Selenium + Maven + Git > Github
      =========================


    
  }
}
 */



public class DiceJobsearch {
	
	public static void main(String[] args) {
		//Set up chrome driver path
		WebDriverManager.chromedriver().setup();
		// invooke selenium webdriver
		WebDriver driver = new ChromeDriver();
		//fullcreen
		driver.manage().window().maximize();;//or fullscreen()
		
		
		//set universal wait time in case web page is slow
		//una ves que ve que esta bien continua enves de esperar
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url ="https://dice.com";
		driver.get(url);
		
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step Pass. Dice homepage succesfully loaded");
		}else {
			System.out.println("Step Fail. Dice homepage did not succesfully loaded ");
			throw new RuntimeException("Step Fail. Dice homepage did not succesfully loaded");
		}
		
		ArrayList<String> list = new ArrayList<String>();

       
            list .add("java");
            list.add("selenium");
            list.add("tester");
            list .add("c");
            list.add("developer");
            list.add("automation");
            list .add("Aerospace Engineer");
            list.add("Agricultural Engineer");
            list.add("Automotive Engineer");
            list.add("ABiomedical Engineer");
            list .add("Chemical Engineer");
            list.add("Civil Engineer");
            list.add("Computer Engineer");
            list .add("Drafting and Design Engineer");
            list.add("Electrical Engineer"); 
            	
            list.add("Environmental Engineer");
            list .add("Marine Engineer");
            list.add("Mechanical Engineer");
            list.add("Petroleum Engineer");
            list.add("Software Engineer");
            
        
       for (String keyword : list ){
           
       
		//String keyword ="java developer";
		
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		String location = "22102";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();;
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
	   int countResult = Integer.parseInt(count.replace("," ,""));
	   
	   if(countResult > 0) {
		   		System.out.println( "Step PASS: Keyword : " + keyword +" search returned " +
		   			countResult +" results in " + location);
		   	}else {
		   			System.out.println( "Step FAIL: Keyword : " + keyword +" search returned " +
		   				countResult +" results in " + location);
		   		}
		    		
	   driver.navigate().back();
		   	
		}
     
		   		
	
		   			
		
	}

}
