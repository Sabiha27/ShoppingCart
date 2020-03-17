package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends LoginOR {
	public WebDriver driver;
	public LoginPage(WebDriver driver,ExtentTest childTest){
		super(driver);
		this.driver=driver;
	}
	
	public void redirectToOtherPage(String url){
		driver.navigate().to(url);
	}
	
	public void forword(){
		driver.navigate().forward();
	}
	
	public void back(){
		driver.navigate().back();
	}
	
	public void refresh(){
		driver.navigate().refresh();
	}
	
	public String checkCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public String checkLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateHeadFacebookText(WebElement element){
		
		return element.isDisplayed();
	}
	
	
	

	public HomePage login(String un,String pwd){
	
		emailTxt.sendKeys(un);	
		passTxt.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
	}
	
	
	
	
	
	}
	
	

