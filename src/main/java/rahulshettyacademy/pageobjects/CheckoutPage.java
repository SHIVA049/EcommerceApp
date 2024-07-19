package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
    @FindBy(css="input[placeholder='Select Country']")
	WebElement country;
    
    By dropDownResults= By.cssSelector(".ta-results");
    
    @FindBy(xpath="//button[contains(@class,'ta-item')][2]")
    WebElement dropDownCountrySel;
    
    @FindBy(xpath="//a[normalize-space()='Place Order']")
    WebElement orderPlacement;
    
    @FindBy(css=".totalRow button")
    WebElement checkoutEle;
    
   
    //code to Select the Country
    
    public void selectCountry(String countryName) {
    	
    	Actions action = new Actions(driver);
    	action.sendKeys(country, countryName).build().perform();
    	waitForElementToAppear(dropDownResults);
    	dropDownCountrySel.click();
    }
    
    
    public ConfirmationPage placeOrder() {
    	
    	Actions action = new Actions(driver);
    	action.moveToElement(orderPlacement).click().build().perform();
    	//orderPlacement.click();
    	ConfirmationPage confirmationPage=new ConfirmationPage(driver);
    	return confirmationPage;
    	
    }
    
    
    
   
    
    
    
}
