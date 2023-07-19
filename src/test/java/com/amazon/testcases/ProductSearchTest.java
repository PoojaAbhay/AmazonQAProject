package com.amazon.testcases;

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

public class ProductSearchTest extends Base {
	public WebDriver driver;

	public ProductSearchTest() {

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



	@Test
	public void verify_Functionality_of_Searching_And_Adding_Item_To_The_Cart() throws InterruptedException {
		Homepage homepage = new Homepage(driver);
		homepage.EnterProductNameInSearchFieldAndClick(prop.getProperty("ProductName_1"));
		SearchPage searchpage = new SearchPage(driver);
		searchpage.tShirtDisplayed();
		Assert.assertTrue(searchpage.tShirtDisplayed());

		ProductPage productpage = new ProductPage(driver);
		productpage.addTshirtToCart();
		Thread.sleep(5000);
		//Assert.assertEquals(productpage.TshirtAddedToCartMessage(), prop.getProperty("Verify Message"));
		productpage.GoToCartAfterAddingTshirt();
		CartPage cartpage = new CartPage(driver);
		Assert.assertTrue(cartpage.ShoppingCartText());

		Assert.assertTrue(cartpage.TshirtInCart());

	}

}
