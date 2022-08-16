package com.website.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.website.drivers.BaseDriver;

public class LoginSwagLabs extends BaseDriver
{
	public WebElement testusername ;
	public WebElement testpassword ;
	public WebElement testlogin;
	
	
	public void geturl()
	{
		try
		{
			inputstream = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\swaglabsapp\\src\\test\\resources\\website\\files\\website.properties");
			p= new Properties();
			p.load(inputstream);
			String url = p.getProperty("url");
			driver.get(url);		
			driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void login() throws IOException, InterruptedException
	{
			driverwait =new WebDriverWait(driver, Duration.ofMillis(9000));
			inputstream = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\swaglabsapp\\src\\test\\resources\\website\\files\\website.properties");
			p = new Properties();
			p.load(inputstream);
					
			String sqlPass = p.getProperty("sqlPass");
			String sqlQuery = p.getProperty("sqlQuery");
			
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root",sqlPass);  

			System.out.println("connect to db");  

			String sql = sqlQuery;		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				
			{	
				driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("user-name")));
				testusername = driver.findElement(By.id("user-name"));
				
				driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("password")));
				testpassword = driver.findElement(By.name("password"));
				
				testusername.sendKeys(rs.getString(1));
				testpassword.clear();
				
				testpassword.sendKeys(rs.getString(2));
				testlogin = driver.findElement(By.cssSelector("#login-button"));					
				
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
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
