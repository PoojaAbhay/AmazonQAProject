package com.amazon.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pages.CartPage;
import com.amazon.pages.Homepage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchPage;

public class ShoppingCartTest extends Base {

	private static final Logger logger = LogManager.getLogger(ShoppingCartTest.class);

	public WebDriver driver;
	Homepage homepage;
	CartPage cartpage;
	SearchPage searchpage;
	ProductPage productpage;
	public ShoppingCartTest() {
		super();
	}
	@BeforeClass
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));

	}



	@AfterClass
	public void Closure() {

		driver.quit();

	}



	@Test(priority = 1)
	public void verify_Functionality_of_Adding_Item_To_The_Cart() throws InterruptedException {

		logger.info("Started");
		homepage = new Homepage(driver);
		homepage.ClickOnHomeButton();

		searchpage = new SearchPage(driver);
		searchpage.ClickOnBedFurniture();
		searchpage.SelectFurnitureProduct();

		productpage = new ProductPage(driver);
		Thread.sleep(10000);

		logger.info("Bed furniture product added to cart");
		productpage.AddtoCartBedFurniture();

		Assert.assertEquals(productpage.BedFurnitureAddedtoCartMesssage(), "Added to Cart");

		productpage.GoToCartButtonAferBedFurniture();

		cartpage = new CartPage(driver);
		Assert.assertTrue(cartpage.ShoppingCartText());

		Assert.assertTrue(cartpage.BedFurnitureProductInCart());

	}

	@Test(priority = 2)
	public void verify_Functionality_of_Removing_Item_From_The_Cart() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.ClickOnHomeButton();

		SearchPage searchpage = new SearchPage(driver);
		searchpage.ClickOnBedFurniture();
		searchpage.SelectFurnitureProduct();

		ProductPage productpage = new ProductPage(driver);
		Thread.sleep(10000);
		productpage.AddtoCartBedFurniture();

		Assert.assertEquals(productpage.BedFurnitureAddedtoCartMesssage(), "Added to Cart");

		productpage.GoToCartButtonAferBedFurniture();

		cartpage = new CartPage(driver);
		Assert.assertTrue(cartpage.ShoppingCartText());

		Assert.assertTrue(cartpage.BedFurnitureProductInCart());
		Thread.sleep(5000);
		cartpage.RemoveProductButton();
		Thread.sleep(10000);
		System.out.println(cartpage.CartEmptyMessage());
	}

	@Test(priority = 3)
	public void verify_Functionality_of_Adding_Multiple_Item_To_The_Cart() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.ClickOnHomeButton();

		SearchPage searchpage = new SearchPage(driver);
		searchpage.ClickOnBedFurniture();
		searchpage.SelectFurnitureProduct();

		ProductPage productpage = new ProductPage(driver);
		Thread.sleep(10000);
		productpage.AddtoCartBedFurniture();

		Assert.assertEquals(productpage.BedFurnitureAddedtoCartMesssage(), "Added to Cart");

		homepage.ClickOnHomeButton();
		searchpage.ClickOnBedFurniture();
		productpage.AddAnotherProduct();
		productpage.AddToCartAnotherProduct();
		homepage.ShoppingCartDisplayed();

	}

}
