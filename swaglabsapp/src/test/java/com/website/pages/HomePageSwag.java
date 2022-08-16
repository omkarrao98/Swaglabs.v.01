package com.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePageSwag extends LoginSwagLabs
{
	WebElement testdropdown;
	WebElement product;
	WebElement swagelement;
	WebElement backtoproducts;
	WebElement swagbag;
	
	public void getproducts() throws InterruptedException
	{
		 	testdropdown = driver.findElement(By.className("product_sort_container")); // finding elements using By.className
			testdropdown.click();
			Thread.sleep(1000);
			
			Select sortinglist = new Select (testdropdown);
			sortinglist.selectByVisibleText("Name (Z to A)"); //Selecting By visible text.
			Thread.sleep(2000);
			
			product = driver.findElement(By.className("title"));  // Using getText method
			System.out.println(product.getText());
			
			swagelement = driver.findElement(By.partialLinkText("Backpack"));  // By.partialLinkText
			swagelement.click();
			Thread.sleep(2000);
			
			backtoproducts = driver.findElement(By.name("back-to-products")); // finding elements using By.name
			backtoproducts.click();
			Thread.sleep(2000);
			
			swagbag = driver.findElement(By.linkText("Sauce Labs Backpack"));  // By.LinkText
			swagbag.click();
			Thread.sleep(2000);
	}
}
