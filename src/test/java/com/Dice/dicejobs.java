package com.Dice;



	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	


	public class dicejobs {
	
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
			
			
			
			try (FileReader fr = new FileReader("jobs.txt"); 
				BufferedReader br = new BufferedReader(fr);) {
				String value;
				while ((value = br.readLine()) != null) {
					list.add(String.valueOf(value));
					
				}
			

			

	        
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
			   			System.out.println("JHonny");
			   		}
			    		
		   driver.navigate().back();
			   	
			}
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		
			   			
			
		}

	}


