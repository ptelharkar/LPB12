package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterOrderDetailsPOM {
private WebDriver driver; 
	
	public FilterOrderDetailsPOM(WebDriver driver) {
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
	
	@FindBy(id="input-total")
	private WebElement total;
	
	@FindBy(xpath="//div[@class='row']/div[3]/div/div/span/button/i")
	private WebElement dateAdded;
	
	@FindBy(xpath="//div[@class='row']/div[3]/div[2]/div/span/button/i")
	private WebElement dateMod;
	
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
	
	public void sendTotal(String total)
	{
		this.total.clear();
		this.total.sendKeys(total);
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
	
	public void selectOrderStatus(String orderStat)
	{
		Select status=new Select(this.driver.findElement(By.id("input-order-status")));
		status.selectByVisibleText(orderStat);
		
	}	
		
	public void clickDateAddedBtn()
	{
		this.dateAdded.click();
	}
	
	public void clickDateModifiedBtn()
	{
		this.dateMod.click();
	}
	
	public void selectAddedDate(String day, String month,String year) throws InterruptedException
	{
		this.driver.findElement(By.xpath("//div[@class='datepicker']/div/table/thead/tr/th[@class='picker-switch']")).click();
		Thread.sleep(3000);
		this.driver.findElement(By.xpath("//div[2]/div/div[2]/table/thead/tr/th[@class='picker-switch']")).click();
		this.driver.findElement(By.xpath("//div[2]/div/div[3]/table/tbody/tr/td/span[text()='"+year+"']")).click();
		this.driver.findElement(By.xpath("//div[2]/div/div[2]/table/tbody/tr/td/span[text()='"+month+"']")).click();
		this.driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[text()='"+day+"']")).click();
		
		
	}
	
	public void selectModDate(String day, String month, String year) throws InterruptedException
	{
		this.driver.findElement(By.xpath("//div[3]/div/div/table/thead/tr/th[@class='picker-switch']")).click();
		Thread.sleep(3000);
		this.driver.findElement(By.xpath("//div[3]/div/div[2]/table/thead/tr/th[@class='picker-switch']")).click();
		this.driver.findElement(By.xpath("//div[3]/div/div[3]/table/tbody/tr/td/span[text()='"+ year + "']")).click();
		this.driver.findElement(By.xpath("//div[3]/div/div[2]/table/tbody/tr/td/span[text()='"+ month + "']")).click();
		this.driver.findElement(By.xpath("//div[3]/div/div[1]/table/tbody/tr/td[text()='" + day + "']")).click();
		
		
	}
}
