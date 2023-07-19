package com.amazon.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pages.Homepage;
import com.amazon.pages.ProductPage;

public class CouponsTest extends Base {
	public WebDriver driver;

	public CouponsTest() {

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
	public void verify_availability_of_coupons() {

		Homepage homepage = new Homepage(driver);
		homepage.clickCouponButton();
		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.AmazonCouponsPageText());
		Assert.assertTrue(productpage.couponsDisplayed());
		productpage.clickCouponButton();

	}

}
