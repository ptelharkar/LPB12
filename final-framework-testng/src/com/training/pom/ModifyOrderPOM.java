package com.training.pom;

import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class ModifyOrderPOM 
{
private WebDriver driver; 
	
	public ModifyOrderPOM(WebDriver driver) 
	{
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
	
	@FindBy(className="fa-pencil")
	private WebElement edit_btn;
	
	@FindBy(id="button-customer")
	private WebElement custContinueBtn;
	
	@FindBy(className="fa-minus-circle")
	private WebElement removeProductBtn;
	
	@FindBy(id="input-product")
	private WebElement product_input;
	
	@FindBy(id="input-quantity")
	private WebElement quantity_input;
	
	@FindBy(id="button-product-add")
	private WebElement prodAddBtn;
	
	@FindBy(id="button-cart")
	private WebElement cartBtn;
	
	@FindBy(id="button-payment-address")
	private WebElement paymentContinueBtn;
	
	@FindBy(id="button-shipping-address")
	private WebElement shipAddressBtn;
	
	@FindBy(id="button-save")
	private WebElement saveBtn;
	
	@FindBy(className="alert-success")
	private WebElement successMsg;
	
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
	
	public void selectRow(String orderId)
	{
		List <WebElement> rows= this.driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"));
		
		for(WebElement row:rows)
		{
			
			if(row.findElements(By.tagName("td")).get(1).getText().equals(orderId))
			{
				row.findElements(By.tagName("td")).get(0).click();
				row.findElement(By.className("fa-pencil")).click();
				
				break;
			}
		}
		
	}
		
	
	public void clickEditBtn()
	{
		this.edit_btn.click();
	}
	
	public void clickCustContinueBtn()
	{
		this.custContinueBtn.click();
	}
	
	public void clickRemoveProductBtn()
	{
		this.removeProductBtn.click();
	}
	
	public void sendProductName(String productName) 
	{
		this.product_input.clear();
		this.product_input.sendKeys(productName);
		this.driver.findElement(By.linkText(productName)).click();
	}
	
	public void sendQuantity(String quantity)
	{
		this.quantity_input.clear();
		this.quantity_input.sendKeys(quantity);
		
	}
	
	public void clickproductAddBtn()
	{
		this.prodAddBtn.click();
	}
	
	public void clickCartBtn()
	{
		this.cartBtn.click();
	}
	
	public void clickPaymentContBtn()
	{
		this.paymentContinueBtn.click();
	}
	
	public void clickshipAddressBtn()
	{
		this.shipAddressBtn.click();	
	}
	
	public void clickSaveBtn()
	{
		this.saveBtn.click();
	}
	
	public void shippingMethod(String shipMethod)
	{
		Select shipmethod = new Select(this.driver.findElement(By.id("input-shipping-method")));
		shipmethod.selectByVisibleText(shipMethod);
		
	}

	public void checkProductSuccessMsg(String expSuccessMsg)
	{
		Assert.assertTrue(this.successMsg.getText().contains(expSuccessMsg));
	}
	
	public void retrieveProdDetails()
	{
		String sql = "select prodName, Price, Quantity from Products;";
	    
	    GetConnection gc  = new GetConnection(); 
	    
	    try {
	        gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
	        gc.rs1 = gc.ps1.executeQuery(); 
	        
	        while(gc.rs1.next())
	        {
	         System.out.println("Product Name is: "+gc.rs1.getString(1));
	         System.out.println("Price is: "+gc.rs1.getDouble(2));
	         System.out.println("Quantity: "+gc.rs1.getInt(3));
	            
	        }
	    }
	     
	catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	    
	    
		}
	
	
}
