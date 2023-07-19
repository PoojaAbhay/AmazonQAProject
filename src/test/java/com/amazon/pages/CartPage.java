package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	@FindBy(xpath = "//h1[normalize-space()='Shopping Cart']")
	private WebElement ShoppingCartText;

	@FindBy(xpath = "//span[@class='a-truncate-cut'][contains(text(),'(30-68mm) - Krisler Adjustable Threaded Bed Frame ')]")
	private WebElement BedFurnitureProductInCart;

	@FindBy(xpath = "//span[@class='a-truncate-cut'][normalize-space()='Spark City: Book One of the Spark City Cycle']")
	private WebElement SecondProductInCart;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[3]/div[5]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[2]/div[1]/span[2]/span[1]/input[1]")
	private WebElement RemoveProductButton;

//	@FindBy(xpath = "//h1[@class='a-spacing-mini a-spacing-top-base']")
//	private WebElement ProductRemovedMessage;

	@FindBy(xpath = "//h1[@class=\"a-spacing-mini a-spacing-top-base\"]")
	private WebElement RemovedProducrMessage;
	
	//span[@class='a-truncate-cut'][contains(text(),'SAFEGEAR 3XL Orange High Vis T-Shirt - Type R Clas')]
	
	@FindBy(xpath = "//span[@class='a-truncate-cut'][contains(text(),'SAFEGEAR 3XL Orange High Vis T-Shirt - Type R Clas')]")
	private WebElement TshirtInCart;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean ShoppingCartText() {
		return ShoppingCartText.isDisplayed();
	}

	public Boolean BedFurnitureProductInCart() {
		return BedFurnitureProductInCart.isDisplayed();
	}
	
	public void RemoveProductButton() {
		RemoveProductButton.click();
		
	}
	
	public Boolean TshirtInCart() {
		return TshirtInCart.isDisplayed();
	}
	public Boolean CartEmptyMessage() {
	 return RemovedProducrMessage.isDisplayed();
	}
	

}