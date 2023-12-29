package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackLoginPage {

    public VytrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "prependedInput")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginBtn;

    public void loginAsDriver(){
       userName.sendKeys(ConfigurationReader.getProperty("driver.username"));
        password.sendKeys(ConfigurationReader.getProperty("driver.password"));
       loginBtn.click();
    }
    public void loginAsSalesManager(){
        userName.sendKeys(ConfigurationReader.getProperty("sales_manager.username"));
        password.sendKeys(ConfigurationReader.getProperty("sales_manager.password"));
        loginBtn.click();
    }
    public void loginAsStoreManager(){
        userName.sendKeys(ConfigurationReader.getProperty("store_manager.username"));
        password.sendKeys(ConfigurationReader.getProperty("store_manager.password"));
        loginBtn.click();
    }
}
