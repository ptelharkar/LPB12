package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-user")
	private WebElement user_icon;
	
	@FindBy(id="email")
	private WebElement userName; 

	@FindBy(id="pass")
	private WebElement password;
	
//	@FindBy(id="login")
//	private WebElement userName; 
//	
//	@FindBy(id="password")
//	private WebElement password;
	
	@FindBy(id="send2")
	private WebElement loginBtn;
	
//	@FindBy(id="formLogin_submitAuth")
//	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickUserIcon()
	{
		this.user_icon.click();
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
		
	}
	
	
}
