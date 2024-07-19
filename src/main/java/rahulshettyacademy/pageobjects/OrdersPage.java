package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> orderedItem;
    
    @FindBy(css=".totalRow button")
    WebElement checkoutEle;
    
    
    public Boolean verifyOrderDisplay(String productName) {
    	
    	Boolean match=orderedItem.stream().anyMatch(orderItem->orderItem.getText().equalsIgnoreCase(productName));
    	return match;
    }
    
    
   
    
    
    
}
