package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterOrdersListPOM {
private WebDriver driver; 
	
	public FilterOrdersListPOM(WebDriver driver) {
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
	
	@FindBy(linkText="Orders")
	private WebElement ordersMenu;
	
	@FindBy(id="input-order-id")
	private WebElement order_id;
	
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
	
	public void sendOrderId(String orderId)
	{
		this.order_id.clear();
		this.order_id.sendKeys(orderId);
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
	
	public void clickOrdersMenu()
	{
		this.ordersMenu.click();
	
	}
	
	public void clickFilterBtn()
	{
		this.filter_btn.click();
	}
	}

