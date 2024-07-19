package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidatio() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		
		landingPage.loginApplication("shivakumar2@gmail.com", "Sangth#20");	
		String errMessage=landingPage.getErrorMessage();
		//Assert.assertTrue(errMessage.equalsIgnoreCase("Incorrect email1 or password."));
		Assert.assertEquals(errMessage, "Incorrect email1 or password.");					
	}
	
	@Test(groups= {"ErrorHandling"})
	public void productErrorValidation() throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		String productName = "ADIDAS ORIGINAL";	
		ProductCatalogue productCatalogue=landingPage.loginApplication("shivakumarn2@gmail.com", "Sangth#20");		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));	
		WebElement prod=productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);		
		CartPage cartPage=productCatalogue.goToCartPage();				
		Boolean match=cartPage.verifyProductDisplay("ADDIDAS ORIGINAL3");			
		Assert.assertFalse(match);
		
		
				
	}

}
