package swaglabsapp;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabs {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webDriver.chromer.driver","C:/Users/Asus/OneDrive/Desktop/chromedriver_win32//chromedriver.exe");
		
		WebDriver driver = null ;
		driver = new ChromeDriver();
		
		WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofMillis(9000));
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		 try 
			{
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Omkar1998"); 
			//connecting to database
			 String sql = "SELECT * FROM omkar.swagrao";
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
	
				while(rs.next())
						
				{	
					driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("user-name")));
					WebElement testusername = driver.findElement(By.id("user-name"));
					
					driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("password")));
					WebElement testpassword = driver.findElement(By.name("password"));
					
					testusername.sendKeys(rs.getString(1));
					testpassword.clear();
					
					testpassword.sendKeys(rs.getString(2));
					WebElement testlogin = driver.findElement(By.cssSelector("#login-button"));					
					
					driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#login-button")));
					testlogin.submit();
								
					if(rs.getString(1).contentEquals("standard_user") && rs.getString(2).contentEquals("secret_sauce")) {
						break;
					}
					else {
				
					testusername.clear();
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS); //used impicit wait
					testpassword.clear();
					Thread.sleep(2000);
					}
					
				}
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				File ss = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(ss, new File ("test.png"));

	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 WebElement testdropdown = driver.findElement(By.className("product_sort_container")); // finding elements using By.className
			testdropdown.click();
			Thread.sleep(1000);
			
			Select sortinglist = new Select (testdropdown);
			sortinglist.selectByVisibleText("Name (Z to A)"); //Selecting By visible text.
			Thread.sleep(2000);
			
			WebElement product = driver.findElement(By.className("title"));  // Using getText method
			System.out.println(product.getText());
			
			WebElement swagelement = driver.findElement(By.partialLinkText("Backpack"));  // By.partialLinkText
			swagelement.click();
			Thread.sleep(2000);
			
			WebElement backtoproducts = driver.findElement(By.name("back-to-products")); // finding elements using By.name
			backtoproducts.click();
			Thread.sleep(2000);
			
			WebElement swagbag = driver.findElement(By.linkText("Sauce Labs Backpack"));  // By.LinkText
			swagbag.click();
			Thread.sleep(2000);
			
			WebElement addtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")); // finding elements using By.id
			addtocart.click();
			Thread.sleep(2000);
			
			WebElement cartlink = driver.findElement(By.className("shopping_cart_link")); // finding elements using By.className
			cartlink.click();
			Thread.sleep(2000);
			
			WebElement continueshop = driver.findElement(By.cssSelector("#continue-shopping")); // finding elements using By.cssSelector
			continueshop.click();
			
			WebElement addtocart2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")); // finding elements using By.id
			addtocart2.click();
			Thread.sleep(2000);
			
			WebElement cartlink2 = driver.findElement(By.className("shopping_cart_link")); // finding elements using By.className
			cartlink2.click();
			Thread.sleep(2000);
			
			WebElement checkout= driver.findElement(By.name("checkout")); // finding elements using By.name
			checkout.click();
			Thread.sleep(2000);
			
			WebElement firstname = driver.findElement(By.id("first-name")); // finding elements using By.id
			firstname.sendKeys("Omkar");
			Thread.sleep(2000);
			
			WebElement lastname = driver.findElement(By.id("last-name")); // finding elements using By.id
			lastname.sendKeys("Khismatrao");
			Thread.sleep(2000);
			
			WebElement zipcode = driver.findElement(By.name("postalCode")); // finding elements using By.name
			zipcode.sendKeys("421301");
			Thread.sleep(2000);
			
			WebElement continueorder = driver.findElement(By.name("continue")); // finding elements using By.name
			continueorder.click();
			Thread.sleep(2000);
			
			WebElement finish = driver.findElement(By.cssSelector("#finish")); // finding elements using By.cssSelector
			finish.click();
			Thread.sleep(2000);
			
			WebElement backtohome = driver.findElement(By.id("back-to-products")); // finding elements using By.id
			backtohome.click();
			Thread.sleep(2000);
			
			WebElement options = driver.findElement(By.id("react-burger-menu-btn")); // finding elements using By.id
			options.click();
			Thread.sleep(2000);
			
			WebElement logout = driver.findElement(By.id("logout_sidebar_link")); // finding elements using By.id
			logout.click();
			Thread.sleep(2000);
			
			Actions action = new Actions(driver);  // By using actions
			action.contextClick().perform();
			Thread.sleep(2000);
			
			driver.close();
			

	}

}
