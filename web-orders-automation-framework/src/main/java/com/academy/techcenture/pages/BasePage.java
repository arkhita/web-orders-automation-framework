package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }
    @FindBy(tagName =  "h1")
    protected WebElement pageMainHeader;

    @FindBy(xpath = "//div[@class ='login_info'] ")
    protected WebElement welcomeUser;

    @FindBy(id ="ctl00_logout")
    protected WebElement logoutBtn;

    @FindBy(xpath = "//a[text() ='View all orders']")
    protected WebElement viewAllOrdersLink;

    @FindBy(xpath = "//a[text() ='View all products']")
    protected WebElement viewAllProductsLink;

    @FindBy(xpath = "//a[text() ='Order']")
    protected WebElement orderLink;

    public void goToOrderLink(){
        Assert.assertTrue(orderLink.isEnabled());
        orderLink.click();


    }
    public void goToViewAllOrdersLink(){
        Assert.assertTrue(viewAllOrdersLink.isEnabled());
        viewAllOrdersLink.click();
    }
    public void goToViewAllProductsLink(){
        Assert.assertTrue(viewAllProductsLink.isEnabled());
        viewAllProductsLink.click();
    }

    public void logout(){
        Assert.assertTrue(logoutBtn.isEnabled());
        logoutBtn.click();
    }

}
