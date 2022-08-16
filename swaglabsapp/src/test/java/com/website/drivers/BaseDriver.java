package com.website.drivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver 
{
	public WebDriver driver;
	public InputStream inputstream;
	public Properties p;
	public WebDriverWait driverwait;
	
	public BaseDriver()
	{
		try {
			inputstream = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\swaglabsapp\\src\\test\\resources\\website\\files\\website.properties");
			p= new Properties();
			driver =null;
			
			p.load(inputstream);
			String browser =p.getProperty("browser");
			System.out.println("Currently the browser which is running is "+ browser);
			
			String chromepath = p.getProperty("chromepath");
			String firefoxpath =p.getProperty("firefoxpath");
			String edgepath =p.getProperty("edgepath");
			
			if(browser!=null && browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",chromepath);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				
			}
			else if(browser!=null && browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",firefoxpath );
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
			}
			else if(browser!=null && browser.equals("edge")) {
				System.setProperty("webdriver.edge.driver",edgepath );
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}

	public void takescreenshot(String name) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:\\Users\\Asus\\eclipse-workspace\\swaglabsapp\\src\\test\\resources\\website\\screenshots\\"+ name +".png"));
	}
	
	
 public void close()
    {
	driver.close();
 }
	
	
	
}
