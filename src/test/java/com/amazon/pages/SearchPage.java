package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'Bedroom Furniture')]")
	private WebElement BedFurniture;

	@FindBy(xpath = "//a[@title='(30-68mm) - Krisler Adjustable Threaded Bed Frame Anti-Shake Tool, Headboard Stoppers, Bedside Anti Shake Tool for Beds Cabinets Sofas, 4PCs, 30-68mm']//span[@class='a-price-whole']")
	private WebElement SelectFurnitureProduct;

	@FindBy(xpath = "//span[normalize-space()='J. J. Keller SAFEGEAR Hi-Vis T-Shirt - Type R Class 2, CSA Z96-15 Compliant']")
	private WebElement TshirtDisplayed;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public Boolean tShirtDisplayed() {
		TshirtDisplayed.click();
		return TshirtDisplayed.isDisplayed();
	}

	public void ClickOnBedFurniture() {
		BedFurniture.click();
		
	}
	
  public void SelectFurnitureProduct() {
	SelectFurnitureProduct.click();
}

}