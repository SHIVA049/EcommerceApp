package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
    
	//String productName = "ADIDAS ORIGINAL";	
	//public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException{
	@Test(dataProvider="getData",groups="Purchase")
	public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException{
	//public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(email, password );		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	
		WebElement prod=productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);	
		
		CartPage cartPage=productCatalogue.goToCartPage();				
		Boolean match=cartPage.verifyProductDisplay(productName);			
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage=checkoutPage.placeOrder();	
		String confirmMessage=confirmationPage.getConfirmationMessage();	
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
				
	}
	
	
	@Test(dependsOnMethods= {"submitOrder"},dataProvider="getData")
	public void OrderHistoryTest(String email, String password, String productName) {
		
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(email, password);		
		OrdersPage orderPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));	
	}
	
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		/*HashMap<Object, Object> map =new HashMap<Object, Object>();
		map.put("email", "shivakumarn2@gmail.com");
		map.put("password","Sangth#20");
		map.put("productName", "ADIDAS ORIGINAL"); */
		
		/*HashMap<Object, Object> map1 =new HashMap<Object, Object>();
		map.put("email", "shiva2@gmail.com");
		map.put("password","Sangth#20");
		map.put("productName", "ZARA COAT 3"); */
		
		/*List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)} }; */
		
		return new Object[][] {{"shivakumarn2@gmail.com","Sangth#20","ADIDAS ORIGINAL"},{"shiva2@gmail.com","Sangth#20","ZARA COAT 3"}};
		
	}

}
