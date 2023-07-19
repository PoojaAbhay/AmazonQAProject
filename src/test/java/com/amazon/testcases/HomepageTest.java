package com.amazon.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.pages.Homepage;
import com.amazon.pages.SearchPage;

public class HomepageTest extends Base {
	public WebDriver driver;
	Homepage homepage;

	public HomepageTest() {
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
	public void basic_Test_To_Validate_Homepage() {

		homepage = new Homepage(driver);

		Assert.assertTrue(homepage.navigationBarDisplayed());

		Assert.assertTrue(homepage.SignInButtonDisplayed());

		Assert.assertTrue(homepage.LogoDisplayed());

		Assert.assertTrue(homepage.ShoppingCartDisplayed());

		homepage.EnterProductNameInSearchFieldAndClick(prop.getProperty("ProductName_1"));
		SearchPage searchpage = new SearchPage(driver);

		Assert.assertTrue(searchpage.tShirtDisplayed());

	}

}
