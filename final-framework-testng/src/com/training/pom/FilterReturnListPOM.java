package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterReturnListPOM {
private WebDriver driver; 
	
	public FilterReturnListPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName; 

	@FindBy(name="password")
	private WebElement password;
	
	
	@FindBy(xpath="//button[text()=' Login']")
	private WebElement loginBtn; 
	
	@FindBy(className="fa-shopping-cart")
	private WebElement salesMenu;
	
	@FindBy(linkText="Returns")
	private WebElement returnsMenu;
	
	@FindBy(id="input-return-id")
	private WebElement return_id;
	
	@FindBy(id="button-filter")
	private WebElement filter_btn;
	
	@FindBy(id="input-customer")
	private WebElement customerName;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void sendRetunId(String returnId)
	{
		this.return_id.clear();
		this.return_id.sendKeys(returnId);
	}
	
	public void sendCustomerName(String cname)
	{
		this.customerName.clear();
		this.customerName.sendKeys(cname);
	}
	public void mouseOverSalesMenu()
	{
		Actions act=new Actions(this.driver);
		act.moveToElement(this.salesMenu).build().perform();
	}
	
	public void clickReturnsMenu()
	{
		this.returnsMenu.click();
	
	}
	
	public void clickFilterBtn()
	{
		this.filter_btn.click();
	}
	}

