package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateCategoryPOM 
{
private WebDriver driver; 
	
	public CreateCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName; 

	@FindBy(name="password")
	private WebElement password;
	
	
	@FindBy(xpath="//button[text()=' Login']")
	private WebElement loginBtn; 
	
	@FindBy(className="fa-tags")
	private WebElement catalogMenu;
	
	@FindBy(linkText="Categories")
	private WebElement categoriesMenu;
	
	@FindBy(linkText="Products")
	private WebElement productsMenu;
	
	
	@FindBy(className="fa-plus")
	private WebElement addNewBtn;
	
	@FindBy(name="category_description[1][name]")
	private WebElement catName;
	
	@FindBy(className="note-editable")
	private WebElement catDescription;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement metaTagDesc;
	
	@FindBy(className="fa-save")
	private WebElement saveBtn;
	
	@FindBy(className="alert-success")
	private WebElement successMsg;
	
	@FindBy(linkText="Links")
	private WebElement linkTab;
	
	@FindBy(linkText="Data")
	private WebElement dataTab;
			
	@FindBy(id="input-category")
	private WebElement input_Category;
	
			
	@FindBy(id="input-model")
	private WebElement input_Model;
	
	
	@FindBy(name="product_description[1][name]")
	private WebElement productName;
	
	
	
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
	
		
	
	public void mouseOverCatelogMenu()
	{
		Actions act=new Actions(this.driver);
		act.moveToElement(this.catalogMenu).build().perform();
	}
	
	public void clickCategoriesMenu()
	{
		this.categoriesMenu.click();
	
	}
	
	public void clickAddNewBtn()
	{
		this.addNewBtn.click();
	}
	
	public void sendCatName(String catName)
	{
		this.catName.clear();
		this.catName.sendKeys(catName);
	}
	
	public void sendCatDesc(String catDesc)
	{
		this.catDescription.clear();
		this.catDescription.sendKeys(catDesc);
	}
	
	public void sendMetaTagTitle(String metaTagTitle)
	{
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
	}
	
	public void sendMetaTagDesc(String metaTagDesc)
	{
		this.metaTagDesc.clear();
		this.metaTagDesc.sendKeys(metaTagDesc);
	}
	
	public void clickSaveBtn()
	{
		this.saveBtn.click();
	}
	
		
	public void checkSuccessMsg(String expSuccessMsg)
	{
		Assert.assertTrue(this.successMsg.getText().contains(expSuccessMsg));
	}
	
	public void clickProductsMenu()
	{
		this.productsMenu.click();
	
	}
	
	public void sendProductName(String prodName)
	{
		this.productName.clear();
		this.productName.sendKeys(prodName);
	}
	
	public void clickLinkTab()
	{
		this.linkTab.click();
	}
	
	public void clickDataTab()
	{
		this.dataTab.click();
	}
	
	public void selectCategory(String category)
	{
		this.input_Category.clear();
		this.input_Category.sendKeys(category);
		this.driver.findElement(By.linkText(category)).click();
					
		
	}
	
	public void sendModel(String model)
	{
		this.input_Model.clear();
		this.input_Model.sendKeys(model);
	}
	
	public void checkProductSuccessMsg(String expSuccessMsg)
	{
		Assert.assertTrue(this.successMsg.getText().contains(expSuccessMsg));
	}

}
