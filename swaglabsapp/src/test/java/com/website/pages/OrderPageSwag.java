package com.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderPageSwag extends HomePageSwag
{
	WebElement addtocart;
	WebElement cartlink;
	WebElement continueshop;
	WebElement addtocart2;
	WebElement cartlink2;
	WebElement checkout;
	WebElement firstname;
	WebElement lastname;
	WebElement zipcode;
	WebElement continueorder;
	WebElement finish;
	WebElement backtohome ;
	WebElement options ;
	WebElement logout;
	
	public void addtocart() throws InterruptedException 
	{
		addtocart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")); // finding elements using By.id
		addtocart.click();
		Thread.sleep(2000);
		
		cartlink = driver.findElement(By.className("shopping_cart_link")); // finding elements using By.className
		cartlink.click();
		Thread.sleep(2000);
		
		continueshop = driver.findElement(By.cssSelector("#continue-shopping")); // finding elements using By.cssSelector
		continueshop.click();
		
		addtocart2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")); // finding elements using By.id
		addtocart2.click();
		Thread.sleep(2000);
		
		cartlink2 = driver.findElement(By.className("shopping_cart_link")); // finding elements using By.className
		cartlink2.click();
		Thread.sleep(2000);
	}
	
	public void checkout() throws InterruptedException
	{
		checkout= driver.findElement(By.name("checkout")); // finding elements using By.name
		checkout.click();
		Thread.sleep(2000);
		
		firstname = driver.findElement(By.id("first-name")); // finding elements using By.id
		firstname.sendKeys("Omkar");
		Thread.sleep(2000);
		
		lastname = driver.findElement(By.id("last-name")); // finding elements using By.id
		lastname.sendKeys("Khismatrao");
		Thread.sleep(2000);
		
		zipcode = driver.findElement(By.name("postalCode")); // finding elements using By.name
		zipcode.sendKeys("421301");
		Thread.sleep(2000);
	}
	
	public void confirmOrder() throws InterruptedException 
	{
	
	continueorder = driver.findElement(By.name("continue")); // finding elements using By.name
	continueorder.click();
	Thread.sleep(2000);
	
	finish = driver.findElement(By.cssSelector("#finish")); // finding elements using By.cssSelector
	finish.click();
	Thread.sleep(2000);
	
	}
	
	public void logout() throws InterruptedException
	{
	backtohome = driver.findElement(By.id("back-to-products")); // finding elements using By.id
	backtohome.click();
	Thread.sleep(2000);
	
	options = driver.findElement(By.id("react-burger-menu-btn")); // finding elements using By.id
	options.click();
	Thread.sleep(2000);
	
	logout = driver.findElement(By.id("logout_sidebar_link")); // finding elements using By.id
	logout.click();
	Thread.sleep(2000);	
	}
	
	
}
