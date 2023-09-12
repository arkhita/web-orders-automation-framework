package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ViewAllOrdersPage extends BasePage {



    public ViewAllOrdersPage(WebDriver driver) {
        super(driver);

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

    @FindBy(tagName = "h2")
    protected WebElement viewAllOrdersPageHeader;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    protected WebElement checkAllBtn;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    protected WebElement uncheckAllBtn;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    protected WebElement deleteBtn;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']")
    protected WebElement tableOfAllOrders;

    public void verifyUserIsOnViewAllOrdersPage(){
        Assert.assertTrue(viewAllOrdersPageHeader.isDisplayed());
    }


    public void verifyOrderInAllOrders(String customer, String product, int quantity){
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(1).findElements(By.tagName("td"));

        String customerNameWeb = cells.get(1).getText();
        Assert.assertEquals(customerNameWeb, customer);

        String productNameWeb = cells.get(2).getText();
        Assert.assertEquals(productNameWeb,product);
        String quantityWebText = cells.get(3).getText();
        int quantityWeb = Integer.parseInt(quantityWebText);
        Assert.assertEquals(quantityWeb, quantity);


    }

}
