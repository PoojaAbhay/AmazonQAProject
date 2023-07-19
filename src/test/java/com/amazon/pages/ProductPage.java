package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement AddtoCartBedFurniture;

	@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private WebElement BedFurnitureAddedtoCartMesssage;

	@FindBy(xpath = "//a[@href='/cart?ref_=sw_gtc']")
	private WebElement GoToCartButtonAfterBedFurniture;

	@FindBy(xpath = "//span[normalize-space()='LINENSPA Mattress Storage Bag with Double Adhesive Closure - Fits Queen, Full and Full XL']")
	private WebElement AddAnotherProduct;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement AddTshirtToCart;
	
	@FindBy(xpath = "//a[@href='/cart?ref_=sw_gtc']")
	private WebElement GoToCartAfterTshirt;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement AddToCartAnotherProduct;
	
	@FindBy(xpath = "//b[normalize-space()='Amazon Coupons']")
	private WebElement AmazonCouponsPageText;
	
	
	
	@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private WebElement TshirtAddedToCartMessage;
	
	
	

	@FindBy(xpath = "//span[@id='a-autoid-7']//input[@type='submit']")
	private WebElement CouponButton;
	

	@FindBy(xpath = "//a[@href='/cart?ref_=sw_gtc']")
	private WebElement GotoCartAfterAnotherProduct;
	
	

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddtoCartBedFurniture() {

		AddtoCartBedFurniture.click();
	}

	public String BedFurnitureAddedtoCartMesssage() {

		return BedFurnitureAddedtoCartMesssage.getText();
	}

	public void GoToCartButtonAferBedFurniture() {

		GoToCartButtonAfterBedFurniture.click();
	}

	public void AddAnotherProduct() {

		AddAnotherProduct.click();
	}
	
	public void addTshirtToCart() {
		AddTshirtToCart.click();
	}
	
	public void GoToCartAfterAddingTshirt() {
		GoToCartAfterTshirt.click();
	}
	
	public String TshirtAddedToCartMessage() {
		return TshirtAddedToCartMessage.getText();
	}
	
	public Boolean AmazonCouponsPageText() {
		return AmazonCouponsPageText.isDisplayed();
	}
	
	public Boolean couponsDisplayed() {
		return CouponButton.isDisplayed();
	}
	
	public void clickCouponButton() {
		CouponButton.click();
	}
	
	public void AddToCartAnotherProduct() {
		AddToCartAnotherProduct.click();
	}
	public void GotoCartAfterAnotherProduct() {
		GotoCartAfterAnotherProduct.click();
	}
}
