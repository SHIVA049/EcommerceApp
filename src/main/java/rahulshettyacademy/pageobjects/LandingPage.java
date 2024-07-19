package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
    @FindBy(id="userEmail")
	WebElement userEmail;
    
    @FindBy(id="userPassword")
    WebElement password;
    
    @FindBy(id="login")
    WebElement submit;
    
    @FindBy(css="div[aria-label='Incorrect email or password.']")
    WebElement errorMessage;
    
    public ProductCatalogue loginApplication(String email, String pasword) {
    	
    	userEmail.sendKeys(email);
    	password.sendKeys(pasword);
    	submit.click();
    	ProductCatalogue productCatalogue= new ProductCatalogue(driver);
    	return productCatalogue;
    	
    }
    
    public void goTo() {
    	
    	driver.get("https://rahulshettyacademy.com/client/");
    }
    
    public String getErrorMessage() {
    	
    	
    	waitForWebElementToAppear(errorMessage);
    	String errorMessage1=errorMessage.getText();
    	return errorMessage1;
    	
    }
    
    
    
}
