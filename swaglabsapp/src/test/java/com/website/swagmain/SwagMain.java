package com.website.swagmain;

import java.io.IOException;

import com.website.pages.OrderPageSwag;

public class SwagMain {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		OrderPageSwag page = new OrderPageSwag();
		page.geturl();
		page.takescreenshot("login");
		page.login();
		page.takescreenshot("home");
		page.getproducts();
		page.addtocart();
		page.checkout();		
		page.confirmOrder();
		page.takescreenshot("order");
		page.logout();
		page.close();

	}

}
