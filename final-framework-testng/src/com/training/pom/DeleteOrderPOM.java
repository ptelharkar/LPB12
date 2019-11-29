package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrderPOM {
	private WebDriver driver; 
	
	public DeleteOrderPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr/td/input")
	private WebElement tableRow;
	
	@FindBy(id="button-delete")
	private WebElement delete_btn;
	
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
	
	public void mouseOverSalesMenu()
	{
		Actions act=new Actions(this.driver);
		act.moveToElement(this.salesMenu).build().perform();
	}
	
	public void clickOrdersMenu()
	{
		this.ordersMenu.click();
	
	}
	
	public void selectRow()
	{
		this.tableRow.click();
		
	}
	public void deleteRow()
	{
		this.tableRow.click();
	}
	
	public void clickDeleteBtn()
	{
		this.delete_btn.click();
	}
	
	public void clickOkBtn()
	{
		this.driver.switchTo().alert().accept();
		
	}
	
	}

